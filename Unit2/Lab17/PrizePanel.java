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
		//constructor   
   public PrizePanel()
   {
      myImage = new BufferedImage(FRAME, FRAME, 1);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME, FRAME);
    
      ball = new Ball(0, 0, 50, Color.BLACK);
      ball.jump(FRAME, FRAME);
    
      pd = new Polkadot(0, 0, 25, Color.RED);
      pd.jump(FRAME, FRAME);
        
      t = new Timer(5, new Listener());
      t.start();
    
      addMouseListener(new Mouse());
    
      addKeyListener(new Key());
      setFocusable(true);
   }
  
   public void paintComponent(Graphics g)
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }
  
   private class Mouse extends MouseAdapter
   {
    
      public void mousePressed(MouseEvent e)
      {
         if (e.isMetaDown())
         {
            ball.setX(e.getX());
            ball.setY(e.getY());
         }
         else if (e.isShiftDown())
         {
            ball.setdx((int)(Math.random() * 11 - 6));
            ball.setdy((int)(Math.random() * 11 - 6));
         }
         else
         {
            pd.setX(e.getX());
            pd.setY(e.getY());
         }
      }
   }
  
   private class Key
    extends KeyAdapter
   {
      private Key() {}
    
      public void keyPressed(KeyEvent e)
      {
         if ((e.getKeyCode() == KeyEvent.VK_UP) && (pd.getY() > 10)) {
            pd.setY(pd.getY() - 10);
         } else if ((e.getKeyCode()== KeyEvent.VK_DOWN) && (pd.getY() < 390)) {
            pd.setY(pd.getY() + 10);
         } else if ((e.getKeyCode() == KeyEvent.VK_LEFT) && (pd.getX() > 10)) {
            pd.setX(pd.getX() - 10);
         } else if ((e.getKeyCode() == KeyEvent.VK_RIGHT) && (pd.getX() < 390)) {
            pd.setX(pd.getX() + 10);
         } else if ((e.getKeyCode() == KeyEvent.VK_A)){
            ball.setdx(ball.getdx() +1);
            ball.setdy(ball.getdy() +1);
         }else if((e.getKeyCode() == KeyEvent.VK_D)){
            ball.setdx(ball.getdx()-1);
            ball.setdy(ball.getdy() -1);
         }else if((e.getKeyCode() == KeyEvent.VK_W)){
            ball.setdx(ball.getdx()+1);
         }else if((e.getKeyCode() == KeyEvent.VK_S)){
            ball.setdx(ball.getdx()-1);
         }
      
      
      }
   }
  
   private class Listener
    implements ActionListener
   {
      private Listener() {}
    
      public void actionPerformed(ActionEvent e)
      {
         myBuffer.setColor(BACKGROUND);
         myBuffer.fillRect(0, 0, FRAME, FRAME);
      
         ball.move(FRAME, FRAME);
         collide(ball, pd);
      
         ball.draw(myBuffer);
         pd.draw(myBuffer);
      
         myBuffer.setColor(Color.black);
         myBuffer.setFont(new Font("Monospaced", 1, 24));
         myBuffer.drawString("Count: " + hits, 250, 25);
      
         repaint();
      }
   }
  
   public void collide(Ball b, Polkadot p)
   {
      double dist = distance(b.getX(), b.getY(), p.getX(), p.getY());
      if (dist < 37)
      {
         hits += 1;
      
         p.jump(FRAME, FRAME);
      }
   }
  
   private double distance(double x1, double y1, double x2, double y2)
   {
      return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
   }
}
