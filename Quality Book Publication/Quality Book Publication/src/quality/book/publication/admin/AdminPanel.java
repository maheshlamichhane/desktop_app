package quality.book.publication.admin;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import quality.book.publication.home.Login;
import net.proteanit.sql.DbUtils;

public class AdminPanel extends JFrame
{
	


  public AdminPanel(String name)
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
			dispose();
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
	  middle.setBounds(210,150,970,515);
	  middle.setBorder(raisedbevel);
	  middle.setLayout(null);
	  
	  JPanel middle_left=new JPanel();
	  middle_left.setBounds(10,10,600,495);
	  Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	  middle_left.setBorder(loweredetched);
	  middle_left.setLayout(null);
	  
	  JLabel sortby=new JLabel("Sort By:");
	  sortby.setBounds(10, 20, 50, 15);
	  middle_left.add(sortby);
	  
	  String value[]={"Select Any","item_code","item_name","price","stocks"};
	  JComboBox sortby_combo=new JComboBox(value);
	  sortby_combo.setBounds(60,18,90,20);
	  sortby_combo.setBackground(Color.white);
	  sortby_combo.setBorder(loweredbevel);
	  middle_left.add(sortby_combo);
	  
	  JLabel searchby=new JLabel("Search By:");
	  searchby.setBounds(155, 20, 65, 15);
	  middle_left.add(searchby);
	  
	  String value2[]={"Select Any","item_code","item_name","price","stocks"};
	  JComboBox searchby_combo=new JComboBox(value2);
	  searchby_combo.setBounds(220,18,90,20);
	  searchby_combo.setBackground(Color.white);
	  searchby_combo.setBorder(loweredbevel);
	  middle_left.add(searchby_combo);
	  
	  JTextField text=new JTextField();
	  text.setBounds(315,18,190,20);
	  text.setBorder(loweredbevel);
	  middle_left.add(text);
	  
	  JButton searchbutton=new JButton("Search");
	  searchbutton.setBounds(510,18,80,20);
	  middle_left.add(searchbutton);
	  
	  JPanel table=new JPanel();
	  table.setBounds(10,50,580,435);
	  table.setBorder(loweredbevel);
	  table.setLayout(null);
	  
	  JLabel itemcode=new JLabel("Item Code");
	  itemcode.setBounds(20,35,80,20);
	  JTextField itemcode_textbox=new JTextField();
	  itemcode_textbox.setBounds(20,60,300,25);
	  
	     
    
      JTable pt=new JTable(); 
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
      pane.setBounds(0,0,580,435);  
      pane.setBorder(loweredbevel);
      table.add(pane);
	  middle_left.add(table);
	  
	  
	  
	  
	  
	  
	  JPanel middle_right=new JPanel();
	  middle_right.setBounds(620,5,340,500);
	  Border border = BorderFactory.createTitledBorder("Item Information");
	  middle_right.setBorder(border);
	  middle_right.setLayout(null);
	  
	 
	 
	
	  itemcode_textbox.setBorder(loweredbevel);
	  JLabel itemname=new JLabel("Item Name");
	  itemname.setBounds(20,90,80,20);
	  JTextField itemname_textbox=new JTextField();
	  itemname_textbox.setBounds(20,115,300,25);
	 
	  itemname_textbox.setBorder(loweredbevel);
	  JLabel category=new JLabel("Category");
	  category.setBounds(20,145,80,20);
	  JTextField category_textbox=new JTextField();
	 
	  top.setBorder(loweredbevel);
	  category_textbox.setBounds(20,170,300,25);
	  category_textbox.setBorder(loweredbevel);
	  JLabel description=new JLabel("Description");
	  description.setBounds(20,200,80,20);
	  JTextField description_textbox=new JTextField();
	 
	  description_textbox.setBounds(20,225,300,25);
	  description_textbox.setBorder(loweredbevel);
	  JLabel price=new JLabel("Price");
	  price.setBounds(20,255,80,20);
	  JTextField price_textbox=new JTextField();
	
	  price_textbox.setBounds(20,280,300,25);
	  price_textbox.setBorder(loweredbevel);
	  JLabel stocks=new JLabel("Stock");
	  stocks.setBounds(20,310,80,20);
	  JTextField stocks_textbox=new JTextField();
	 
	  stocks_textbox.setBounds(20,335,300,25);
	  stocks_textbox.setBorder(loweredbevel);
	  
	  itemcode_textbox.addKeyListener(new KeyListener()
	  {

		@Override
		public void keyPressed(KeyEvent e) 
		{
			 int key = e.getKeyCode();
		     if (key == KeyEvent.VK_ENTER) 
		     {
		       itemname_textbox.requestFocus();
		     }
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		  
	  });
	  itemname_textbox.addKeyListener(new KeyListener(){

		@Override
		public void keyPressed(KeyEvent e)
		{
			
			 int key = e.getKeyCode();
		     if (key == KeyEvent.VK_ENTER) 
		     {
		       category_textbox.requestFocus();
		     }
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		  
	  });
	  category_textbox.addKeyListener(new KeyListener(){

		@Override
		public void keyPressed(KeyEvent e) 
		{
			 int key = e.getKeyCode();
		     if (key == KeyEvent.VK_ENTER) 
		     {
		       description_textbox.requestFocus();
		     }
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		  
	  });
	  description_textbox.addKeyListener(new KeyListener()
	  {

		@Override
		public void keyPressed(KeyEvent e) 
		{
			 int key = e.getKeyCode();
		     if (key == KeyEvent.VK_ENTER) 
		     {
		       price_textbox.requestFocus();
		     }
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		  
	  });
	  price_textbox.addKeyListener(new KeyListener(){

		@Override
		public void keyPressed(KeyEvent e) {
			 int key = e.getKeyCode();
		     if (key == KeyEvent.VK_ENTER) 
		     {
		       stocks_textbox.requestFocus();
		     }
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		  
	  });
	  middle_right.add(itemcode);
	  middle_right.add(itemcode_textbox);
	  middle_right.add(itemname);
	  middle_right.add(itemname_textbox);
	  middle_right.add(category);
	  middle_right.add(category_textbox);
	  middle_right.add(description);
	  middle_right.add(description_textbox);
	  middle_right.add(price);
	  middle_right.add(price_textbox);
	  middle_right.add(stocks);
	  middle_right.add(stocks_textbox);
	  
	  JButton stockin=new JButton("Stock In");
	  stockin.setBounds(10,390,100,30);
	  stockin.addActionListener(new ActionListener()
	  {

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			int itemcode=Integer.parseInt(itemcode_textbox.getText());
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
				PreparedStatement pst=con.prepareStatement("select * from item_info where item_code=?");
				pst.setInt(1, itemcode);
				ResultSet rs=pst.executeQuery();
			
				 
					  if(!rs.next())
					  {
						  JOptionPane.showMessageDialog(null, "Sorry data not found");
					
					}
					  else
					  {
							itemcode_textbox.setText(String.valueOf(rs.getInt(1)));
							itemname_textbox.setText(rs.getString(2));
						    category_textbox.setText(rs.getString(3));
						    description_textbox.setText(rs.getString(4));
						    price_textbox.setText(String.valueOf(rs.getInt(5)));
						    stocks_textbox.setText(String.valueOf(rs.getInt(6)));
					  }
				  }
	
			catch(Exception ep)
			{
				ep.printStackTrace();
			}
		}
		  
	  });
	  
	  JButton delete=new JButton("Delete");
	  delete.setBounds(120,390,100,30);
	  delete.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			java.util.Calendar cal = Calendar.getInstance();
			java.util.Date utilDate = new java.util.Date(); // your util date
			cal.setTime(utilDate);    
			java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());
			
			int itemcode=Integer.parseInt(itemcode_textbox.getText());
			try
			{
				int z=0,y=0;
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
				PreparedStatement pst=con.prepareStatement("delete from item_info where item_code=?");
				PreparedStatement pst2=con.prepareStatement("insert into inventory_log_data values(?,?,?)");
				pst2.setDate(1,sqlDate);
				pst2.setString(2, name);
				pst2.setString(3, " "+name+" delete "+itemname_textbox.getText()+" ");
				pst.setInt(1, itemcode);
				z=pst.executeUpdate();
				y=pst2.executeUpdate();
				if(z>0 && y>0)
				{
				   JOptionPane.showMessageDialog(null,"Successfully records deleted");
				   itemcode_textbox.setText("");
					itemname_textbox.setText("");
					category_textbox.setText("");
					description_textbox.setText("");
					price_textbox.setText("");
					stocks_textbox.setText("");
					itemcode_textbox.grabFocus();
				}
				else
				{
					
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		  
	  });
	  JButton update=new JButton("Update");     
	  update.setBounds(230,390,100,30);
	  update.addActionListener(new ActionListener()
	  {

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			try
			{
				int z=0,y=0;
				int item_code=Integer.parseInt(itemcode_textbox.getText());
				String item_name=itemname_textbox.getText();
				String category=category_textbox.getText();
				String description=description_textbox.getText();
				int price=Integer.parseInt(price_textbox.getText());
				int stocks=Integer.parseInt(stocks_textbox.getText());
				
				java.util.Calendar cal = Calendar.getInstance();
				java.util.Date utilDate = new java.util.Date(); // your util date
				cal.setTime(utilDate);    
				java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
				PreparedStatement pst=con.prepareStatement("update item_info set item_code=?,item_name=?,category=?,description=?,price=?,stocks=? where item_code=?");
				PreparedStatement pst2=con.prepareStatement("insert into inventory_log_data values(?,?,?)");
				pst2.setDate(1,sqlDate);
				pst2.setString(2, name);
				pst2.setString(3, " "+name+" update "+itemname_textbox.getText()+" ");
				
				pst.setInt(1, item_code);
			    pst.setString(2, item_name);
			    pst.setString(3, category);
			    pst.setString(4, description);
			    pst.setInt(5, price);
			    pst.setInt(6, stocks);
			    pst.setInt(7, item_code);
				z=pst.executeUpdate();
				y=pst2.executeUpdate();
				if(z>0 && y>0)
				{
				   JOptionPane.showMessageDialog(null,"Successfully records updated");
				   itemcode_textbox.setText("");
					itemname_textbox.setText("");
					category_textbox.setText("");
					description_textbox.setText("");
					price_textbox.setText("");
					stocks_textbox.setText("");
					itemcode_textbox.grabFocus();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "problem occured");
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		  
	  });
	  JButton showall=new JButton("Show All");
	  showall.addActionListener(new ActionListener()
	  {

		@Override
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
				PreparedStatement pst=con.prepareStatement("select item_code,item_name,price,stocks from item_info order by item_code ASC");
				ResultSet rs=pst.executeQuery();
				pt.setModel(DbUtils.resultSetToTableModel(rs));
				rs.close();
				con.close();
				
				
				
				
			}
			catch(Exception ei)
			{
				ei.printStackTrace();
			}
		}
		  
	  });
	
	  showall.setBounds(10,430,100,30);
	  JButton clear=new JButton("Clear");
	  clear.setBounds(120,430,100,30);
	  clear.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			  itemcode_textbox.setText("");
				itemname_textbox.setText("");
				category_textbox.setText("");
				description_textbox.setText("");
				price_textbox.setText("");
				stocks_textbox.setText("");
				itemcode_textbox.grabFocus();
			
		}
		  
	  });
	  JButton cancel=new JButton("Cancel");
	  cancel.setBounds(230,430,100,30);
	  cancel.addActionListener(new ActionListener()
	  {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
			
		}
		  
	  });
	  searchbutton.addActionListener(new ActionListener()
	  {

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			String sortby=sortby_combo.getSelectedItem().toString();
			String searchby=searchby_combo.getSelectedItem().toString();
			String text_value=text.getText();
			
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
				PreparedStatement pst=con.prepareStatement("select item_code,item_name,price,stocks from item_info where "+searchby+" = ? order by " +sortby+" DESC");
				pst.setString(1,text_value);
				ResultSet rs=pst.executeQuery();
				
				pt.setModel(DbUtils.resultSetToTableModel(rs));
				con.close();
				rs.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		  
	  });

	  middle_right.add(stockin);
	  middle_right.add(delete);
	  middle_right.add(update);
	  middle_right.add(showall);
	  middle_right.add(clear);
	  middle_right.add(cancel);
	 
	  middle.add(middle_right);
	  middle.add(middle_left);
	  
	  setBounds(20,20,1192,700);
	  setTitle("Lamichhane Inventory Management");
	  setVisible(true);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  setLayout(null);
	  setResizable(false);
	  add(menu);
	  add(left);
	  add(top);
	  add(middle);
	  this.addWindowListener(new WindowListener(){

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0)
		{
			
			/* java.util.Calendar cal = Calendar.getInstance();
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
			catch(Exception e)
			{
				e.printStackTrace();
			}
			**/
			
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
				PreparedStatement pst=con.prepareStatement("select item_code,item_name,price,stocks from item_info order by item_code ASC");
				ResultSet rs=pst.executeQuery();
				pt.setModel(DbUtils.resultSetToTableModel(rs));
				rs.close();
				con.close();
				
				
				
				
			}
			catch(Exception ei)
			{
				ei.printStackTrace();
			}
			
			
		}
		  
	  });
  }
  


public static void main(String args[])
{
	AdminPanel panel=new AdminPanel(null);
}
  

  


  
	
 
 
 
}
