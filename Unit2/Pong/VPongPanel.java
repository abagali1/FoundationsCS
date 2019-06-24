   //Name:    Date:
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class VPongPanel extends JPanel
{
   private static final int FRAME = 400;
   private static final Color BACKGROUND = Color.BLACK.darker();//new Color(0,255,51);
   private BufferedImage myImage;
   private Graphics myBuffer;
   private Ball ball;
   private Bumper btop;
   private Bumper bbot;
   private Timer t; 
   private int hits,bhits = 0;
    
		
   public VPongPanel()
   {
      myImage = new BufferedImage(FRAME, FRAME, 1);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME, FRAME);
    
      ball = new Ball(200,200, 25, Color.RED);
   
      
      btop = new Bumper(30,150,30,100,Color.WHITE.brighter());
      bbot = new Bumper(360,150,30,100,Color.WHITE.brighter());
        
      t = new Timer(5, new Listener());
      t.start();
    
      
      addKeyListener(new Key());
      setFocusable(true);
   }
  
   public void paintComponent(Graphics g)
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }
  
   private class Key extends KeyAdapter{
    
      public void keyPressed(KeyEvent e)
      {
         
         if ((e.getKeyCode() == KeyEvent.VK_UP) && (bbot.getY() > 10)) {
            bbot.setX(bbot.getY() - 40);
         } else if ((e.getKeyCode()== KeyEvent.VK_DOWN) && (bbot.getY() < 290)) {
            bbot.setX(bbot.getY() + 40);
         } else if ((e.getKeyCode() == KeyEvent.VK_W) && (btop.getY() > 10)) {
            btop.setX(btop.getY() - 40);
         } else if ((e.getKeyCode() == KeyEvent.VK_S) && (btop.getY() < 290)) {
            btop.setX(btop.getY() + 40);
         }else if((e.getKeyCode() == KeyEvent.VK_SPACE)){
            ball.setdx(Math.random() *10-3);
            ball.setdy(Math.random() *10-2);
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
         
         ball.move(FRAME,FRAME);
         BumperCollision.collide(btop, ball);
         BumperCollision.collide(bbot, ball);
      
         ball.draw(myBuffer);
         btop.draw(myBuffer);
         bbot.draw(myBuffer);
      
         if(ball.getY() < 30){
            ball.setdx(0);
            ball.setdy(0);
            ball.setX(200);
            ball.setY(200);
            bhits ++;
         }
         if(ball.getY()>360){
            ball.setdx(0);
            ball.setdy(0);
            ball.setX(200);
            ball.setY(200);
            hits ++;
         }
         myBuffer.setColor(new Color(0,255,51));
         myBuffer.setFont(new Font("Monospaced", 1, 24));
         myBuffer.drawString("Top: " + hits, 250, 25);
         myBuffer.drawString("Bottom: " + bhits, 250,45);
         for(int a = 0; a<= 400; a+= 25)
          myBuffer.drawLine(a,200,a+5,200);
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
