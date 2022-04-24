package employee;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class BillPrintable  implements Printable, ImageObserver 
{
	double discount;
	private BufferedImage image=null;
	private String number,name,transtype,billno;
    public BillPrintable(String number,String name,String transtype,String billno)
    {
    	this.number=number;
    	this.name=name;
    	this.transtype=transtype;
    	this.billno=billno;
    	
    }

	ArrayList<Model> list=null;

    

  

    public int print(Graphics graphics,PageFormat pageFormat,int pageIndex) throws PrinterException
       {
    	
       int result=NO_SUCH_PAGE;
       if(pageIndex==0)
       {
           Graphics2D g2d=(Graphics2D)graphics;
           double width=pageFormat.getImageableWidth();
           g2d.translate((int)pageFormat.getImageableX(),(int)pageFormat.getImageableY());
           
           FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));
           int idLength=metrics.stringWidth("000");
           int amtLength=metrics.stringWidth("000000");
           int qtyLength=metrics.stringWidth("0000");
           int priceLength=metrics.stringWidth("0000000");
           int prodLength=(int)width-idLength-qtyLength-priceLength;
           int productPosition=0;
           int discountPosition=prodLength+5;
           int pricePosition=discountPosition+idLength+10;
           int qtyPosition=pricePosition+priceLength+4;
           int amtPosition=qtyPosition+qtyLength;
           
           try
           {
        	   Class.forName("oracle.jdbc.driver.OracleDriver");
        	   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
        	   PreparedStatement pst=con.prepareStatement("select item_name,price,quantity,discount_amount,discount_percent,total from sales_information_duplicate");
        	   ResultSet rs=pst.executeQuery();
        	   discount = 0;
        	   list=new ArrayList<Model>();
        	   while(rs.next())
        	   {
        		   Model m=new Model();
        		   m.setItem_name(rs.getString(1));
        		   m.setPrice(rs.getDouble(2));
        		   m.setQuantity(rs.getInt(3));
        		   m.setDiscount_amount(rs.getDouble(4));
        		   m.setDiscount_percentage(rs.getDouble(5));
        		   discount+=m.getDiscount_amount();
        		   m.setTotal(rs.getDouble(6));
        		   list.add(m);
        	   }
           }
           catch(Exception e)
           {
        	   e.printStackTrace();
           }
           
           try
           {
               int y=20;
               int yShift=10;
               int imageShift=45;
               int headerRectHeight=15;
               int headerRectHeighta=40;
             
                     
               
               
               
               
               image = ImageIO.read( new File("C://Users//Mahesh Lamichhane//Desktop//desktop app//Pos and Inventory System//image//logo.png" ));
               g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
               g2d.drawString("=============================================================================================", 12, y);
               g2d.drawString("Meat Hub Suppliers"+"           Bill No:"+billno, 70, 50);
               g2d.drawImage(image,12,20,this);
               y+=imageShift;
               g2d.drawString("==============================================================================================",12, y);y+=headerRectHeight;
               g2d.drawString("    ==========================================================================================", 10, y);y+=yShift;
               g2d.drawString("    Item Name     Price     Quantity       Discount(%)      Discount(Amount)      Total", 10, y);y+=yShift;
               g2d.drawString("    ===========================================================================================", 10, y);y+=headerRectHeight;
               double total=0;
               for(Model m:list)
               {
            	   g2d.drawString(m.getItem_name(),40,y);
            	   g2d.drawString(String.valueOf(m.getPrice()),112,y);
            	   g2d.drawString(String.valueOf(m.getQuantity()),180, y);
            	   g2d.drawString(String.valueOf(m.getDiscount_percentage()), 265, y);
            	   g2d.drawString(String.valueOf(m.getDiscount_amount()), 373, y);
            	   g2d.drawString(String.valueOf(m.getTotal()), 460, y);
            	   y+=headerRectHeight;
            	   
              // g2d.drawString("   "+m.getItem_name()+"         "+m.getPrice()+"        "+m.getQuantity()+"            "+m.getTotal()+ " ", 10, y);y+=yShift;
               total+=m.getTotal();
               }
               g2d.drawString("=================================================================================================", 10, y);y+=yShift;
               g2d.drawString("Amount:"+total+" ", 430, y);
               g2d.drawString("Discount:="+discount+" ",320,y);
               y+=yShift;
               g2d.drawString("=================================================================================================", 10, y);y+=yShift;
               g2d.drawString(" Name:"+name+"   Contact:"+number+"   Transaction Type:"+transtype, 10, y);y+=yShift;
               g2d.drawString("=================================================================================================", 10, y);y+=yShift;
               g2d.drawString("     Free Home Delivery 9805214582            "+java.time.LocalDate.now().toString()+" ", 10, y);y+=yShift;
               g2d.drawString("==================================================================================================", 10, y);y+=yShift;
               g2d.drawString("               Thanks To Visit Our COmpanyy                      ", 10, y);y+=yShift;
               
               g2d.drawString("            *********************************", 10, y);y+=yShift;
       
               
               
                       
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }
           result=PAGE_EXISTS;
           
       }
       return result;
    }




	@Override
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		return false;
	}
    
}
