package quality.book.publication.admin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Logs extends JFrame
{

	public Logs(String name)
	{
		  JTable table1=new JTable();
		  JTable table2=new JTable();
		  JTable table3=new JTable();
		  
		  JPanel panel1=new JPanel();
		  JButton clearlog1=new JButton("    Clear Log    ");
		  panel1.add(clearlog1);
		  clearlog1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int x,y=0;
				java.util.Calendar cal = Calendar.getInstance();
				java.util.Date utilDate = new java.util.Date(); // your util date
				cal.setTime(utilDate);    
				java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
					PreparedStatement pst2=conn.prepareStatement("delete from system_log_data");
					y=pst2.executeUpdate();
					PreparedStatement pst=conn.prepareStatement("insert into system_log_data values(?,?,?)");
					pst.setDate(1, sqlDate);
					pst.setString(2, name);
					pst.setString(3, "clear all log");
					
					x=pst.executeUpdate();
					
					if(x>0 && y>0)
					{
						JOptionPane.showMessageDialog(null, "All Logs are cleared");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Sorry Problem Occured");
					}
					conn.close();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			  
		  });
		  JPanel panel2=new JPanel();
		  JButton clearlog2=new JButton("    Clear Log    ");
		  panel2.add(clearlog2);
		  clearlog2.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					int x,y=0;
					java.util.Calendar cal = Calendar.getInstance();
					java.util.Date utilDate = new java.util.Date(); // your util date
					cal.setTime(utilDate);    
					java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());
					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
						PreparedStatement pst2=conn.prepareStatement("delete from inventory_log_data");
						y=pst2.executeUpdate();
						PreparedStatement pst=conn.prepareStatement("insert into inventory_log_data values(?,?,?)");
						pst.setDate(1, sqlDate);
						pst.setString(2, name);
						pst.setString(3, "clear all log");
						
						x=pst.executeUpdate();
						
						if(x>0 && y>0)
						{
							JOptionPane.showMessageDialog(null, "All Logs are cleared");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Sorry Problem Occured");
						}
						conn.close();
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				  
			  });
		  JPanel panel3=new JPanel();
		  JButton clearlog3=new JButton("    Clear Log     ");
		  panel3.add(clearlog3);
		  clearlog3.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					int x,y=0;
					java.util.Calendar cal = Calendar.getInstance();
					java.util.Date utilDate = new java.util.Date(); // your util date
					cal.setTime(utilDate);    
					java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());
					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
						PreparedStatement pst2=conn.prepareStatement("delete from employee_log_data");
						y=pst2.executeUpdate();
						PreparedStatement pst=conn.prepareStatement("insert into employee_log_data values(?,?,?)");
						pst.setDate(1, sqlDate);
						pst.setString(2, name);
						pst.setString(3, "clear all log");
						
						x=pst.executeUpdate();
						
						if(x>0 && y>0)
						{
							JOptionPane.showMessageDialog(null, "All Logs are cleared");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Sorry Problem Occured");
						}
						conn.close();
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				  
			  });
		  panel1.add(new JScrollPane(table1));
		  panel2.add(new JScrollPane(table2));
		  panel3.add(new JScrollPane(table3));
		 
		  
		  JTabbedPane pane=new JTabbedPane();
		  pane.add("System Log",panel1);
		  pane.add("Inventory Log",panel2);
		  pane.add("Employee Log",panel3);
		  
		  
		  add(pane);
		  this.setVisible(true);
		  this.setBounds(40,45,550,550);
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
				public void windowOpened(WindowEvent arg0) {
					// TODO Auto-generated method stub
					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
						PreparedStatement pst=con.prepareStatement("select * from system_log_data");
						PreparedStatement pst2=con.prepareStatement("select * from inventory_log_data");
						PreparedStatement pst4=con.prepareStatement("select * from employee_log_data");
						ResultSet rs1=pst.executeQuery();
						ResultSet rs2=pst2.executeQuery();
						ResultSet rs3=pst4.executeQuery();
					
						table1.setModel(DbUtils.resultSetToTableModel(rs1));
						table2.setModel(DbUtils.resultSetToTableModel(rs2));
						table3.setModel(DbUtils.resultSetToTableModel(rs3));
						  }
			
					catch(Exception ep)
					{
						ep.printStackTrace();
					}
					
				}
				  
			  });
	}
	public static void main(String args[])
	{
	    Logs logs=new Logs("mahesh");
	}
}
