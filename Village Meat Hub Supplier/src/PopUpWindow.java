import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyListener;

public class PopUpWindow extends JFrame
{
	private JTextField first,second;
	private JButton button;
	private String bill=null;
	
	public String GenerateInvoiceNumber()
	{
		String id = null;
		
			
			try
			{
			Class.forName("org.sqlite.JDBC");
			Connection con=DriverManager.getConnection("jdbc:sqlite:meathub.db");
		    PreparedStatement pts=con.prepareStatement("select max(bill_no) from customer_trans_table");
			ResultSet ps=pts.executeQuery();
			while(ps.next())
			{
			
				id=ps.getString(1);
			}
			
			if(id==null)
			{
				id="E-0000001";
			}
			else
			{
			   long val=Long.parseLong(id.substring(3));
			   val++;
			   id= "E-"+String.valueOf(String.format("%07d", val));
		
			
			 
			}
			con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		  return id;
		
			
		
	}
	   public PageFormat getPageFormat(PrinterJob pj)
	    {
	        PageFormat pf=pj.defaultPage();
	        Paper paper=pf.getPaper();
	        double middleHeight=8.0;
	        double headerHeight=2.0;
	        double footerHeight=2.0;
	        double width=convert_CM_To_PPT(12);
	        double height=convert_CM_To_PPT(headerHeight+middleHeight+footerHeight);
	        paper.setSize(width,height);
	        paper.setImageableArea(
	        0,
	        10,
	        width,
	        height-convert_CM_To_PPT(1)
	        );
	        pf.setOrientation(PageFormat.PORTRAIT);
	        pf.setPaper(paper);
	        return pf;
	    }
	       
	        protected static double convert_CM_To_PPT(double dd)
	    {
	        return toPPT(dd*0.393600787);
	    }
	    protected static double toPPT(double inch)
	    {
	        return inch*72d;
	    }
  public PopUpWindow(double sum)
  {
	  
	  first=new JTextField("Enter Amount...");
	  first.setBounds(10,10,250,30);
	  first.addFocusListener(new FocusListener()
	  {

		@Override
		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			first.setText("");
			
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub
			
			
		}
		  
	  });
	  first.addKeyListener(new KeyListener() {

		@Override
		public void keyPressed(KeyEvent arg0)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0)
		{
			if(first.getText().equals(""))
			{
				double amount=0;
				double remain=amount-sum;
				second.setText(String.valueOf(remain));
			}
			else
			{
				double amount=Double.parseDouble(first.getText());
				double remain=amount-sum;
				second.setText(String.valueOf(remain));
			}
			
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	  
	  });
	    first.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = first.getText();
	            int l = value.length();
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode()==KeyEvent.VK_BACK_SPACE || ke.getKeyChar()=='.') {
	               first.setEditable(true);
	            } else {
	            	JOptionPane.showMessageDialog(null, "please enter only numeric data");
	               String orginal=first.getText();
	               int len=orginal.length();
	               String org=orginal.substring(0,len-1);
	               first.setText(org);
	               
	            }
	         }
	      });
	  
	  
	  second=new JTextField("Change Amount...");
	  second.setBounds(10,45,250,30);
	  second.addFocusListener(new FocusListener() {

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			second.setText("");
			
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}
		  
	  });
	  
	  button=new JButton("Print");
	  button.setBounds(10,85,250,30);
	  button.addActionListener(new ActionListener() 
	  {

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			String bill=GenerateInvoiceNumber();
			java.util.Calendar cal = Calendar.getInstance();
			java.util.Date utilDate = new java.util.Date(); // your util date
			cal.setTime(utilDate);    
			java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());
			// TODO Auto-generated method stub
			
			try
			{
				Class.forName("org.sqlite.JDBC");
				Connection conn=DriverManager.getConnection("jdbc:sqlite:meathub.db");
				PreparedStatement pst=conn.prepareStatement("insert into customer_trans_table values(?,?)");
				pst.setString(1, bill);
				pst.setDouble(2, sum);
				pst.executeUpdate();
				conn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			 PrinterJob pj=PrinterJob.getPrinterJob();
	         pj.setPrintable(new BillPrintable(bill),getPageFormat(pj));
	         try
	         {
	             pj.print();
	         }
	         catch(Exception t)
	         {
	             t.printStackTrace();
	         }
	         dispose();
			
		}
		
		  
	  });
	  
	  
	  setBounds(200,150,285,165);
	  setTitle("Bill");
	  setVisible(true);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setLayout(null);
	  
	  add(first);
	  add(second);
	  add(button);
  }
  public static void main(String args[])
  {
	  PopUpWindow win=new PopUpWindow(433.33);
  }
}
