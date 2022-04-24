import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import net.proteanit.sql.DbUtils;

public class SalesInformation extends JFrame
{
	JPanel left,menu,main,top,tableheader,tablebody;
	JLabel leftheader,mainheader;
	JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7;
	 String value;
	 JLabel transresult;
	 
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
  public SalesInformation()
  {
	  Border raisedbevel = BorderFactory.createRaisedBevelBorder();
	  Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	  Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	  Font leftheaderfont=new Font("Serif",Font.BOLD,20);
	  
	  JButton menu = new JButton(new ImageIcon(((new ImageIcon("E://meat hub//menu.png")).getImage()).getScaledInstance(100, 80, java.awt.Image.SCALE_SMOOTH)));
	  menu.setBounds(10,10,100,80);
	  menu.setLayout(null);
	  menu.setBackground(Color.decode("#a558af"));
	  menu.setBorder(raisedbevel);
	  leftheader=new JLabel("");
	  leftheader.setBounds(25,20,50,40);
	  leftheader.setFont(leftheaderfont);
	  menu.add(leftheader);
	  
	  
	  
	  left=new JPanel();
	  left.setBounds(10,100,100,370);
	  left.setBackground(Color.decode("#a558af"));
	  left.setLayout(null);
	  left.setBorder(raisedbevel);
	  
	  btn1=new JButton("Today Menu");
	  btn1.setBounds(10,30,80,30);
	  btn1.setBorder(raisedetched);
	  btn1.setBackground(Color.decode("#347deb"));
	  btn1.setForeground(Color.white);
	  btn1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
			TodayMenu menu=new TodayMenu();
			
		}
		  
	  });
	  
	  
	  btn2=new JButton("Add Item");
	  btn2.setBounds(10,86,80,30);
	  btn2.setBorder(raisedetched);
	  btn2.setBackground(Color.decode("#347deb"));
	  btn2.setForeground(Color.white);
	  btn2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
			AddItem item=new AddItem();
			
			
		}
		  
	  });
	  
	  btn3=new JButton("Sale Product");
	  btn3.setBounds(10,142,80,30);
	  btn3.setBorder(raisedetched);
	  btn3.setBackground(Color.decode("#347deb"));
	  btn3.setForeground(Color.white);
	  btn3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
			SaleProduct product=new SaleProduct();
			
		}
		  
	  });
	  
	  btn4=new JButton("Sales Info");
	  btn4.setBounds(10,198,80,30);
	  btn4.setBorder(raisedetched);
	  btn4.setBackground(Color.decode("#347deb"));
	  btn4.setForeground(Color.white);
	  btn4.addActionListener(new ActionListener() 
	  {

		@Override
		public void actionPerformed(ActionEvent e)
		{
			dispose();
			SalesInformation info=new SalesInformation();
		}
		  
	  });
	  
	  JButton btnnew=new JButton("Transaction");
	  btnnew.setBounds(10,254,80,30);
	  btnnew.setBorder(raisedetched);
	  btnnew.setForeground(Color.white);
	  btnnew.setBackground(Color.decode("#347deb"));
	  btnnew.addActionListener(new ActionListener()
	  {

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			dispose();
			Home home=new Home();
		}
		  
	  });
	
	  
	  
	  btn7=new JButton("Cancel");
	  btn7.setBounds(10,310,80,30);
	  btn7.setBorder(raisedetched);
	  btn7.setBackground(Color.decode("#347deb"));
	  btn7.setForeground(Color.white);
	  btn7.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
			
		}
		  
	  });
	  
	  left.add(btn2);
	  left.add(btn1);
	  left.add(btn3);
	  left.add(btn4);
	  left.add(btn7);
	  left.add(btnnew);
	  
	  
	  
	  
	  
	  
	  
	  
	  main=new JPanel();
	  main.setBounds(120,11,652,460);
	  main.setBackground(Color.decode("#a558af"));
	  main.setLayout(null);
	  main.setBorder(loweredbevel);
	  
	  mainheader=new JLabel("Total Transaction");
	  mainheader.setBounds(210,0,230,40);
	  Font mainfont=new Font("Serif",Font.BOLD,30);
	  mainheader.setFont(mainfont);
	  
	  
	   
	 
	   
	   tableheader=new JPanel();
	   tableheader.setLayout(null);
	   tableheader.setBounds(17,30,615,40);
	   tableheader.setBackground(Color.decode("#7EB1B6"));
	   Font fun=new Font("Serif",Font.BOLD,15);
	   tableheader.add(mainheader);
	   

	   
	   tablebody=new JPanel();
	   tablebody.setBounds(17,70,615,340);
	   tablebody.setBackground(Color.decode("#0A1CCD"));
	   tablebody.setLayout(null);
	   
	   JTable pt=new JTable(); 
	      pt.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0)
			{
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	    	  
	      });
	      JScrollPane pane=new JScrollPane(pt);
	      pane.setBounds(0,0,617,340);  
	      pane.setBorder(loweredbevel);
	      tablebody.add(pane);
	      
	      JTextField field=new JTextField("item name...");
	      field.setBounds(20,423,100,25);
	      field.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) 
			{
				field.setText("");
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
	    	  
	      });
	      
	      JButton sebutton=new JButton("Search");
	      sebutton.setBounds(125,423,80,25);
	      sebutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				 try
				   {
					   Class.forName("org.sqlite.JDBC");
					   Connection conn=DriverManager.getConnection("jdbc:sqlite:meathub.db");
					   PreparedStatement pst=conn.prepareStatement("select * from sales_real where item_name=?");
					   PreparedStatement pst2=conn.prepareStatement("select sum(total) from sales_real where item_name=?");
					   pst2.setString(1, field.getText());
					   ResultSet ps=pst2.executeQuery();
					  
					   while(ps.next())
					   {
						   value=ps.getString(1);
					   }
					   transresult.setText(value);
					  
					   pst.setString(1, field.getText());
					   ResultSet rs=pst.executeQuery();
						   
						   pt.setModel(DbUtils.resultSetToTableModel(rs));
							rs.close();
							conn.close();
						 
						   
						   
						  
						 
					   }
				   catch(Exception ed)
				   {
					   ed.printStackTrace();
				   }
			}
	      
	      });
	      JButton delbutton=new JButton("Delete");
	      delbutton.setBounds(210,423,80,25);
	      delbutton.addActionListener(new ActionListener()
	      {

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				DeleteLogin login=new DeleteLogin();
				
				
			}
	    	  
	    	  
	      });
	      JButton showbutton=new JButton("Show");
	      showbutton.setBounds(295,423,80,25);
	      showbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				 try
				   {
					   Class.forName("org.sqlite.JDBC");
					   Connection conn=DriverManager.getConnection("jdbc:sqlite:meathub.db");
					   PreparedStatement pst=conn.prepareStatement("select * from sales_real");
					   PreparedStatement pst2=conn.prepareStatement("select sum(total) from sales_real");
					   ResultSet ps=pst2.executeQuery();
					  
					   while(ps.next())
					   {
						   value=ps.getString(1);
					   }
					   transresult.setText(value);
					   ResultSet rs=pst.executeQuery();
						   
						   pt.setModel(DbUtils.resultSetToTableModel(rs));
							rs.close();
							conn.close();
						 
						   
						   
						  
						 
					   }
				   catch(Exception ed)
				   {
					   ed.printStackTrace();
				   }
				
			}
	    	  
	      });
	      
	      JButton print=new JButton("Print");
	      print.setBounds(380,423,80,25);
	      print.addActionListener(new ActionListener()
	      {
	    	  String bill=GenerateInvoiceNumber();

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				 PrinterJob pj=PrinterJob.getPrinterJob();
		         pj.setPrintable(new SalesInformationPrintable(bill),getPageFormat(pj));
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
	      
	      JLabel label=new JLabel("Total Transaction:");
	      label.setBounds(470,426,105,20);
	      transresult=new JLabel("4800");
	      transresult.setBounds(580,426,120,20);
		 
	   
	   
	   
	   main.add(field);
	   main.add(transresult);
	   main.add(label);
	   main.add(showbutton);
	   main.add(delbutton);
	   main.add(sebutton);
	   main.add(tableheader);
	   main.add(tablebody);
	   main.add(print);
	  
	  
	  
	  
	  setTitle("Village Meat Hub");
	  getContentPane().setBackground( Color.decode("#f8ec38") );
	  setLayout(null);
	  setVisible(true);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setResizable(false);
	  setBounds(300,150,788,510);
	  
	  add(left);
	  add(menu);
	  add(main);
	  addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0)
			
			{
				 try
				   {
					   Class.forName("org.sqlite.JDBC");
					   Connection conn=DriverManager.getConnection("jdbc:sqlite:meathub.db");
					   PreparedStatement pst=conn.prepareStatement("select * from sales_real");
					   PreparedStatement pst2=conn.prepareStatement("select sum(total) from sales_real");
					   ResultSet ps=pst2.executeQuery();
					  
					   while(ps.next())
					   {
						   value=ps.getString(1);
					   }
					   transresult.setText(value);
					   ResultSet rs=pst.executeQuery();
						   
						   pt.setModel(DbUtils.resultSetToTableModel(rs));
							rs.close();
							conn.close();
						 
						   
						   
						  
						 
					   }
				   catch(Exception e)
				   {
					   e.printStackTrace();
				   }
			}
			  
		  });
  }
  public static void main(String args[])
  {
	  SalesInformation info=new SalesInformation();
  }
}
