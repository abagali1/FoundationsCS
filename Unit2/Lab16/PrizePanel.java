   //Name:    Date:
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class PrizePanel extends JPanel
{
   private static final int FRAME = 400;
   private static final Color BACKGROUND = new Color(204, 204, 204);
   private int xpos,ypos, ballx, bally;
   private BufferedImage myImage;
   private Graphics myBuffer;
   private Ball ball;
   private Polkadot pd;
   private Polkadot[] pdarr;
   private Ball[] ballarr;
   private Timer t; 
   private int hits = 0;
   private int count;
		//constructor   
   public PrizePanel()
   {
      myImage = new BufferedImage(FRAME,FRAME, 1);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0,FRAME,FRAME);
      
      
      ballarr = new Ball[1];
      for(int x = 0; x <= ballarr.length-1; x++)
         ballarr[x] = new Ball(200,200,20,Color.MAGENTA);
      
      count = ballarr.length;
     
   
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
           
         for(int y = 0; y <= ballarr.length-1; y++){
            ballarr[y].move(FRAME,FRAME);
            ballarr[y].draw(myBuffer);
         }
         //collide(ball,pd);
           
      //   ball.draw(myBuffer);
         //pd.draw(myBuffer);
         
         myBuffer.setColor(Color.BLACK);
         myBuffer.setFont(new Font("Monospaced",Font.BOLD,24));
         myBuffer.drawString("Count: " + count, FRAME-150,25);
        
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

