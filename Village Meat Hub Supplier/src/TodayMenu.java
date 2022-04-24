import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import net.proteanit.sql.DbUtils;

public class TodayMenu extends JFrame
{
	JPanel left,menu,main,top;
	JLabel leftheader,todaymenuheader;
	JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7;
	JPanel tablebody;
  public TodayMenu()
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
	  main.setBounds(120,11,604,460);
	  main.setBackground(Color.decode("#a558af"));
	  main.setLayout(null);
	  main.setBorder(loweredbevel);
	  
	  todaymenuheader=new JLabel("Today's Menu");
	  todaymenuheader.setBounds(200,0,200,35);
	  Font fonn=new Font("Serif" ,Font.BOLD,30);
	  todaymenuheader.setFont(fonn);
	  
	  JPanel tableheader=new JPanel();
	  tableheader.setLayout(null);
	  tableheader.setBackground(Color.decode("#E74C3C"));
	  tableheader.setBounds(20,35,560,40);
	  tableheader.add(todaymenuheader);
	  
	  
	  
	  
	   
	  
	  tablebody=new JPanel();
	  tablebody.setBounds(20,75,560,355);
	  tablebody.setBackground(Color.decode("#707B7C"));
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
      pane.setBounds(0,0,563,355);  
      pane.setBorder(loweredbevel);
      tablebody.add(pane);
	  
	  
	 
	
	  
	  
	  
	  
	  
	  
	  
	  main.add(tableheader);
	  main.add(tablebody);
	  
	  
	  
	  
	  setTitle("Village Meat Hub");
	  getContentPane().setBackground( Color.decode("#f8ec38") );
	  setLayout(null);
	  setVisible(true);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setResizable(false);
	  setBounds(300,150,740,509);
	  
	  
	  add(left);
	  add(menu);
	  add(main);
	  addWindowListener(new WindowListener() {

		@Override
		public void windowActivated(WindowEvent arg0)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) 
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent arg0) 
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent arg0)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) 
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent arg0) 
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent arg0)
		{
		   try
		   {
			   Class.forName("org.sqlite.JDBC");
			   Connection con=DriverManager.getConnection("jdbc:sqlite:meathub.db");
			   PreparedStatement pst=con.prepareStatement("select * from item_information order by item_code");
			   ResultSet rs=pst.executeQuery();
			   pt.setModel(DbUtils.resultSetToTableModel(rs));
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
	  TodayMenu menu=new TodayMenu();
  }
}
