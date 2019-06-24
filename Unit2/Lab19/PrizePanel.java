   //Name:    Date:
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class PrizePanel extends JPanel
{
   private static final int FRAME = 400;
   private static final Color BACKGROUND = new Color(204, 204, 204);
   private BufferedImage myImage;
   private Graphics myBuffer;
   private Ball ball;
   private Polkadot pd;
   private Timer t; 
   private int hits = 0;
   private Polkadot[] myPDarray;
		//constructor   
   public PrizePanel()
   {
      myImage = new BufferedImage(FRAME,FRAME, 1);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0,FRAME,FRAME);
      
      
      int x = (int)(Math.random() * FRAME);
      int y = (int)(Math.random() * FRAME);
      ball = new Ball(x, y, 50, Color.BLACK);
      ball.setdx(x);
      ball.setdy(y);

      pd = new Polkadot((Math.random()* (FRAME-25) + 25/2),(Math.random()*(FRAME-25) + 25/2), 25, Color.RED);
      
      myPDarray = new Polkadot[50];
      for(int k=0; k<myPDarray.length; k++)
      {
         x = (int)(Math.random() * FRAME);
         y = (int)(Math.random() * FRAME);
         myPDarray[k] = new Polkadot(x, y, 25, Color.RED);
      }  
   
      t = new Timer(10, new Listener());
      t.start();  
   }
   public void paintComponent(Graphics g)
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }
   private class Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         myBuffer.setColor(BACKGROUND);
         myBuffer.fillRect(0,0,FRAME,FRAME);
           
      
        
         ball.move(FRAME,FRAME);
         for(int a = 0; a<myPDarray.length;a++)
            collide(ball,myPDarray[a]);
           
         ball.draw(myBuffer);
         for(int b = 0; b<myPDarray.length; b++)
            myPDarray[b].draw(myBuffer);
                     
         myBuffer.setColor(Color.BLACK);
         myBuffer.setFont(new Font("Monospaced",Font.BOLD,24));
         myBuffer.drawString("Count: " + hits, FRAME-150,25);
        
         repaint();
      }
   }   
   private void collide(Ball b, Polkadot pd)
   {
      
      double d = distance(ball.getX(),ball.getY(),pd.getX(),pd.getY());  
      if( d <= (ball.getRadius()+pd.getRadius())){
         pd.jump(FRAME,FRAME);
         hits++;
      }
         
   	  
   }
   private double distance(double x1, double y1, double x2, double y2)
   {
      return Math.sqrt((Math.pow(x1-x2,2))+(Math.pow(y1-y2,2)));
         
         
   }
}