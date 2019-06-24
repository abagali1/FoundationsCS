   //Name:    Date:
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class PongPanel extends JPanel{
   private static final int FRAME = 400;
   private Color sbackground = Color.BLACK;
   private Color BACKGROUND = Color.BLACK;
   private BufferedImage myImage;
   private Graphics myBuffer;
   private Ball ball,sbaall;
   private Bumper btop;
   private AiBumper bbot;
   private Timer s,t; 
   private int hits,bhits = 0;
   private int start = 5;
   private int one,two,three;
   private Thread tbot;
    
		
   public PongPanel()
   {
      myImage = new BufferedImage(FRAME, FRAME, 1);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME, FRAME);
      double d = 200;
      ball = new Ball(200.0,200.0,25.0,Color.RED);
      sbaall = new Ball(200,200,25,Color.RED);
      btop = new Bumper(150,30,100,30,Color.WHITE.brighter());
      bbot = new AiBumper(150,360,100,30,Color.WHITE.brighter());
      tbot = new Thread(bbot);
        
      s = new Timer(1000, new Starter());
      t = new Timer(5, new Listener());   
      s.start();
      
      
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
         
        /* if ((e.getKeyCode() == KeyEvent.VK_LEFT) && (bbot.getX() > 10)) {
            bbot.setX(bbot.getX() - 40);
         }else if ((e.getKeyCode()== KeyEvent.VK_RIGHT) && (bbot.getX() < 290)) {
            bbot.setX(bbot.getX() + 40);
         }*/
         if ((e.getKeyCode() == KeyEvent.VK_A) && (btop.getX() > 10)) {
            btop.setX(btop.getX() - 40);
         }else if ((e.getKeyCode() == KeyEvent.VK_D) && (btop.getX() < 290)) {
            btop.setX(btop.getX() + 40);
         }else if((e.getKeyCode() == KeyEvent.VK_SPACE)){
            ball.setdx(Math.random() *10-3);
            ball.setdy(Math.random() *10-2);
         }
      }
   }   
   private class Starter implements ActionListener{
      private Starter(){}
      public void actionPerformed(ActionEvent e){
         if(start >= 0){  
            myBuffer.setColor(sbackground);
            myBuffer.fillRect(0,0,FRAME,FRAME);
            myBuffer.setColor(new Color(0,255,51));
            myBuffer.setFont(new Font("Monospaced", 1, 50));
            myBuffer.drawString("P O N G", 100,100);
            myBuffer.setFont(new Font("Monospaced" , 1, 25));
            myBuffer.drawString("STARTS IN... "+start,30,120);
            start--;
         }else{
            s.stop();
            t.start();
           
         }    
         repaint();      
         
        
      }
   }

   private class Listener
    implements ActionListener
   {
      private Listener() {}
    
      public void actionPerformed(ActionEvent e)
      {
         t.stop();
         myBuffer.setColor(BACKGROUND);
         myBuffer.fillRect(0, 0, 400,400);
            
         ball.move(FRAME,FRAME);
         tbot.run();
         BumperCollision.collide(btop, ball);
         BumperCollision.collide(bbot, ball);
         if(btop.inBumper(ball)){
            myBuffer.setColor(new Color(((int)Math.random()*255),((int)Math.random()*255),((int)Math.random()*255)));
            myBuffer.fillRect(0,0,200,200);
         }
         if(bbot.inBumper(ball)){
            myBuffer.setColor(new Color(((int)Math.random()*255),((int)Math.random()*255),((int)Math.random()*255)));
            myBuffer.fillRect(200,200,400,400);
         }
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
           
         t.start();
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
