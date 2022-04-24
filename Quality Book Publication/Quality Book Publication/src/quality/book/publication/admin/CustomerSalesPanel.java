package quality.book.publication.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
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
import java.util.Calendar;
import java.awt.event.FocusListener;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import quality.book.publication.employee.CustomerSalesInfoPrintable;
import quality.book.publication.home.Login;
import net.proteanit.sql.DbUtils;

public class CustomerSalesPanel extends JFrame
{
	JTable pt;
	
	   public PageFormat getPageFormat(PrinterJob pj)
	    {
	        PageFormat pf=pj.defaultPage();
	        Paper paper=pf.getPaper();
	        double middleHeight=8.0;
	        double headerHeight=2.0;
	        double footerHeight=2.0;
	        double width=convert_CM_To_PPT(16);
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
    public CustomerSalesPanel(String name)
    {
      Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
   	  Border raisedbevel = BorderFactory.createRaisedBevelBorder();
   	  Border loweredbevel = BorderFactory.createLoweredBevelBorder();
   	  
   	  JPanel menu=new JPanel();
   	  menu.setBounds(5,5,200,80);
   	  menu.setBorder(raisedbevel);
   	  menu.setLayout(null);
   	  
   	  JLabel leftheader=new JLabel("MAIN MENU");
   	  Font font=new Font(Font.SANS_SERIF,Font.PLAIN,20);
   	  leftheader.setBounds(44,32,112,15);
   	  leftheader.setFont(font);
   	  menu.add(leftheader);
   	  
   	  
   	  JPanel left=new JPanel();
   	  left.setBounds(5,100,200,565);
   	  left.setBorder(raisedetched);
   	  left.setLayout(null);
   	  
   	  
   	  
   	  JButton inventory=new JButton("Inventory");
   	  inventory.setBounds(20,30,160,40);
   	  inventory.addActionListener(new ActionListener()
   	  {

   		@Override
   		public void actionPerformed(ActionEvent arg0)
   		{
   			AdminPanel panel=new AdminPanel(name);
   			dispose();
   		}
   		  
   	  });
   	  JButton customer=new JButton("Customer");
   	  customer.setBounds(20, 90, 160, 40);
   	  customer.addActionListener(new ActionListener()
   	  {

   		@Override
   		public void actionPerformed(ActionEvent e)
   		{
   			CustomerPanel panel=new CustomerPanel(name);
   			dispose();
   		}
   		  
   	  });
   	  JButton account=new JButton("Account");
   	  account.setBounds(20,150,160,40);
   	  account.addActionListener(new ActionListener()
   	  {

   		@Override
   		public void actionPerformed(ActionEvent e) 
   		{
   			AccountPanel panel=new AccountPanel(name);
   			dispose();
   		}
   		  
   	  });
   	  JButton sales=new JButton("Sales");
   	  sales.setBounds(20,210,160,40);
   	  sales.addActionListener(new ActionListener(){

   		@Override
   		public void actionPerformed(ActionEvent e)
   		{
   			SalesReport panel=new SalesReport(name);
   			
   		}
   		  
   	  });
   	  
   	  JButton customer_sales=new JButton("Customer Sales");
   	  customer_sales.setBounds(20,270,160,40);
   	  customer_sales.addActionListener(new ActionListener()
   	  {

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			CustomerSalesPanel panel=new CustomerSalesPanel(name);
		}
   		  
   	  });
   	  JButton changeuser=new JButton("Change User");
   	  changeuser.setBounds(20, 330, 160, 40);
   	  changeuser.addActionListener(new ActionListener()
   	  {

   		@Override
   		public void actionPerformed(ActionEvent e) 
   		{
   			java.util.Calendar cal = Calendar.getInstance();
			java.util.Date utilDate = new java.util.Date(); // your util date
			cal.setTime(utilDate);    
			java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
				PreparedStatement pst=conn.prepareStatement("insert into system_log_data values(?,?,?)");
				pst.setDate(1, sqlDate);
				pst.setString(2, name);
				pst.setString(3, "Admin "+name+" logged out");
				pst.executeUpdate();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
   			Login login=new Login();
   			dispose();
   			
   		}
   		  
   	  });
   	  JButton exit=new JButton("Exit");
   	  exit.setBounds(20,390,160,40);
   	  exit.addActionListener(new ActionListener()
   	  {

   		@Override
   		public void actionPerformed(ActionEvent e)
   		{
   			java.util.Calendar cal = Calendar.getInstance();
			java.util.Date utilDate = new java.util.Date(); // your util date
			cal.setTime(utilDate);    
			java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
				PreparedStatement pst=conn.prepareStatement("insert into system_log_data values(?,?,?)");
				pst.setDate(1, sqlDate);
				pst.setString(2, name);
				pst.setString(3, "Admin "+name+" logged out");
				pst.executeUpdate();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
   			System.exit(0);
   		}
   		  
   	  });
   	 JPanel pannel=new JPanel();
	  pannel.setLayout(null);
	  pannel.setBorder(raisedbevel);
	  pannel.setBounds(20,460,160,80);
	  
	  JLabel Title=new JLabel("Logged In User Info");
	  Title.setBounds(25,20,140,20);
	  JLabel title_value=new JLabel();
	  title_value.setBounds(50,40,60,20);
	  title_value.setText(name);
	  pannel.add(title_value);
	  pannel.add(Title);
	  
	  left.add(pannel);
   	  
   	  left.add(inventory);
   	  left.add(customer);
   	  left.add(account);
   	  left.add(sales);
   	  left.add(changeuser);
   	  left.add(exit);
   	  left.add(customer_sales);
   	 
   	  
   	  
   	  
   	  
   	  JPanel top=new JPanel();
   	  top.setBounds(210,0,970,140);
   	  top.setBackground(Color.black);
   	  top.setBorder(loweredbevel);
   	  top.setLayout(null);
   	  
   	  JButton newitem = new JButton(new ImageIcon(((new ImageIcon("C://Users//Mahesh Lamichhane//Desktop//desktop app//Pos and Inventory System//image//logo//add item.jpg")).getImage()).getScaledInstance(140, 90, java.awt.Image.SCALE_SMOOTH)));
   	  newitem.setBounds(80,10,140,120);
   	  newitem.setText("New Item");
   	  newitem.setHorizontalTextPosition(AbstractButton.CENTER);
   	  newitem.setVerticalTextPosition(AbstractButton.BOTTOM);
   	  newitem.addActionListener(new ActionListener()
   	  {

   		@Override
   		public void actionPerformed(ActionEvent arg0) 
   		{
   			NewItem item=new NewItem(name);
   			dispose();
   			
   		}
   		  
   	  });
   	  
   	  JButton newcustomer = new JButton(new ImageIcon(((new ImageIcon("C://Users//Mahesh Lamichhane//Desktop//desktop app//Pos and Inventory System//image//logo//new customer.png")).getImage()).getScaledInstance(140, 90, java.awt.Image.SCALE_SMOOTH)));
   	  newcustomer.setBounds(249,10,140,120);
   	  newcustomer.setText("New Customer");
   	  newcustomer.setHorizontalTextPosition(AbstractButton.CENTER);
   	  newcustomer.setVerticalTextPosition(AbstractButton.BOTTOM);
   	  newcustomer.addActionListener(new ActionListener()
   	  {

   		@Override
   		public void actionPerformed(ActionEvent arg0) 
   		{
   			NewCustomer customer=new NewCustomer(name);
   			dispose();
   		}
   		  
   	  });
   	
   	  JButton newemployee = new JButton(new ImageIcon(((new ImageIcon("C://Users//Mahesh Lamichhane//Desktop//desktop app//Pos and Inventory System//image//logo//new employee.png")).getImage()).getScaledInstance(140, 90, java.awt.Image.SCALE_SMOOTH)));
   	  newemployee.setBounds(418,10,140,120);
   	  newemployee.setText("New Employee");
   	  newemployee.setHorizontalTextPosition(AbstractButton.CENTER);
   	  newemployee.setVerticalTextPosition(AbstractButton.BOTTOM);
   	  newemployee.addActionListener(new ActionListener(){

   		@Override
   		public void actionPerformed(ActionEvent arg0) 
   		{
   			NewEmployee emp=new NewEmployee(name);
   		}
   		  
   	  });

   	  JButton logs = new JButton(new ImageIcon(((new ImageIcon("C://Users//Mahesh Lamichhane//Desktop//desktop app//Pos and Inventory System//image//logo//logs.jpg")).getImage()).getScaledInstance(140, 90, java.awt.Image.SCALE_SMOOTH)));
   	  logs.setBounds(587,10,140,120);
   	  logs.setText("Logs");
   	  logs.setHorizontalTextPosition(AbstractButton.CENTER);
   	  logs.setVerticalTextPosition(AbstractButton.BOTTOM);
   	  logs.addActionListener(new ActionListener()
   	  {

   		@Override
   		public void actionPerformed(ActionEvent arg0) 
   		{
   			Logs log=new Logs(name);
   			
   		}
   		  
   	  });
   	
   	  JButton help = new JButton(new ImageIcon(((new ImageIcon("C://Users//Mahesh Lamichhane//Desktop//desktop app//Pos and Inventory System//image//logo//help.png")).getImage()).getScaledInstance(140, 90, java.awt.Image.SCALE_SMOOTH)));
   	  help.setBounds(756,10,140,120);
   	  help.setText("Help");
   	  help.setHorizontalTextPosition(AbstractButton.CENTER);
   	  help.setVerticalTextPosition(AbstractButton.BOTTOM);
   	  help.addActionListener(new ActionListener(){

   		@Override
   		public void actionPerformed(ActionEvent arg0) 
   		{
   			Help help=new Help(name);
   			dispose();
   		}
   		  
   	  });

   	  top.add(newitem);
   	  top.add(newcustomer);
   	  top.add(newemployee);
   	  top.add(logs);
   	  top.add(help);
   	  
   	  
   	  
   	  JPanel middle=new JPanel();
   	  middle.setBounds(220,160,950,495);
   	  middle.setBorder(raisedbevel);
   	  middle.setLayout(null);
   	  
   	  JLabel deposit_amount=new JLabel("Deposit Transaction:");
   	  deposit_amount.setBounds(15,465,120,25);
   	  
   	  JTextField deposit_amount_text=new JTextField();
   	  deposit_amount_text.setBounds(135,467,100,20);
   	  
   	  JLabel transaction_amount=new JLabel("Cash Transaction:");
   	  transaction_amount.setBounds(260,465,120,25);
   	  
   	  JTextField tansaction_amount_text=new JTextField();
   	  tansaction_amount_text.setBounds(365,467,100,20);
   	  
   	  
   	  JLabel  totaltransactionvalue =new JLabel("Credit Transaction:");
   	totaltransactionvalue.setBounds(490,467,120,20);
   	  
   	  JTextField totaltransvalue =new JTextField();
   	totaltransvalue.setBounds(600,467,100,20);
   	  
   	  JLabel total_transaction=new JLabel("Total Transaction:");
   	  total_transaction.setBounds(720,467,120,20);
   	  
   	  JTextField total_transaction_field=new JTextField();
   	total_transaction_field.setBounds(820,467,100,20);
   	  
   	  middle.add(totaltransvalue);
   	  middle.add(totaltransactionvalue);
   	  middle.add(deposit_amount);
   	  middle.add(deposit_amount_text);
   	  middle.add(transaction_amount);
   	  middle.add(tansaction_amount_text);
   	  middle.add(total_transaction);
   	  middle.add(total_transaction_field);
   	  
   	  JPanel middle_left=new JPanel();
	  middle_left.setBounds(10,10,930,450);
	  Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	  middle_left.setBorder(loweredetched);
	  middle_left.setLayout(null);
	  
	  JLabel sortby=new JLabel("Sort By:");
	  sortby.setBounds(10, 20, 50, 15);
	  middle_left.add(sortby);
	  
	  String value[]={"Select Any","date_time","customer_name","phone_number","bill_no","particulars","tansaction_type","amount"};
	  JComboBox sortby_combo=new JComboBox(value);
	  sortby_combo.setBounds(65,18,100,20);
	  sortby_combo.setBackground(Color.white);
	  sortby_combo.setBorder(loweredbevel);
	  middle_left.add(sortby_combo);
	  
	  JLabel searchby=new JLabel("Search By:");
	  searchby.setBounds(180, 20, 65, 15);
	  middle_left.add(searchby);
	  
	  String value2[]={"Select Any","date_time","customer_name","phone_number","bill_no","particulars","tansaction_type","amount"};
	  JComboBox searchby_combo=new JComboBox(value2);
	  searchby_combo.setBounds(255,18,100,20);
	  searchby_combo.setBackground(Color.white);
	  searchby_combo.setBorder(loweredbevel);
	  middle_left.add(searchby_combo);
	  
	  JTextField text=new JTextField("Enter Phone Number");
	  text.setBounds(370,18,245,20);
	  text.setBorder(loweredbevel);
	  text.addFocusListener(new FocusListener(){

		@Override
		public void focusGained(FocusEvent arg0) 
		{
			text.setText("");
			
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		  
	  });
	  middle_left.add(text);
	  
	  JButton searchbutton=new JButton("Search");
	  searchbutton.setBounds(630,18,90,20);
	  middle_left.add(searchbutton);
	  searchbutton.addActionListener(new ActionListener()
	  {

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			 searchbutton.addActionListener(new ActionListener()
			  {

				@Override
				public void actionPerformed(ActionEvent arg0) 
				{
					double cash=0.0,credit=0.0,deposit=0.0;
					String sortby=sortby_combo.getSelectedItem().toString();
					String searchby=searchby_combo.getSelectedItem().toString();
					String text_value=text.getText();
					
					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
						PreparedStatement pst=con.prepareStatement("select * from customer_transaction_table where "+searchby+" = ? order by " +sortby+" DESC");
						PreparedStatement depositamount=con.prepareStatement("select sum(amount) from customer_transaction_table where tansaction_type='Deposit' and "+searchby+"=?");
						depositamount.setString(1, text_value);
						ResultSet deposit1=depositamount.executeQuery();
						PreparedStatement cashamount=con.prepareStatement("select sum(amount) from customer_transaction_table where tansaction_type='Cash' and "+searchby+"=?");
						cashamount.setString(1, text_value);
						ResultSet cash1=cashamount.executeQuery();
						PreparedStatement creditamount=con.prepareStatement("select sum(amount) from customer_transaction_table where  tansaction_type='Credit' and "+searchby+"=?");
						creditamount.setString(1, text_value);
						ResultSet credit1=creditamount.executeQuery();
						pst.setString(1,text_value);
						ResultSet rs=pst.executeQuery();
						pt.setModel(DbUtils.resultSetToTableModel(rs));
						
						double c=0.0,d=0.0;
						
						while(deposit1.next())
						{
							deposit_amount_text.setText(deposit1.getString(1));
							d=deposit1.getDouble(1);
						}
						while(cash1.next())
						{
							tansaction_amount_text.setText(cash1.getString(1));
						}
						while(credit1.next())
						{
							totaltransvalue.setText(credit1.getString(1));
							c=credit1.getDouble(1);
						}
						
						
						
						
						
						total_transaction_field.setText(String.valueOf(d-c));
						
						
					
					
						
						
						
					
					
						con.close();
						rs.close();
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				  
			  });
		}
		  
	  });
	  
	  JButton showall=new JButton("Show All");
	  showall.setBounds(730,18,90,20);
	  showall.addActionListener(new ActionListener()
	  {

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
				PreparedStatement pst=con.prepareStatement("select * from customer_transaction_table order by customer_name ASC");
				PreparedStatement totalamount=con.prepareStatement("select sum(amount) from customer_transaction_table");
				PreparedStatement depositamount=con.prepareStatement("select sum(amount) from customer_transaction_table where tansaction_type='Deposit'");
				PreparedStatement cashamount=con.prepareStatement("select sum(amount) from customer_transaction_table where tansaction_type='Cash'");
				PreparedStatement creditamount=con.prepareStatement("select sum(amount) from customer_transaction_table where tansaction_type='Credit'");
				ResultSet rs=pst.executeQuery();
				ResultSet gs=totalamount.executeQuery();
				ResultSet ds=depositamount.executeQuery();
				ResultSet credit=creditamount.executeQuery();
				ResultSet cash=cashamount.executeQuery();
				pt.setModel(DbUtils.resultSetToTableModel(rs));
				while(gs.next())
				{
					total_transaction_field.setText(gs.getString(1));
				}
				while(ds.next())
				{
					deposit_amount_text.setText(ds.getString(1));
				}
				while(credit.next())
				{
					totaltransvalue.setText(credit.getString(1));
				}
				while(cash.next())
				{
					tansaction_amount_text.setText(cash.getString(1));
				}
				
		        
				
				
				rs.close();
				con.close();
				
				
				
				
			}
			catch(Exception ei)
			{
				ei.printStackTrace();
			}
		}
		  
	  });
	  
	  JButton print=new JButton("Print");
	  print.setBounds(830,18,90,20);
	  print.addActionListener(new ActionListener()
	  {

		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			 PrinterJob pa=PrinterJob.getPrinterJob();
	         pa.setPrintable(new CustomerSalesInfoPrintable(text.getText(),searchby_combo.getSelectedItem().toString(),sortby_combo.getSelectedItem().toString()),getPageFormat(pa));
	         try
	         {
	             pa.print();
	         }
	         catch(Exception t)
	         {
	             t.printStackTrace();
	         }
			
		}
		  
	  });
	 
	  
	  middle_left.add(showall);
	  middle_left.add(print);
	
	  
	  JPanel table=new JPanel();
	  table.setBounds(10,50,910,385);
	  table.setBorder(loweredbevel);
	  table.setLayout(null);
	  
	  JLabel itemcode=new JLabel("Item Code");
	  itemcode.setBounds(20,35,80,20);
	  JTextField itemcode_textbox=new JTextField();
	  itemcode_textbox.setBounds(20,60,300,25);
	  
	     
    
      pt=new JTable(); 
      pt.addMouseListener(new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent arg0)
		{
			/*
			int j=pt.getSelectedColumn();
			TableModel model=pt.getModel();
			itemcode_textbox.setText(model.getValueAt(0, i).toString());
			**/
			
			
			
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
      pane.setBounds(0,0,910,385);  
      pane.setBorder(loweredbevel);
      table.add(pane);
	  middle_left.add(table);
	  
	  middle.add(middle_left);
	  

  
   	  
   	 setBounds(20,20,1192,700);
	  setTitle("Lamichhane Inventory Management");
	  setVisible(true);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  setVisible(true);
	  setLayout(null);
	  setResizable(false);
	  this.addWindowListener(new WindowListener(){

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			
			
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
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
				PreparedStatement pst=con.prepareStatement("select * from customer_transaction_table order by customer_name ASC");
				PreparedStatement totalamount=con.prepareStatement("select sum(amount) from customer_transaction_table");
				PreparedStatement depositamount=con.prepareStatement("select sum(amount) from customer_transaction_table where tansaction_type='Deposit'");
				PreparedStatement cashamount=con.prepareStatement("select sum(amount) from customer_transaction_table where tansaction_type='Cash'");
				PreparedStatement creditamount=con.prepareStatement("select sum(amount) from customer_transaction_table where tansaction_type='Credit'");
				ResultSet rs=pst.executeQuery();
				ResultSet gs=totalamount.executeQuery();
				ResultSet ds=depositamount.executeQuery();
				ResultSet credit=creditamount.executeQuery();
				ResultSet cash=cashamount.executeQuery();
				pt.setModel(DbUtils.resultSetToTableModel(rs));
				while(gs.next())
				{
					total_transaction_field.setText(gs.getString(1));
				}
				while(ds.next())
				{
					deposit_amount_text.setText(ds.getString(1));
				}
				while(credit.next())
				{
					totaltransvalue.setText(credit.getString(1));
				}
				while(cash.next())
				{
					tansaction_amount_text.setText(cash.getString(1));
					
				}
				
				
				rs.close();
				con.close();
				
				
				
				
			}
			catch(Exception ei)
			{
				ei.printStackTrace();
			}
		}
		  
	  });
	  add(menu);
	  add(left);
	  add(top);
	  add(middle);
	  
    }
    public static void main(String args[])
    {
    	CustomerSalesPanel help=new CustomerSalesPanel(null);
    }
}
