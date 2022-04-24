package quality.book.publication.employee;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

public class DepositWindow extends JFrame
{
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
	public String GenerateInvoiceNumber()
	{
		String id=null;
		
			
			try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
		    PreparedStatement pts=con.prepareStatement("select max(bill_no) from customer_transaction_table");
			ResultSet ps=pts.executeQuery();
			while(ps.next())
			{
			
				id=ps.getString(1);
			}
			
			if(id.equals("null"))
			{
				id="B-0000001";
			}
			else
			{
			   long val=Long.parseLong(id.substring(3));
			   val++;
			   id= "B-"+String.valueOf(String.format("%07d", val));
		
			
			 
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		  return id;
		
			
		
	}


    public DepositWindow(String phone,String name,String transtype)
    {
    
    	
    	
    	JTextField deposit_text=new JTextField("Enter Deposit Amount...");
    	deposit_text.setBounds(15,10,185,30);
    	deposit_text.addFocusListener(new FocusListener()
    	{

			@Override
			public void focusGained(FocusEvent arg0) 
			{
				deposit_text.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
    		
    	});
    	JButton deposit_button=new JButton("Deposit");
    	deposit_button.setBounds(15,50,185,30);
        deposit_button.addActionListener(new ActionListener()
        {

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				java.util.Calendar cal = Calendar.getInstance();
				java.util.Date utilDate = new java.util.Date(); // your util date
				cal.setTime(utilDate);    
				java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());
				String bill=GenerateInvoiceNumber();
				int x=0;
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
					PreparedStatement pst=con.prepareStatement("insert into customer_transaction_table values(?,?,?,?,?,?,?)");
					pst.setDate(1, sqlDate);
					pst.setString(2, name);
					pst.setInt(3,Integer.parseInt(phone));
					pst.setString(4,bill);
					pst.setString(5, "Deposit amount:BA/"+bill);
					pst.setString(6, transtype);
					pst.setDouble(7, Double.valueOf(deposit_text.getText()));
					x=pst.executeUpdate();
					if(x>0)
					{
						JOptionPane.showMessageDialog(null, "Amount Deposited Successfully");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Sorry Problem Occured");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				dispose();
				
				 PrinterJob pj=PrinterJob.getPrinterJob();
		         pj.setPrintable(new DepositPrintable(phone,name,transtype,deposit_text.getText(),bill),getPageFormat(pj));
		         try
		         {
		             pj.print();
		         }
		         catch(Exception t)
		         {
		             t.printStackTrace();
		         }
			}
        
        	
        });
    
    	
    
    	
    	
    	
       setBounds(450,300,230,130);
  	   setTitle("Deposit");
  	   setVisible(true);
  	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	   setVisible(true);
  	   setLayout(null);
  	   
  	 add(deposit_text);
 	add(deposit_button);
    }
    public static void main(String args[])
    {
    	DepositWindow window=new DepositWindow(null,null,null);
    }
}
