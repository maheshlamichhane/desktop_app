package quality.book.publication.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

public class SalesReport extends JFrame
{
	JTextField total=null;
	JTable table=null;


   public SalesReport(String name)
   {
	   JPanel header=new JPanel();
	   header.setLayout(null);
	   header.setBounds(0,0,1000,140);
	   header.setBackground(Color.DARK_GRAY);
	   JLabel header_text=new JLabel("Sales Report");
	   Font font=new Font(Font.SERIF,Font.BOLD,25);
	   header_text.setBounds(425,15,150,30);
	   header_text.setFont(font);
	   header_text.setForeground(Color.WHITE);
	   
	   JPanel separator=new JPanel();
	   separator.setBounds(0,60,1000,10);
	   separator.setBackground(Color.black);
	   header.add(separator);
	   header.add(header_text);
	   
	   JButton daillysales=new JButton("Dailly Sales");
	   daillysales.setBounds(190,90,140,30);
	  
	   JButton monthlysales=new JButton("Monthly Sales");
	   monthlysales.setBounds(350,90,140,30);
	   
	   JButton annualsales=new JButton("Annual Sales");
	   annualsales.setBounds(510,90,140,30);
	   JButton summaryofsales=new JButton("Summary Of Sales");
	   summaryofsales.setBounds(670,90,140,30);
	   
	   header.add(daillysales);
	   header.add(monthlysales);
	   header.add(annualsales);
	   header.add(summaryofsales);
	   
	   JPanel body=new JPanel();
	   Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	   body.setBorder(loweredetched);
	   body.setLayout(null);
	   body.setBounds(10,150,965,502);
	   
	   JLabel daillysalesreport_text=new JLabel("Dailly Sales Report Of ");
	   daillysalesreport_text.setBounds(10,20,130,15);
	   JLabel daillysalesreport_date=new JLabel();
	   daillysalesreport_date.setText(java.time.LocalDate.now().toString());
	   daillysalesreport_date.setBounds(140,20,70,15);
	   JLabel selectdate=new JLabel("Select Date");
	   selectdate.setBounds(700,20,70,15);
	   JDateChooser choose=new JDateChooser();
	   choose.setBounds(780,17,100,20);
       
	   
	   
	   
	   
	   JPanel table_data=new JPanel();
	   table_data.setLayout(null);
	   table_data.setBounds(10,45,945,420);
	   Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	   table=new JTable();
	   JScrollPane pane=new JScrollPane(table);
	   pane.setBounds(10,45,945,420);
	   pane.setBorder(loweredbevel);
	   daillysales.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				java.util.Calendar cal = Calendar.getInstance();
				java.util.Date utilDate = new java.util.Date(); // your util date
				cal.setTime(utilDate);    
				java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());
				
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
					PreparedStatement pst=con.prepareStatement("select * from sales_information_real where date_time=?");
					PreparedStatement pst2=con.prepareStatement("select sum(total) from sales_information_real where date_time=?");
				    pst.setDate(1, sqlDate);
				    pst2.setDate(1, sqlDate);
				    ResultSet rs=pst.executeQuery();
				    ResultSet rs2=pst2.executeQuery();
				    while(rs2.next())
				    {
				    	total.setText("Total="+rs2.getString(1));
				    }
				    table.setModel(DbUtils.resultSetToTableModel(rs));
				    rs.close();
					rs2.close();
				
					con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			   
		   });
	   monthlysales.addActionListener(new ActionListener()
	   {

		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			java.sql.Date date=new java.sql.Date(choose.getDate().getTime());
			int month=date.getMonth();
			
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
				PreparedStatement pst=con.prepareStatement("SELECT * FROM sales_information_real WHERE to_char(date_time, 'mon')='jun'");
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
						table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				
				
				rs.close();
				con.close();
			}
			catch(Exception ed)
			{
				ed.printStackTrace();
			}
		}
		   
	   });
	   annualsales.addActionListener(new ActionListener()
	   {

		@Override
		public void actionPerformed(ActionEvent e)
		{
	          Date dat=(Date) choose.getDate();
			
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
				PreparedStatement pst=con.prepareStatement("select datepart(YY,dats)");
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				rs.close();
				con.close();
			}
			catch(Exception ed)
			{
				ed.printStackTrace();
			}
		}
		   
	   });
	   
	   JButton importoexcel=new JButton("Import to Excel");
	   importoexcel.setBounds(10,470,120,25);
	   importoexcel.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			try
			{
			ExportDataToExcel data=new ExportDataToExcel();
			data.exportTable(table, new File("C:\\Users\\E15\\Desktop\\file\\sample.xls"));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		   
	   });
	   
	   total=new JTextField();
	   total.setBounds(835,470,120,25);
	   total.setBorder(loweredbevel);
	   
	   body.add(total);
	   body.add(importoexcel);
	   body.add(pane);
	   body.add(table_data);
	   body.add(daillysalesreport_date);
	   body.add(daillysalesreport_text);
	   body.add(selectdate);
	   body.add(choose);
	   
	   
	   
	   
	   
	   setBounds(100,10,1000,700);
	   setTitle("Sales Report");
	   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   setVisible(true);
	   setLayout(null);
	   add(header);
	   add(body);
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
				PreparedStatement pst2=con.prepareStatement("select sum(total) from sales_information_real");
				ResultSet rs=pst.executeQuery();
				ResultSet ps=pst2.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				while(ps.next())
				{
					total.setText("Total="+String.valueOf(ps.getInt(1)));
				}
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
	   SalesReport report=new SalesReport(null);
   }
   
 
 
 
 
  
}
