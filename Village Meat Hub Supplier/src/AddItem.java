import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class AddItem extends JFrame
{
	JPanel left,main,top;
	JLabel leftheader,additemainheader,itemcode,itemname,itemprice,itemcategory,stocks;
	JButton btn1,btn2,btn3,btn4,btn5,btn6,stock,cancel,btn7;
	JTextField itemcodetext,itemnametext,itempricetext,stockstextbox;
	JComboBox itemcategorytext;
	JButton menu;
	
	
	
  public AddItem()
  {
	  Border emptyBorder = BorderFactory.createEmptyBorder();
	  
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
	  main.setBounds(120,10,603,460);
	  main.setBackground(Color.decode("#a558af"));
	  main.setLayout(null);
	  main.setBorder(loweredbevel);
	  
	  additemainheader=new JLabel("Add Item");
	  additemainheader.setBounds(220,50,200,50);
	  Font fonn=new Font("Serif" ,Font.BOLD,40);
	  additemainheader.setFont(fonn);
	  
	  itemcode=new JLabel("Item Code:");
	  itemcode.setBounds(120,130,100,20);
	  Font fox=new Font("Serif",Font.BOLD,20);
	  itemcode.setFont(fox);
	  
	  itemcodetext=new JTextField();
	  itemcodetext.setBounds(240,125,240,30);
	  Font fob=new Font("Serif",Font.BOLD,15);
	  itemcodetext.setFont(fob);
	  itemcodetext.setBorder(loweredbevel);
	  itemcodetext.addFocusListener(new FocusListener() {

		@Override
		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			itemcodetext.setBackground(Color.white);
			
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		  
	  });
	  itemcodetext.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = itemcodetext.getText();
	            int l = value.length();
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
	               itemcodetext.setEditable(true);
	            } else {
	            	JOptionPane.showMessageDialog(null, "please enter only numeric data");
	               String orginal=itemcodetext.getText();
	               int len=orginal.length();
	               String org=orginal.substring(0,len-1);
	               itemcodetext.setText(org);
	               
	            }
	         }
	      });
	  
	  itemname=new JLabel("Item Name:");
	  itemname.setBounds(120,170,100,20);
	  itemname.setFont(fox);
	  
	  itemnametext=new JTextField();
	  itemnametext.setBounds(240,165,240,30);
	  itemnametext.setFont(fob);
	  itemnametext.setBorder(loweredbevel);
	  itemnametext.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				itemnametext.setBackground(Color.white);
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			  
		  });
	  
	  itemprice=new JLabel("Item Price:");
	  itemprice.setBounds(120,210,100,20);
	  itemprice.setFont(fox);
	  
	  itempricetext=new JTextField();
	  itempricetext.setBounds(240,205,240,30);
	  itempricetext.setFont(fob);
	  itempricetext.setBorder(loweredbevel);
	  itempricetext.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				itempricetext.setBackground(Color.white);
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			  
		  });
	  itempricetext.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = itempricetext.getText();
	            int l = value.length();
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode()==KeyEvent.VK_BACK_SPACE || ke.getKeyChar()=='.') {
	               itempricetext.setEditable(true);
	            } else {
	            	JOptionPane.showMessageDialog(null, "please enter only numeric data");
	               String orginal=itempricetext.getText();
	               int len=orginal.length();
	               String org=orginal.substring(0,len-1);
	               itempricetext.setText(org);
	               
	            }
	         }
	      });
	  
	  itemcategory=new JLabel("Item Category:");
	  itemcategory.setBounds(105,245,130,25);
	  itemcategory.setFont(fox);
	  
	  String list[]= {"Select Any","Chicken","Mutton","Buff","Fish","Glocery"};
	  itemcategorytext=new JComboBox(list);
	  itemcategorytext.setBounds(240,245,240,30);
	  itemcategorytext.setFont(fob);
	  itemcategorytext.setBorder(loweredbevel);
	  
	  stocks=new JLabel("Stocks:");
	  stocks.setBounds(130,280,130,25);
	  stocks.setFont(fox);
	  stockstextbox=new JTextField();
	  stockstextbox.setBounds(240,285,240,30);
	  stockstextbox.setFont(fob);
	  stockstextbox.setBorder(loweredbevel);
	  stockstextbox.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = stockstextbox.getText();
	            int l = value.length();
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode()==KeyEvent.VK_BACK_SPACE || ke.getKeyChar()=='.') {
	               stockstextbox.setEditable(true);
	            } else {
	            	JOptionPane.showMessageDialog(null, "please enter only numeric data");
	               String orginal=stockstextbox.getText();
	               int len=orginal.length();
	               String org=orginal.substring(0,len-1);
	               stockstextbox.setText(org);
	               
	            }
	         }
	      });
	  stockstextbox.addFocusListener(new FocusListener() 
	  {

		@Override
		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			stockstextbox.setBackground(Color.white);
			
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		  
	  });
	 
	 
	
	  JButton stockin=new JButton("Stock In");
	  stockin.setBounds(35,340,80,30);
	  stockin.setBackground(Color.decode("#48C9B0"));
	  stockin.setForeground(Color.white);
	  stockin.addActionListener(new ActionListener()
	  {

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(itemcodetext.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter id of the product");
				itemcodetext.setBackground(Color.yellow);
			}
			else
			{
			try
			{
				Class.forName("org.sqlite.JDBC");
				Connection con=DriverManager.getConnection("jdbc:sqlite:meathub.db");
				PreparedStatement pst=con.prepareStatement("select * from item_information where item_code=?");
				pst.setInt(1, Integer.parseInt(itemcodetext.getText()));
				ResultSet ps=pst.executeQuery();
				while(ps.next())
				{
					
					itemcodetext.setText(String.valueOf(ps.getInt(1)));
					itemnametext.setText(String.valueOf(ps.getString(2)));
					itempricetext.setText(String.valueOf(ps.getDouble(3)));
					stockstextbox.setText(String.valueOf(ps.getDouble(5)));
					if(ps.getString(4).equals(itemcategorytext.getItemAt(1).toString()))
					{
						itemcategorytext.setSelectedItem(ps.getString(4));
					}
					else if(ps.getString(4).equals(itemcategorytext.getItemAt(2).toString()))
					{
						itemcategorytext.setSelectedItem(ps.getString(4));
					}
					else if(ps.getString(4).equals(itemcategorytext.getItemAt(3).toString()))
					{
						itemcategorytext.setSelectedItem(ps.getString(4));
					}
					else if(ps.getString(4).equals(itemcategorytext.getItemAt(4).toString()))
					{
						itemcategorytext.setSelectedItem(ps.getString(4));
					}
					else 
					{
						itemcategorytext.setSelectedIndex(0);
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
	  
	  stock=new JButton("Add");
	  stock.setBounds(127,340,80,30);
	  stock.setBackground(Color.decode("#48C9B0"));
	  stock.setForeground(Color.white);
	  stock.addActionListener(new ActionListener() 
	  {

		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			String itemcodevalue=itemcodetext.getText();
			String itemnamevalue=itemnametext.getText();
			String itempricevalue=itempricetext.getText();
			String stocks=stockstextbox.getText();
			String itemcategoryvalue=itemcategorytext.getSelectedItem().toString();
			
			if(itemcodevalue.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Item code field can't be empty");
				itemcodetext.setBackground(Color.yellow);
			}
			else if(itemcodevalue.length()>10)
			{
				JOptionPane.showMessageDialog(null, "Item code size can't be greater than 10");
				itemcodetext.setBackground(Color.yellow);
				
			}
			else if(itemnamevalue.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Item name field can't be empty");
				itemnametext.setBackground(Color.yellow);
				
			}
			else if(itemnamevalue.length()>30)
			{
				JOptionPane.showMessageDialog(null, "Item name size can't be greate than 30");
				itemnametext.setBackground(Color.yellow);
				
			}
			else if(itempricevalue.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Item price field can't be empty");
				itempricetext.setBackground(Color.yellow);
				
			}
			else if(itempricevalue.length()>10)
			{
				JOptionPane.showMessageDialog(null, "Item price size can't be more than 10");
				itempricetext.setBackground(Color.yellow);
				
			}
			else if(itemcategoryvalue.equals("Select Any"))
			{
				JOptionPane.showMessageDialog(null, "Item category field can't be empty");
			}
			else if(stocks.length()>10)
			{
				JOptionPane.showMessageDialog(null, "Stocks size can't be more than 10");
				itempricetext.setBackground(Color.yellow);
				
			}
			else if(stocks.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Stocks field can't be empty");
				stockstextbox.setBackground(Color.yellow);
			}
			else
			{
				try
				{
					Class.forName("org.sqlite.JDBC");
					Connection con=DriverManager.getConnection("jdbc:sqlite:meathub.db");
					PreparedStatement pst=con.prepareStatement("insert into item_information values(?,?,?,?,?)");
					pst.setInt(1, Integer.parseInt(itemcodevalue));
					pst.setString(2, itemnamevalue);
					pst.setDouble(3, Double.valueOf(itempricevalue));
					pst.setString(4, itemcategoryvalue);
					pst.setDouble(5, Double.parseDouble(stocks));
					int x=pst.executeUpdate();
					if(x>0)
					{
						JOptionPane.showMessageDialog(null, "Data are inserted to the database successfully");
						itemcodetext.setText("");
						itemnametext.setText("");
						itempricetext.setText("");
						itemcategorytext.setSelectedIndex(0);
						stockstextbox.setText("");
					}
					con.close();
				}
				catch(Exception eb)
				{
					eb.printStackTrace();
				}
			}
			
			
			
			
		}
		  
	  });
	  
	  JButton update=new JButton("Update");
	  update.setBounds(217,340,80,30);
	  update.setBackground(Color.decode("#48C9B0"));
	  update.setForeground(Color.white);
	  update.addActionListener(new ActionListener() 
	  {

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			String itemcodevalue=itemcodetext.getText();
			String itemnamevalue=itemnametext.getText();
			String itempricevalue=itempricetext.getText();
			String stocks=stockstextbox.getText();
			String itemcategoryvalue=itemcategorytext.getSelectedItem().toString();
			
			if(itemcodevalue.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Item code field can't be empty");
				itemcodetext.setBackground(Color.yellow);
			}
			else if(itemcodevalue.length()>10)
			{
				JOptionPane.showMessageDialog(null, "Item code size can't be greater than 10");
				itemcodetext.setBackground(Color.yellow);
				
			}
			else if(itemnamevalue.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Item name field can't be empty");
				itemnametext.setBackground(Color.yellow);
				
			}
			else if(itemnamevalue.length()>30)
			{
				JOptionPane.showMessageDialog(null, "Item name size can't be greate than 30");
				itemnametext.setBackground(Color.yellow);
				
			}
			else if(itempricevalue.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Item price field can't be empty");
				itempricetext.setBackground(Color.yellow);
				
			}
			else if(itempricevalue.length()>10)
			{
				JOptionPane.showMessageDialog(null, "Item price size can't be more than 10");
				itempricetext.setBackground(Color.yellow);
				
			}
			else if(itemcategoryvalue.equals("Select Any"))
			{
				JOptionPane.showMessageDialog(null, "Item category field can't be empty");
			}
			else if(stocks.length()>10)
			{
				JOptionPane.showMessageDialog(null, "Stocks size can't be more than 10");
				itempricetext.setBackground(Color.yellow);
				
			}
			else if(stocks.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Stocks field can't be empty");
				stockstextbox.setBackground(Color.yellow);
			}
			else
			{
			try
			{
				Class.forName("org.sqlite.JDBC");
				Connection con=DriverManager.getConnection("jdbc:sqlite:meathub.db");
				PreparedStatement pst=con.prepareStatement("update item_information set item_code=?,item_name=?,item_price=?,item_category=?,stocks=? where item_code=?");
				pst.setInt(1, Integer.parseInt(itemcodetext.getText()));
				pst.setString(2, itemnametext.getText());
				pst.setDouble(3, Double.parseDouble(itempricetext.getText()));
				pst.setString(4, itemcategorytext.getSelectedItem().toString());
				pst.setDouble(5, Double.parseDouble(stockstextbox.getText()));
				pst.setInt(6, Integer.parseInt(itemcodetext.getText()));
				
				int ps=pst.executeUpdate();
				if(ps>0)
				{
					JOptionPane.showMessageDialog(null, "Data Updated Successfully");
					itemcodetext.setText("");
					itemnametext.setText("");
					itempricetext.setText("");
					itemcategorytext.setSelectedIndex(0);
					stockstextbox.setText("");
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Sorry Problem Occured");
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
	  
	  
	  JButton delete=new JButton("Delete");
	  delete.setBounds(307,340,80,30);
	  delete.setBackground(Color.decode("#48C9B0"));
	  delete.setForeground(Color.white);
	  delete.addActionListener(new ActionListener() 
	  {

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			try
			{
				Class.forName("org.sqlite.JDBC");
				Connection con=DriverManager.getConnection("jdbc:sqlite:meathub.db");
				PreparedStatement pst=con.prepareStatement("delete from item_information where item_code=?");
				pst.setInt(1, Integer.parseInt(itemcodetext.getText()));
				int ps=pst.executeUpdate();
				if(ps>0)
				{
					JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
					itemcodetext.setText("");
					itemnametext.setText("");
					itempricetext.setText("");
					itemcategorytext.setSelectedIndex(0);
					stockstextbox.setText("");
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Sorry Problem Occured");
				}
				con.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		  
	  });
	  
	  JButton clear=new JButton("Clear");
	  clear.setBounds(397,340,80,30);
	  clear.setBackground(Color.decode("#48C9B0"));
	  clear.setForeground(Color.white);
	  clear.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e)
		{
			itemcodetext.setText("");
			itemnametext.setText("");
			itempricetext.setText("");
			itemcategorytext.setSelectedIndex(0);
			stockstextbox.setText("");
		}
		  
	  });
	  
	  cancel=new JButton("Cancel");
	  cancel.setBounds(487,340,80,30);
	  cancel.setBackground(Color.decode("#48C9B0"));
	  cancel.setForeground(Color.white);
	  cancel.addActionListener(new ActionListener()
	  {

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			System.exit(0);
			
		}
		  
	  });
	  
	  
	 
	  
	  main.add(additemainheader);
	  main.add(itemcode);
	  main.add(itemname);
	  main.add(itemprice);
	  main.add(itemcategory);
	  main.add(itemcodetext);
	  main.add(itemnametext);
	  main.add(stocks);
	  main.add(stockstextbox);
	  main.add(itempricetext);
	  main.add(itemcategorytext);
	  main.add(stock);
	  main.add(cancel);
	  main.add(update);
	  main.add(delete);
	  main.add(stockin);
	  main.add(clear);
	  
	  
	  
	  
	  
	  
	  
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
  }
  public static void main(String args[])
  {
	 AddItem hm=new AddItem();
  }
}
