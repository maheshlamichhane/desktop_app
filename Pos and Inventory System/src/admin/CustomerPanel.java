package admin;

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.table.TableModel;

import home.Login;
import net.proteanit.sql.DbUtils;

public class CustomerPanel extends JFrame
{
	public CustomerPanel(String name)
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
		  Border border = BorderFactory.createTitledBorder("Customer Information Table");
		  middle.setBorder(border);
		  middle.setLayout(null);
		  
		  JPanel middle_left=new JPanel();
		  middle_left.setBounds(20,30,650,430);
		 
		  middle_left.setLayout(null);
		  
		  JPanel middle_right=new JPanel();
		  middle_right.setBounds(680,30,270,430);
		  middle_right.setLayout(null);
		  JTextArea text=new JTextArea("Display Customer Information");
		  text.setBounds(0,0,270,430);
		  Font ft=new Font(Font.SERIF,Font.BOLD,15);
		  text.setFont(ft);
		  
		  text.setBorder(loweredbevel);
		  middle_right.add(text);
		  
		  
		  middle.add(middle_left);
		  middle.add(middle_right);
		         
	      JTable jt=new JTable();  
	      jt.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0)
			{
			  int i=jt.getSelectedRow();
			  TableModel model=jt.getModel();
			  text.setText("");
			  text.append("Customer Name:"+model.getValueAt(i, 0).toString()+"\n");
			  text.append("Gender:"+model.getValueAt(i, 1).toString()+"\n");
			  text.append("Address:"+model.getValueAt(i, 2).toString()+"\n");
			  text.append("City:"+model.getValueAt(i, 3).toString()+"\n");
			  text.append("Province:"+model.getValueAt(i, 4).toString()+"\n");
			  text.append("Zip Code:"+model.getValueAt(i, 5).toString()+"\n");
			  text.append("Contact Number:"+model.getValueAt(i, 6).toString()+"\n");
			  text.append("Emial:"+model.getValueAt(i, 7).toString());
				
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
	      JScrollPane pane=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	      pane.setBounds(0,0,650,430); 
	      
	      pane.setBorder(loweredbevel);
	      middle_left.add(pane);
	      JTextField searchbox=new JTextField("Enter Name");
	      searchbox.setBounds(20,472,200,30);
	      searchbox.setBorder(loweredbevel);
	      searchbox.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0)
			{
			    searchbox.setText("");
				
			}

			@Override
			public void focusLost(FocusEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}
	    	  
	      });
	      JButton searchbutton=new JButton("Search");
	      searchbutton.setBounds(230,472,80,30);
	      searchbutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				
					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
						PreparedStatement pst=con.prepareStatement("select * from customer_information where name=?");
					    pst.setString(1, searchbox.getText());
					    ResultSet rs=pst.executeQuery();
					    jt.setModel(DbUtils.resultSetToTableModel(rs));
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				
			}
	    	  
	      });
		  
	
		  JButton showall=new JButton("Show All");
		  showall.setBounds(600,472,140,30);
		  showall.addActionListener(new ActionListener()
		  {

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
					PreparedStatement pst=con.prepareStatement("select * from customer_information order by name ASC");
					ResultSet rs=pst.executeQuery();
					jt.setModel(DbUtils.resultSetToTableModel(rs));
					
					con.close();
					rs.close();
				}
				catch(Exception e)
				{
					
			  
				}
			}
		  });
		  JButton button=new JButton("Delete Customer");
		  button.setBounds(750,472,140,30);
		  button.addActionListener(new ActionListener()
		  {

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				  int i=jt.getSelectedRow();
				  TableModel model=jt.getModel();
				  text.setText("");
				  String phone=model.getValueAt(i, 6).toString();
				
				  try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
						PreparedStatement pst=con.prepareStatement("delete from customer_information where contact_number=?");
						pst.setString(1, phone);
						int z=pst.executeUpdate();
						if(z>0)
						{
							JOptionPane.showMessageDialog(null, "Successfully Deleted");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Sorrry Problem Occured");
						}
					
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
			}
			  
		  });
		  middle.add(showall);
		  middle.add(button);
		  middle.add(searchbox);
		  middle.add(searchbutton);
	
	  
	  setBounds(20,20,1192,700);
	  setTitle("Lamichhane Inventory Management");
	  setVisible(true);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  setVisible(true);
	  setLayout(null);
	  setResizable(false);
	  add(menu);
	  add(left);
	  add(top);
	  add(middle);
	  this.addWindowListener(new WindowListener(){

		@Override
		public void windowActivated(WindowEvent arg0) 
		{
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
				PreparedStatement pst=con.prepareStatement("select * from customer_information order by name ASC");
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
	}
	
	public static void main(String args[])
	{
		CustomerPanel pan=new CustomerPanel(null);
	}
	
	
	
	
	 

}
