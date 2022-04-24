import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.WindowListener;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import net.proteanit.sql.DbUtils;



public class SaleProduct extends JFrame
{
	JPanel left,menu,main;
	JLabel leftheader;
	JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7;
	JPanel tablebody;
	JPanel tableheader;
	JPanel tabledata;
	
		
		
		
  public SaleProduct()
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
	  main.setBounds(120,11,652,460);
	  main.setBackground(Color.decode("#a558af"));
	  main.setLayout(null);
	  main.setBorder(loweredbevel);
	  
	  JLabel mainheaderr=new JLabel("Shopped Data");
	  mainheaderr.setBounds(210,0,200,40);
	  Font mainfont=new Font("Serif",Font.BOLD,30);
	  mainheaderr.setFont(mainfont);
	  
	  
	   
	 
	   
	   tableheader=new JPanel();
	   tableheader.setLayout(null);
	   tableheader.setBounds(17,30,615,40);
	   tableheader.setBackground(Color.decode("#7EB1B6"));
	   Font fun=new Font("Serif",Font.BOLD,10);
	   tableheader.add(mainheaderr);
	   
	   
	   tablebody=new JPanel();
	   tablebody.setBounds(17,70,615,260);
	   tablebody.setBackground(Color.decode("#0A1CCD"));
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
	      pane.setBounds(0,0,617,260);  
	      pane.setBorder(loweredbevel);
	      tablebody.add(pane);
	   
	   
	   main.add(tableheader);
	   main.add(tablebody);
	   
	   
	   
	   JPanel bottompanel=new JPanel();
	   bottompanel.setLayout(null);
	   bottompanel.setBounds(18,340,615,110);
	   bottompanel.setBackground(Color.cyan);
	   
	   
	   JLabel itemcode=new JLabel("Item Code:");
	   itemcode.setBounds(10,10,70,15);
	   JLabel itemcodetext=new JLabel("101");
	   itemcodetext.setBounds(90,10,100,15);
	   
	   JLabel itemname=new JLabel("Item Name:");
	   itemname.setBounds(10,35,70,15);
	   JLabel itemnametext=new JLabel("Pangra");
	   itemnametext.setBounds(90,35,100,15);
	   
	   JLabel itemcategory=new JLabel("Category:");
	   itemcategory.setBounds(12,60,70,15);
	   JLabel categorytext=new JLabel("chicken");
	   categorytext.setBounds(90,60,100,15);
	   
	   JLabel price=new JLabel("Price:");
	   price.setBounds(18,85,70,15);
	   JLabel pricetext=new JLabel("300");
	   pricetext.setBounds(90,85,100,15);
	   
	   
	   JLabel itemnameprocess=new JLabel("Item Name");
	   itemnameprocess.setBounds(200,5,70,10);
	   
	   JTextField itemnameprocesstext=new JTextField();
	   itemnameprocesstext.setBounds(200,20,400,20);
	   itemnameprocesstext.setBorder(loweredbevel);
	  itemnameprocesstext.addKeyListener(new KeyListener()
	  {

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
			try
			{
				Class.forName("org.sqlite.JDBC");
				Connection con=DriverManager.getConnection("jdbc:sqlite:meathub.db");
				PreparedStatement pst=con.prepareStatement("select * from item_information where item_name=?");
				pst.setString(1, itemnameprocesstext.getText());
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					itemcodetext.setText(String.valueOf(rs.getInt(1)));
					itemnametext.setText(rs.getString(2));
					pricetext.setText(String.valueOf(rs.getDouble(3)));
					categorytext.setText(rs.getString(4));
				
				}
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}

		@Override
		public void keyTyped(KeyEvent arg0)
		{
			
			
		}
		  
	  });
	   
	   
	   
	   
	   JLabel quantityprocess=new JLabel("Quantity");
	   quantityprocess.setBounds(200,43,50,13);
	   
	   JTextField totalprocesstext=new JTextField();
	   totalprocesstext.setBounds(320,60,110,20);
	   totalprocesstext.setBorder(loweredbevel);
	   
	   JTextField quantityprocesstext=new JTextField();
	   quantityprocesstext.setBounds(200,60,110,20);
	   
	   quantityprocesstext.setBorder(loweredbevel);
	   quantityprocesstext.addKeyListener(new KeyListener()
	   {

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) 
		{
			
			double x;
			// TODO Auto-generated method stub
			if(quantityprocesstext.getText().equals(""))
			{
				totalprocesstext.setText("0");
			}
			else
			{
			x=Double.parseDouble(quantityprocesstext.getText());
			double y=Double.parseDouble(pricetext.getText());
			double z=x*y;
			totalprocesstext.setText(String.valueOf(z));
			}
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		   
	   });
	   quantityprocesstext.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = quantityprocesstext.getText();
	            int l = value.length();
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode()==KeyEvent.VK_BACK_SPACE || ke.getKeyChar()=='.') {
	               quantityprocesstext.setEditable(true);
	            } else {
	            	JOptionPane.showMessageDialog(null, "please enter only numeric data");
	               String orginal=quantityprocesstext.getText();
	               int len=orginal.length();
	               String org=orginal.substring(0,len-1);
	               quantityprocesstext.setText(org);
	               
	            }
	         }
	      });
	   
	   
	   
	  
	   JButton addtocart=new JButton("Add To Cart");
	   addtocart.setBounds(440,50,160,30);
	   addtocart.addActionListener(new ActionListener() 
	   {

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			if(itemnameprocesstext.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter item name first");
			}
			else if(quantityprocesstext.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter quanity first");
			}
			
			else
			{
				
			
		   try
		   {
			   Class.forName("org.sqlite.JDBC");
			   Connection conn=DriverManager.getConnection("jdbc:sqlite:meathub.db");
			   PreparedStatement pst=conn.prepareStatement("insert into sales_duplicate values(?,?,?,?,?,?)");
			   pst.setInt(1, Integer.parseInt(itemcodetext.getText()));
			   pst.setString(2, itemnametext.getText());
			   pst.setString(3, categorytext.getText());
			   pst.setDouble(4, Double.parseDouble(pricetext.getText()));
			   pst.setDouble(5, Double.parseDouble(quantityprocesstext.getText()));
			   pst.setDouble(6, Double.parseDouble(totalprocesstext.getText()));
			   
			   PreparedStatement stkget=conn.prepareStatement("select stocks from item_information where item_name=?");
				stkget.setString(1, itemnametext.getText());
				PreparedStatement ko=conn.prepareStatement("select * from item_information where item_name=?");
				ko.setString(1, itemnametext.getText());
				ResultSet xs=ko.executeQuery();
				ResultSet poxs=stkget.executeQuery();
				if(xs.next())
				{
				double dat=Double.parseDouble(quantityprocesstext.getText());
				double stk = 0;
				while(poxs.next())
				{
					stk=poxs.getInt(1);
				}
				double newstk=stk-dat;
				if(newstk<0)
				{
					JOptionPane.showMessageDialog(null, "Sorry Out Of Stock Only "+(dat+newstk)+" Remaining");
					
				}
				else
				{
			   int z=pst.executeUpdate();
			   if(z>0)
			   {
				   JOptionPane.showMessageDialog(null, "Data inserted to duplicate database successfully");
				   itemnameprocesstext.setText("");
				   quantityprocesstext.setText("");
				   totalprocesstext.setText("");
			   }
		   }
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Soryy item not found");
				}
				conn.close();
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
			}
		}
		   
	   });
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   JButton process=new JButton("Process");
	   process.setBounds(200,85,90,20);
	   process.addActionListener(new ActionListener()
	   {

		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			
			try
			{
				Class.forName("org.sqlite.JDBC");
				Connection con=DriverManager.getConnection("jdbc:sqlite:meathub.db");
				PreparedStatement pst=con.prepareStatement("select * from sales_duplicate");
				PreparedStatement pst2=con.prepareStatement("insert into sales_real values(?,?,?,?,?,?)");
				
				ResultSet rs=pst.executeQuery();
				List<ItemModal> duplist=new ArrayList<ItemModal>();
				double sum=0;
				while(rs.next())
				{
					ItemModal m=new ItemModal();
					m.setItem_code(rs.getInt(1));
					m.setItem_name(rs.getString(2));
					m.setItem_category(rs.getString(3));
					m.setItem_price(rs.getDouble(4));
					m.setQuantity(rs.getDouble(5));
					m.setTotal(rs.getDouble(6));
					duplist.add(m);
							
				}
				PreparedStatement post=con.prepareStatement("select * from sales_real");
				ResultSet pos=post.executeQuery();
				List<ItemModal> realist=new ArrayList<ItemModal>();
				while(pos.next())
				{
					ItemModal m=new ItemModal();
					m.setItem_code(pos.getInt(1));
					m.setItem_name(pos.getString(2));
					m.setItem_category(pos.getString(3));
					m.setItem_price(pos.getDouble(4));
					m.setQuantity(pos.getDouble(5));
					m.setTotal(pos.getDouble(6));
					realist.add(m);
				}
				int z=0;
					 
					for(ItemModal mp:duplist)
					{
						PreparedStatement stkget=con.prepareStatement("select stocks from item_information where item_name=?");
						stkget.setString(1, mp.getItem_name());
						ResultSet poxs=stkget.executeQuery();
						double dat=mp.getQuantity();
						double stk = 0;
						while(poxs.next())
						{
							stk=poxs.getDouble(1);
						}
						double newstk=stk-dat;
						if(newstk<0)
						{
							JOptionPane.showMessageDialog(null, "Item is out of stock Only"+(dat+newstk)+"Remaining");
						}
						else
						{
					 PreparedStatement pstpx=con.prepareStatement("update item_information set stocks=? where item_name=?");
					   pstpx.setDouble(1, newstk);
					   pstpx.setString(2, mp.getItem_name());
					   pstpx.executeUpdate();
						
								pst2.setInt(1, mp.getItem_code());
								pst2.setString(2,mp.getItem_name());
								pst2.setString(3, mp.getItem_category());
								pst2.setDouble(4, mp.getItem_price());
								pst2.setDouble(5, mp.getQuantity());
								pst2.setDouble(6, mp.getTotal());
								sum+=mp.getTotal();
								z=pst2.executeUpdate();
						}
								
								
							
						
					}
					
					
					
				
	
				if(z>0)
				{
					JOptionPane.showMessageDialog(null, "Data inserted to real database successfully" );
					PopUpWindow window=new PopUpWindow(sum);
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Sorry There is no data in shopping list");
				}
				con.close();
				
				
				
			}
			catch(Exception ev)
			{
				ev.printStackTrace();
			}
			
			
		}
		   
	   });
	   
	 
	   JButton showall=new JButton("Show All");
	   showall.setBounds(303,85,90,20);
	   showall.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e)
		{
		   try
		   {
			   Class.forName("org.sqlite.JDBC");
			   Connection conn=DriverManager.getConnection("jdbc:sqlite:meathub.db");
			   PreparedStatement pst=conn.prepareStatement("select * from sales_duplicate");
			   ResultSet rs=pst.executeQuery();
			   pt.setModel(DbUtils.resultSetToTableModel(rs));
				rs.close();
				conn.close();
		   }
		   catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		}
		   
	   });
	   
	   
	   JButton clear=new JButton("Clear");
	   clear.setBounds(406,85,90,20);
	   clear.addActionListener(new ActionListener() 
	   {

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			   itemnameprocesstext.setText("");
			   quantityprocesstext.setText("");
			   totalprocesstext.setText("");
	
			 try
			   {
				 
				   Class.forName("org.sqlite.JDBC");
				   Connection conn=DriverManager.getConnection("jdbc:sqlite:meathub.db");
				   PreparedStatement pst=conn.prepareStatement("delete from sales_duplicate");
				   int x=pst.executeUpdate();
				   if(x>0)
				   {
					   JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
				   }
				   conn.close();
				  
				 
			   }
			   catch(Exception ec)
			   {
				   ec.printStackTrace();
			   }
		}
	
		   
	   });
	   JButton cancel=new JButton("Cancel");
	   cancel.setBounds(510,85,90,20);
	   cancel.addActionListener(new ActionListener()
	   {

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			System.exit(0);
		}
		   
	   });
	   
	   
	   
	   
	   bottompanel.add(itemcode);
	   bottompanel.add(itemname);
	   bottompanel.add(itemcategory);
	   bottompanel.add(price);
	   bottompanel.add(itemcodetext);
	   bottompanel.add(itemnametext);
	   bottompanel.add(pricetext);
	   bottompanel.add(categorytext);
	   bottompanel.add(itemnameprocesstext);
	   bottompanel.add(itemnameprocess);
	   bottompanel.add(quantityprocess);
	   bottompanel.add(quantityprocesstext);
	   bottompanel.add(totalprocesstext);
	   bottompanel.add(addtocart);
	   bottompanel.add(cancel);
	   bottompanel.add(clear);
	   bottompanel.add(process);
	   bottompanel.add(showall);
	 
	   
	  
	  main.add(bottompanel);
	  
	  
	  
	  
	  setTitle("Village Meat Hub");
	  getContentPane().setBackground( Color.decode("#f8ec38") );
	  setLayout(null);
	  setVisible(true);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setResizable(false);
	  setBounds(300,150,788,510);
	  
	  add(left);
	  add(menu);
	  add(main);
	  addWindowListener(new WindowListener() {

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
				   Class.forName("org.sqlite.JDBC");
				   Connection conn=DriverManager.getConnection("jdbc:sqlite:meathub.db");
				   PreparedStatement pst=conn.prepareStatement("select * from sales_duplicate");
				   ResultSet rs=pst.executeQuery();
				   pt.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					conn.close();
					   
					   
					  
					 
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
	  SaleProduct product=new SaleProduct();
  }
}
