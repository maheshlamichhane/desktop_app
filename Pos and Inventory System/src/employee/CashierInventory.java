package employee;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import home.Login;
import net.proteanit.sql.DbUtils;

public class CashierInventory extends JFrame
{
	public CashierInventory(String name)
	{
		
		   
		   JPanel navigation=new JPanel();
		   navigation.setLayout(null);
		   navigation.setBackground(Color.decode("#3333cc"));
		   navigation.setBounds(20,10,1040,60);
		   JButton pos=new JButton("POS");
		   pos.setBounds(40,10,80,40);
		   pos.setBackground(Color.decode("#ff3399"));
		   pos.addActionListener(new ActionListener()
		   {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				EmployeePanel panel=new EmployeePanel(name);
				dispose();
			}
		   });
		   JButton changeuser=new JButton("Change User");
		   changeuser.setBounds(140,10,110,40);
		   changeuser.setBackground(Color.decode("#ff3399"));
		   changeuser.addActionListener(new ActionListener()
		   {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.gc();
				java.awt.Window win[] = java.awt.Window.getWindows(); 
				for(int i=0;i<win.length;i++){ 
				    win[i].dispose(); 
				    win[i]=null;
				} 
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
					pst.setString(3, "Cashier "+name+" logged out");
					pst.executeUpdate();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				Login login=new Login();
				
				
			}
			   
		   });
		   JButton exit=new JButton("Exit");
		   exit.setBounds(270,10,80,40);
		   exit.setBackground(Color.decode("#ff3399"));
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
					pst.setString(3, "Cashier "+name+" logged out");
					pst.executeUpdate();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				dispose();
				
			}
			   
		   });
		   JLabel todaydate=new JLabel();
		   todaydate.setBounds(960,20,80,20);
		   todaydate.setText(java.time.LocalDate.now().toString());
		   todaydate.setForeground(Color.white);
		   
		   navigation.add(todaydate);
		   navigation.add(exit);
		   navigation.add(changeuser);
		   navigation.add(pos);
		   
		   JPanel top_info=new JPanel();
		   top_info.setLayout(null);
		   top_info.setBounds(20,80,1040,40);
		   top_info.setBackground(Color.black);
		   JLabel user=new JLabel("Cashier:");
		   user.setBounds(10,10,50,20);
		   user.setForeground(Color.white);
		   JLabel user_info=new JLabel();
		   user_info.setBounds(70,10,80,20);
		   user_info.setText(name);
		   user_info.setForeground(Color.WHITE);
		   JLabel user_name=new JLabel();
		   user_name.setBounds(100,10,50,20);
		   user_name.setForeground(Color.white);
		   top_info.add(user);
		   top_info.add(user_info);
		   top_info.add(user_name);
		   
		   JPanel body=new JPanel();
		   body.setLayout(null);
		   body.setBounds(20,130,1040,480);
		   body.setBackground(Color.decode("#ff0066"));
		   
		   JLabel display=new JLabel("Display:");
		   display.setBounds(10,30,60,15);
		   
		   JPanel table_panel=new JPanel();
		   table_panel.setLayout(null);
		   table_panel.setBounds(10,95,1020,360);
		   String column[]={"Item Code","Item Name","Stocks","Price"};
		   String data[][]={
				   {"21082","hollowblock","679","5.62"},
				   {"76057","corseasand","2928","200.0"},
				   {"45847","rj-45","893","5.0"}
				   };
		   JTable jt=new JTable(data,column);
		   JScrollPane pane=new JScrollPane(jt);
		   pane.setBounds(0,0,1020,360);
		   table_panel.add(pane);
		   
		   JRadioButton allitem=new JRadioButton("All Item");
		   allitem.setBounds(70,30,70,15);
		   allitem.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) 
			{
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
					PreparedStatement pst=con.prepareStatement("select * from item_info");
					ResultSet rs=pst.executeQuery();
					jt.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			   
		   });
		   JRadioButton availableitem=new JRadioButton("Available Item");
		   availableitem.setBounds(160,30,110,15);
		   availableitem.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e)
			{
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
					PreparedStatement pst=con.prepareStatement("select * from item_info where stocks>100");
					ResultSet rs=pst.executeQuery();
					jt.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					con.close();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			   
		   });
		   JRadioButton outofstocks=new JRadioButton("Out Of Stocks");
		   outofstocks.setBounds(290,30,110,15);
		   outofstocks.addItemListener(new ItemListener(){
			   public void itemStateChanged(ItemEvent e)
			   {
				   try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
						PreparedStatement pst=con.prepareStatement("select * from item_info where stocks<100");
						ResultSet rs=pst.executeQuery();
						jt.setModel(DbUtils.resultSetToTableModel(rs));
						rs.close();
						con.close();
					}
					catch(Exception eu)
					{
						eu.printStackTrace();
					}
			   }
			   
		   });
		   ButtonGroup group=new ButtonGroup();
		   group.add(allitem);
		   group.add(availableitem);
		   group.add(outofstocks);
		   JLabel sortby=new JLabel("Sort By:");
		   sortby.setBounds(10,60,60,15);
		   String data_for_sortby[]={"Select Any","date_time","item_code","item_name","price","quantity","total"};
		   JComboBox sortby_combo=new JComboBox(data_for_sortby);
		   sortby_combo.setBounds(65,55,100,25);
		   JLabel searchby=new JLabel("Search By:");
		   searchby.setBounds(175,60,70,15);
		   JComboBox searchby_combo=new JComboBox(data_for_sortby);
		   searchby_combo.setBounds(245,55,100,25);
		   JTextField search_text=new JTextField();
		   search_text.setBounds(355,55,220,25);
		   JButton search_button=new JButton("Search");
		   search_button.setBounds(585,55,80,25);
		   search_button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				String sortby=sortby_combo.getSelectedItem().toString();
				String searchby=searchby_combo.getSelectedItem().toString();
				String text_value=search_text.getText();
				
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
					PreparedStatement pst=con.prepareStatement("select * from sales_information_real where "+searchby+" = ? order by " +sortby+" DESC");
					pst.setString(1,text_value);
					ResultSet rs=pst.executeQuery();
					
					jt.setModel(DbUtils.resultSetToTableModel(rs));
					con.close();
					rs.close();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			   
		   });
		   
		
		   
		   
		   body.add(table_panel);
		   body.add(display);
		   body.add(allitem);
		   body.add(availableitem);
		   body.add(outofstocks);
		   body.add(sortby);
		   body.add(searchby);
		   body.add(sortby_combo);
		   body.add(searchby_combo);
		   body.add(search_text);
		   body.add(search_button);
		   
		   
		   
		   
		   
		   
		   this.setBounds(50,50,1100,650);
		   this.setVisible(true);
		   this.setLayout(null);
		   this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		   this.setTitle("Cashier Data Analysis");
		   getContentPane().setBackground( Color.decode("#09eb45") );
		   this.add(navigation);
		   this.add(top_info);
		   this.add(body);
		   this.addWindowListener(new WindowListener()
		   {

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
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
					PreparedStatement pst=con.prepareStatement("select * from sales_information_real");
					ResultSet rs=pst.executeQuery();
					jt.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					con.close();
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
		CashierInventory i=new CashierInventory(null);
	}
	 
	
	
	
	
	  
    
}
