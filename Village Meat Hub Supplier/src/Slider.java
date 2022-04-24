import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

class Slider extends JFrame
{
	JProgressBar jb;
	JLabel label;
	int i=0,num=0;

    public Slider()
    {
    	jb=new JProgressBar(0,2000);
    	jb.setBounds(150,280,450,30);
        jb.setValue(0);
        jb.setStringPainted(true);
        add(jb);
        
        Font f=new Font("Serif",Font.BOLD,15);
        
        label=new JLabel("System is loading your files please wait...");
        label.setBounds(235,320,300,20);
        label.setFont(f);
        add(label);
     

        setLayout(new BorderLayout());

        JLabel background=new JLabel(new ImageIcon("E://meat hub//slider_image.png"));

        add(background);

        background.setLayout(new FlowLayout());

      
        
        setSize(767,430);
        setVisible(true);
        setTitle("Village Meat Hub ");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       
    }
    
    public void iterate()
    {
    	while(i<=2000)
    	{
    		jb.setValue(i);
    		i=i+20;
    		try
    		{
    			Thread.sleep(150);
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    		if(i==2000)
    		{
    			LoginPage page=new LoginPage();
    			dispose();
    		}
    	}
    	
    }
    public static void main(String args[])
    {
    	new Slider().iterate();
    }

   
}