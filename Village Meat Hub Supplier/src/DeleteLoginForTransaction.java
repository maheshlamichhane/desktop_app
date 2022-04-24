import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.event.FocusListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeleteLoginForTransaction extends JFrame
{
	Font forheader;
	Font forlabel;
	Font fortextbox;
	JLabel usernamelabel,passwordlabel,header;
	JTextField usernamefield;
	JPasswordField passwordfield;
	JButton cancelbutton,loginbutton,updatebutton;
	String username,password;
	int flag=0;
	
  public DeleteLoginForTransaction()
  {
	  
	  
	  Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	  
	  forheader=new Font("Serif",Font.BOLD,40);
	  forlabel=new Font("Serif",Font.BOLD,20);
	  fortextbox=new Font("Serif",Font.BOLD,15);
	   header=new JLabel(" Village Meat Hub ");
	   header.setBounds(75,30,350,50);
	   header.setForeground(Color.decode("#2e56e6"));
	   header.setFont(forheader);
	   
	   usernamelabel=new JLabel("Enter Username:");
	   usernamelabel.setBounds(75,90,150,25);
	   usernamelabel.setForeground(Color.decode("#2e56e6"));
	   usernamelabel.setFont(forlabel);
	   
	   usernamefield=new JTextField();
	   usernamefield.setBounds(230,93,185,25);
	   usernamefield.setBorder(loweredbevel);
	   usernamefield.setFont(fortextbox);
	   usernamefield.addFocusListener(new FocusListener() {

		@Override
		public void focusGained(FocusEvent e) 
		{
			usernamefield.setBackground(Color.white);
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}
		   
	   });
	   
	   passwordlabel=new JLabel("Enter Password:");
	   passwordlabel.setBounds(75,140,150,25);
	   passwordlabel.setForeground(Color.decode("#2e56e6"));
	   passwordlabel.setFont(forlabel);
	   
	   passwordfield=new JPasswordField();
	   passwordfield.setBounds(230,140,185,25);
	   passwordfield.setBorder(loweredbevel);
	   passwordfield.setFont(fortextbox);
	   passwordfield.addFocusListener(new FocusListener() {

		@Override
		public void focusGained(FocusEvent e)
		{
			passwordfield.setBackground(Color.white);
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}
		   
	   });
	   
	   loginbutton=new JButton("Login");
	   loginbutton.setBounds(75,190,100,40);
	   loginbutton.setBackground(Color.decode("#4287f5"));
	   loginbutton.setForeground(Color.white);
	   loginbutton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e)
		{
			username=usernamefield.getText();
			password=passwordfield.getText();
			if(username.equals(""))
			{
				usernamefield.setBackground(Color.decode("#ff0000"));
				JOptionPane.showMessageDialog(null, "Username can't be empty");
			}
			else if(username.length()>30)
			{
				usernamefield.setBackground(Color.yellow);
				JOptionPane.showMessageDialog(null, "Username size can't be greater than 20");
			}
			else if(password.equals(""))
			{
				passwordfield.setBackground(Color.decode("#ff0000"));
				JOptionPane.showMessageDialog(null,"Password can't be empty");
			}
			else if(password.length()>30)
			{
				passwordfield.setBackground(Color.yellow);
				JOptionPane.showMessageDialog(null, "Password size can't be greater than 20");
			}
			else
			{
				try
				{
					int x=0;
					Class.forName("org.sqlite.JDBC");
					Connection con=DriverManager.getConnection("jdbc:sqlite:meathub.db");
					PreparedStatement pst=con.prepareStatement("select * from login_info");
					ResultSet xs=pst.executeQuery();
					while(xs.next())
					{
					   if(username.equals(xs.getString(1)) && password.equals(xs.getString(2)))
					   {
						   x=1;
					   }
					
					}
					if(x>0)
					{
						 try
						   {
							   Class.forName("org.sqlite.JDBC");
							   Connection conn=DriverManager.getConnection("jdbc:sqlite:meathub.db");
							   PreparedStatement pstz=conn.prepareStatement("delete from customer_trans_table");
							   int h=pstz.executeUpdate();
							   if(h>0)
							   {
								   JOptionPane.showMessageDialog(null, "Data Successfully Deleted");
							   }
							   else
							   {
								   JOptionPane.showMessageDialog(null, "Sorry Problem Occured");
							   }
							   conn.close();
								 
							   }
						   catch(Exception ez)
						   {
							   ez.printStackTrace();
						   }
						 dispose();
						 Home hm=new Home();
						  
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Sorry Invalid Login");
					}
					con.close();
					
					
					
				}
				catch(Exception ef)
				{
					ef.printStackTrace();
				}
			}
			
			
			
		}
		   
	   });
	   
	   updatebutton=new JButton("Upadate");
	   updatebutton.setBounds(195,190,100,40);
	   updatebutton.setBackground(Color.decode("#4287f5"));
	   updatebutton.setForeground(Color.white);
	   updatebutton.addActionListener(new ActionListener()
	   {

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			
			
			
			
			UpdatePage page=new UpdatePage();
		    dispose();
			
		}
		   
	   });
	   
	  
	   cancelbutton=new JButton("Cancel");
	   cancelbutton.setBounds(315,190,100,40);
	   cancelbutton.setBackground(Color.decode("#4287f5"));
	   cancelbutton.setForeground(Color.white);
	   cancelbutton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.exit(0);
			
		}
		   
	   });
	   
	   
	 
	  
	  
	  setVisible(true);
	  setTitle("Login");
	  setBounds(40,40,500,300);
	  getContentPane().setBackground( Color.decode("#f8eb36") );
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setResizable(false);
	  setLayout(null);
	  
	  add(header);
	  add(usernamelabel);
	  add(usernamefield);
	  add(passwordlabel);
	  add(passwordfield);
	  add(loginbutton);
	  add(updatebutton);
	  add(cancelbutton);
  }
  
  public static void main(String args[])
  {
	  LoginPage page=new LoginPage();
  }
  
 
}
