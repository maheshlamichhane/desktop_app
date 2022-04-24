package quality.book.publication.home;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import quality.book.publication.admin.AdminPanel;

import quality.book.publication.employee.EmployeePanel;

public class Login extends JFrame
{
	

	public Login()
	{
		
		JLabel header=new JLabel("Lamichhane Construction Suppliers");
		header.setForeground(Color.WHITE);
		header.setLocation(70,20);
		header.setSize(260,15);
		Font  font  = new Font(Font.SANS_SERIF,  Font.BOLD, 15);
		header.setFont(font);
		
		JLabel acc_name_label=new JLabel("Account Name:");
		acc_name_label.setBounds(70, 100, 90, 10);
		acc_name_label.setForeground(Color.white);
		
		JLabel password_label=new JLabel("Password:");
		password_label.setBounds(80,150,65,10);
		password_label.setForeground(Color.WHITE);
		JTextField usernamefield=new JTextField();
		usernamefield.setBounds(190, 90, 120, 25);
		JPasswordField passwordfield=new JPasswordField();
		passwordfield.setBounds(190,140,120,25);
		
		
		
		
		JCheckBox decide=new JCheckBox("(show Password)");
		Font  font_decide  = new Font(Font.SANS_SERIF,  Font.PLAIN,7);
		decide.setFont(font_decide);
		decide.setForeground(Color.BLACK);
		decide.setBounds(190,170,80,15);
		decide.setBackground(Color.GRAY);
		decide.setForeground(Color.white);
		decide.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(decide.isSelected())
				{
					passwordfield.setEchoChar((char)0);
				}
				else
				{
					passwordfield.setEchoChar('*');
				}
				
			}
			
		});
		
		JButton login=new JButton("Login");
		login.setBounds(100, 210, 80, 30);
		login.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				
				
				
				String name=usernamefield.getText();
				@SuppressWarnings("deprecation")
				String pass=passwordfield.getText();
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
					PreparedStatement pst1=con.prepareStatement("select * from admin where name=? and password=?");
					pst1.setString(1, name);
					pst1.setString(2, pass);
					PreparedStatement pst2=con.prepareStatement("select * from employee where name=? and password=?");
					pst2.setString(1, name);
					pst2.setString(2, pass);
					ResultSet rs1=pst1.executeQuery();
					ResultSet rs2=pst2.executeQuery();
					
					
				
					int x=0,y=0;
					while(rs1.next())
					{
						if(name.equals(rs1.getString(1))&&pass.equals(rs1.getString(2)))
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
								pst.setString(3, "Admin "+name+" logged in");
								pst.executeUpdate();
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
							
							AdminPanel panel =new AdminPanel(usernamefield.getText());
							dispose();
							x=1;
							
						}
					}
					while(rs2.next())
					{
						if(name.equals(rs2.getString(1))&&pass.equals(rs2.getString(2)))
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
								pst.setString(3, "Cashier "+name+" logged in");
								pst.executeUpdate();
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
							EmployeePanel pa=new EmployeePanel(name);
							dispose();
							y=1;
						}
					}
					if(x==0 && y==0)
					{
						JOptionPane.showMessageDialog(null, "Invalid Input");
					}
					
					
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
			}
			
		});
		
		
		
		
		
		JButton cancel=new JButton("Cancel");
		cancel.setBounds(210,210,80,30);
		cancel.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
				
			}
			
		});
	
		
		
	
		ImageIcon img=new ImageIcon("C:/Users/E15/Desktop/POS and inventory/image/21078913.jpg");
		setTitle("Login");
		setSize(400,300);
		setLocation(500,250);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.GRAY);
		setIconImage(img.getImage());
		this.setResizable(false);
		
		add(header);
		add(acc_name_label);
		add(password_label);
		add(usernamefield);
		add(passwordfield);
		add(decide);
		add(login);
		add(cancel);

		
	
		
	}
	  public static void main(String args[])
	   {
		  Login login=new Login();
	   }

	
	
	

	 
	
	
	

	

	

}
