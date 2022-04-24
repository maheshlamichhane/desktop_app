package quality.book.publication.employee;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class CustomerSalesInfoPrintable  implements Printable, ImageObserver 
{
	private BufferedImage image=null;
	private String list,searchby,sortby;
	 String name;
     int num;
	
    public CustomerSalesInfoPrintable(String list,String searchby,String sortby)
    {
       this.list=list;
       this.searchby=searchby;
       this.sortby=sortby;
    	
    }

	

    

  

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
           
           ArrayList<CustomerSalesInfoModal> lis = null;
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
				PreparedStatement pstm=con.prepareStatement("select * from customer_transaction_table where "+searchby+" = ? order by " +sortby+" DESC");
				pstm.setString(1, list);
				ResultSet bs=pstm.executeQuery();
				
				lis=new ArrayList<CustomerSalesInfoModal>();
				while(bs.next())
				{
					CustomerSalesInfoModal modal=new CustomerSalesInfoModal();
					modal.setDate_time(bs.getDate(1));
					modal.setCustomer_name(bs.getString(2));
					modal.setPhone_number(bs.getInt(3));
					modal.setBill_no(bs.getString(4));
					modal.setParticulars(bs.getString(5));
					modal.setTansaction_type(bs.getString(6));
					modal.setAmount(bs.getDouble(7));
					lis.add(modal);
				}
				
				 
				
			}
			catch(Exception ez)
			{
				ez.printStackTrace();
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
               g2d.drawString("===================================================================", 12, y);
               g2d.drawString("Lamichhane Construction Customer Sales Detail", 70, 50);
               g2d.drawImage(image,12,20,this);
               y+=imageShift;
               g2d.drawString("=================================================================",12, y);y+=headerRectHeight;
               g2d.drawString("==================================================================================", 0, y);y+=yShift;
               g2d.drawString("Date       Particulars                   Credit   Cash    Deposit    Balance", 0, y);y+=yShift;
               g2d.drawString("===================================================================================", 0, y);y+=headerRectHeight;
               double balance=0.0;
               double creditx=0.0,depositx=0.0;
              
               for(CustomerSalesInfoModal m:lis)
               {
            	   g2d.drawString(m.getDate_time().toString(), 0,y);
            	   g2d.drawString(m.getParticulars(), 60, y);
            	   name=m.getCustomer_name();
            	   num=m.getPhone_number();
            	   
            	   if(m.getTansaction_type().equals("Deposit"))
            	   {
            		   g2d.drawString(String.valueOf(m.getAmount()), 310, y);
            		   balance+=m.getAmount();
            		   depositx+=m.getAmount();
            		   g2d.drawString(String.valueOf(balance), 370, y);
            	   }
            	   else if(m.getTansaction_type().equals("Credit"))
            	   {
            		   g2d.drawString(String.valueOf(m.getAmount()), 220, y);
            		   balance-=m.getAmount();
            		   creditx+=m.getAmount();
            		   g2d.drawString(String.valueOf(balance), 370, y);
            	   }
            	   else if(m.getTansaction_type().equals("Cash"))
            	   {
            		   g2d.drawString(String.valueOf(m.getAmount()), 260, y);
            		   g2d.drawString(String.valueOf(balance), 370, y);
            	   }
            	   y+=yShift;
               }
               
               g2d.drawString("==============================================================================", 0, y);y+=yShift;
               g2d.drawString("Total Credit:"+creditx, 20, y);
               g2d.drawString("Total Deposit"+depositx, 150, y);
               g2d.drawString("Total Balance:"+balance, 290, y);
               y+=yShift;
               g2d.drawString("===============================================================================", 10, y);y+=yShift;
               g2d.drawString(" Name:"+name, 10, y);
               g2d.drawString( "Contact:"+num,200,y);
               y+=yShift;
               g2d.drawString("==================================================================", 10, y);y+=yShift;
               g2d.drawString("     Free Home Delivery 9805214582            "+java.time.LocalDate.now().toString()+" ", 10, y);y+=yShift;
               g2d.drawString("==================================================================", 10, y);y+=yShift;
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
