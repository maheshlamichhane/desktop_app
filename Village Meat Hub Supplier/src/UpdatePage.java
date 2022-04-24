import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class UpdatePage extends JFrame
{
	
	Font forheader;
	Font forlabel;
	Font fortextbox;
	JLabel usernamelabel,passwordlabel,header,repasswordlabel,oldpasswordlabel;
	JTextField usernamefield;
	JPasswordField passwordfield,repasswordfield,oldpasswordfield;
	JButton cancelbutton,updatebutton;
	String username,password,repassword,oldpassword;
	String dbusername,dbpassword;
	
	public UpdatePage()
	{
		  Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		  
		  forheader=new Font("Serif",Font.BOLD,40);
		  forlabel=new Font("Serif",Font.BOLD,18);
		  fortextbox=new Font("Serif",Font.BOLD,15);
		   header=new JLabel("Meat Hub Suppliers");
		   header.setBounds(75,20,350,50);
		   header.setFont(forheader);
		   
		   usernamelabel=new JLabel("Enter username:");
		   usernamelabel.setBounds(75,90,150,25);
		   usernamelabel.setFont(forlabel);
		   
		   usernamefield=new JTextField();
		   usernamefield.setBounds(230,93,185,25);
		   usernamefield.setBorder(loweredbevel);
		   usernamefield.setFont(fortextbox);
		   usernamefield.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				usernamefield.setBackground(Color.white);
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			   
			   
		   });
		   
		   passwordlabel=new JLabel("Enter password:");
		   passwordlabel.setBounds(75,140,150,25);
		   passwordlabel.setFont(forlabel);
		   
		   
		   repasswordfield=new JPasswordField();
		   repasswordfield.setBounds(230,190,185,25);
		   repasswordfield.setBorder(loweredbevel);
		   repasswordfield.setFont(fortextbox);
		   repasswordfield.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				repasswordfield.setBackground(Color.white);
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			   
		   });
		   
		   oldpasswordfield=new JPasswordField();
		   oldpasswordfield.setBounds(230,240,185,25);
		   oldpasswordfield.setFont(fortextbox);
		   oldpasswordfield.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				oldpasswordfield.setBackground(Color.white);
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			   
		   });
		   
		   passwordfield=new JPasswordField();
		   passwordfield.setBounds(230,140,185,25);
		   passwordfield.setBorder(loweredbevel);
		   passwordfield.setFont(fortextbox);
		   passwordfield.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				passwordfield.setBackground(Color.white);
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			   
		   });
		   
		   repasswordlabel=new JLabel("Re-enter password:");
		   repasswordlabel.setBounds(75,190,175,25);
		   repasswordlabel.setFont(forlabel);
		  
		   
		   oldpasswordlabel=new JLabel("Enter old password:");
		   oldpasswordlabel.setBounds(75,240,175,25);
		   oldpasswordlabel.setFont(forlabel);
		   
		   
		   
		 
		   
		   updatebutton=new JButton("Upadate");
		   updatebutton.setBounds(135,285,100,40);
		   updatebutton.setBackground(Color.decode("#FF5733"));
		   updatebutton.setForeground(Color.white);
		   updatebutton.addActionListener(new ActionListener() 
		   {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				username=usernamefield.getText();
				password=passwordfield.getText();
				repassword=repasswordfield.getText();
				oldpassword=oldpasswordfield.getText();
				
				if(username.equals(""))
				{
					usernamefield.setBackground(Color.yellow);
					JOptionPane.showMessageDialog(null, "Username field can't be empty");
				}
				else if(username.length()>20)
				{
					usernamefield.setBackground(Color.yellow);
					JOptionPane.showMessageDialog(null, "Username field size can't be more than 20");
				}
				else if(password.equals(""))
				{
					passwordfield.setBackground(Color.yellow);
					JOptionPane.showMessageDialog(null, "Password field can't be empty");
				}
				else if(password.length()>20)
				{
					passwordfield.setBackground(Color.yellow);
					JOptionPane.showMessageDialog(null, "Password field size can't be more than 20");
				}
				else if(repassword.equals(""))
				{
					repasswordfield.setBackground(Color.yellow);
					JOptionPane.showMessageDialog(null, "Re enter password field can't be empty" );
				}
				else if(repassword.length()>20)
				{
					repasswordfield.setBackground(Color.yellow);
					JOptionPane.showMessageDialog(null, "Re-enter password field size can't be more than 20");
				}
				else if(!password.equals(repassword))
				{
					JOptionPane.showMessageDialog(null, "Password must be same for both field");
				}
				else if(oldpassword.equals(""))
				{
					oldpasswordfield.setBackground(Color.yellow);
					JOptionPane.showMessageDialog(null, "Old Password field can't be empty");
				}
				else if(oldpassword.length()>20)
				{
					oldpasswordfield.setBackground(Color.yellow);
					JOptionPane.showMessageDialog(null, "Old password field size must be less than or equal to 20");
				}
				else
				{
					try
					{
						Class.forName("org.sqlite.JDBC");
						Connection con=DriverManager.getConnection("jdbc:sqlite:meathub.db");
						PreparedStatement pst1=con.prepareStatement("select * from login_info");
						ResultSet rs=pst1.executeQuery();
						while(rs.next())
						{   dbusername=rs.getString(1);
						    dbpassword=rs.getString(2);
						}
						
						if(oldpassword.equals(dbpassword))
						{
							PreparedStatement pst2=con.prepareStatement("update login_info set username=?,password=? where password=?");
							pst2.setString(1, username);
							pst2.setString(2, password);
							pst2.setString(3, dbpassword);
							int x=pst2.executeUpdate();
							if(x>0)
							{
								JOptionPane.showMessageDialog(null, "Username and password updated successfully");
								usernamefield.setText("");
								passwordfield.setText("");
								repasswordfield.setText("");
								oldpasswordfield.setText("");
								dispose();
								LoginPage page=new LoginPage();
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Sorry Invalid Data");
							}
		   
						}
						con.close();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
			}
			   
		   });
		   
		  
		   cancelbutton=new JButton("Cancel");
		   cancelbutton.setBounds(255,285,100,40);
		   cancelbutton.setBackground(Color.decode("#FF5733"));
		   cancelbutton.setForeground(Color.white);
		   cancelbutton.addActionListener(new ActionListener()
		   {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				LoginPage page=new LoginPage();
				
			}
			   
			   
		   });
		   
		   
		 
		  
		  
		  setVisible(true);
		  setTitle("Login");
		  setBounds(40,40,500,300);
		  getContentPane().setBackground( Color.decode("#EA2016") );
		  setLayout(null);
		  
		  add(header);
		  add(usernamelabel);
		  add(usernamefield);
		  add(passwordlabel);
		  add(passwordfield);
		  add(oldpasswordfield);
		  add(oldpasswordlabel);
	
		  add(updatebutton);
		  add(cancelbutton);
		  add(repasswordlabel);
		  add(repasswordfield);
		  
		  
		setBounds(50,50,500,370);
		setTitle("Update");
		getContentPane().setBackground( Color.decode("#EC03B0") );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		setVisible(true);
	}
	 public static void main(String args[]) 
	  {
	      
		  UpdatePage page=new UpdatePage();
	  }

}
