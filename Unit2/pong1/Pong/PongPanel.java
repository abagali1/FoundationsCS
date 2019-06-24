/**
* PongPanel class which makes a new game of "Pong"
* @author Anup Bagali
* @version 2.0
* @since 2017-12-11
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class PongPanel extends JPanel {
   private static final int FRAME = 400;
   private static final Color BACKGROUND = Color.BLACK.darker();
   private BufferedImage myImage;
   private Graphics myBuffer;
   private Ball ball;
   private Bumper btop;
   private AiBumper bbot;
   private Thread aibot;
   private Timer t,s,i,c,d,w,h; 
   private int hits = 0;
   private int bhits = 0;
   private int start = 5;	
   private int move = 0;	
   private int difficulty; 
/**
* Instantiates a new Pong game 
*/
   public PongPanel()
   {
      myImage = new BufferedImage(FRAME, FRAME, 1);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME, FRAME);
    
      ball = new Ball(200,200, 25, Color.RED);
   
      
      btop = new Bumper(150,30,80,20,Color.WHITE.brighter());
      bbot = new AiBumper(150,360,80,20,Color.WHITE.brighter());
   //      aibot = new Thread(bbot);
      
      s = new Timer(1000, new Starter());
      i = new Timer(5, new Instruct());
      t = new Timer(5, new Listener());
      c = new Timer(5, new Transition());
     // w = new Timer(5, new TwoPlay());
      h = new Timer(10, new Hack());
      s.start();
   
      addKeyListener(new Key());
      addMouseListener(new Mouse());
      setFocusable(true);
   }
/**
* Draws a images onto a graphics object
* @param g desired graphics object
*/
   public void paintComponent(Graphics g)
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }


   private class Mouse extends MouseAdapter{
   /**
   * Checks if the mouse has been clicked and where it has been clicked
   * @param e MouseEvent
   */
      public void mouseClicked(MouseEvent e){
         if(i.isRunning()){
            if(e.getX() >= 30 && e.getY() >= 280 && e.getX() <= 150 && e.getY() <= 330){
               difficulty = 1;
               c.start();
            }
            else if(e.getX() >= 260 && e.getY() >= 280 && e.getX() <= 380 && e.getY() <= 330){
               difficulty = 3;
               c.start();
            }else if(e.getX() >= 70 && e.getY() >= 330 && e.getX() <= 340 && e.getY() <= 380){
               difficulty = 5;
               c.start();
            }
         
         }
      }
   }

   
   private class Key extends KeyAdapter{
   /**
   * Checks if a key has been pressed and which key has been pressed
   * e KeyEvent 
   */
   
      public void keyPressed(KeyEvent e)
      {
         if ((e.getKeyCode() == KeyEvent.VK_LEFT) && (bbot.getX() > 10)) {
            //bbot.setX(bbot.getX() - 4);
            bbot.setLAcc(true);
         } 
         else if ((e.getKeyCode()== KeyEvent.VK_RIGHT) && (bbot.getX() < 290)) {
            //bbot.setX(bbot.getX() + 4);
            bbot.setRAcc(true);
         } 
         if((e.getKeyCode() == KeyEvent.VK_A) && (btop.getX() > 10)) {
            //btop.setX(btop.getX() - 40);
            btop.setLAcc(true);
         } 
         else if((e.getKeyCode() == KeyEvent.VK_D) && (btop.getX() < 290)) {
            //btop.setX(btop.getX() + 40);
            btop.setRAcc(true);
         }
         if((e.getKeyCode() == KeyEvent.VK_SPACE)){
            ball.setDelta();
         
         }
         if(i.isRunning()){
            if((e.getKeyCode() == KeyEvent.VK_ENTER)){
               i.stop();
               t.start();
            }
         }
         if(s.isRunning()){
            if((e.getKeyCode() == KeyEvent.VK_ENTER)){
               s.stop();
               t.start();
            }
         }
         if((e.getKeyCode() == KeyEvent.VK_ESCAPE)){
            System.exit(0);
         }
         if(e.getKeyCode() == KeyEvent.VK_ALT){
            s.stop();
            i.stop();
            t.stop();
            c.stop();
            w.stop();
            h.start();
         } 
         if(e.getKeyCode() == KeyEvent.VK_M){
            s.stop();
            t.stop();
            c.stop();
            h.stop();
            i.start();
         }
      }
   /**
   * Checks if a key has been released and which key is released
   * @param e KeyEvent
   */
      public void keyReleased(KeyEvent e){
         if ((e.getKeyCode() == KeyEvent.VK_LEFT) && (bbot.getX() > 10)) {
            //bbot.setX(bbot.getX() - 4);
            bbot.setLAcc(false);
         } 
         else if ((e.getKeyCode()== KeyEvent.VK_RIGHT) && (bbot.getX() < 290)) {
            //bbot.setX(bbot.getX() + 4);
            bbot.setRAcc(false);
         } 
         if((e.getKeyCode() == KeyEvent.VK_A) && (btop.getX() > 10)) {
            //btop.setX(btop.getX() - 40);
            btop.setLAcc(false);
         } 
         else if((e.getKeyCode() == KeyEvent.VK_D) && (btop.getX() < 290)) {
            //btop.setX(btop.getX() + 40);
            btop.setRAcc(false);
         }
      }
   }
   private class Transition implements ActionListener{
   /**
   * Transitions from Instruction panel to Listener(Game) panel
   * @param e ActionEvent
   */
      public void actionPerformed(ActionEvent e){
         i.stop();
         c.stop();
         t.start();
      }
   }
   private class Starter implements ActionListener{
   /**
   * Starts countdown from 5 to 0 then transitions into Instruction panel
   * @param e ActionEvent
   */
      public void actionPerformed(ActionEvent e){
         if(start >=0){
            myBuffer.setColor(Color.BLACK);
            myBuffer.setColor(Color.BLACK);
            myBuffer.fillRect(0,0,FRAME,FRAME);
            myBuffer.setColor(new Color(0,255,51));
            myBuffer.setFont(new Font("Monospaced",1,50));
            myBuffer.drawString("P O N G", 85, 100);
            myBuffer.setFont(new Font("Monospaced", 1, 25));
            myBuffer.drawString("STARTS IN... ",100,120);
            myBuffer.setColor(Color.RED);
            myBuffer.setFont(new Font("Arial", 1, 240));
            myBuffer.drawString(""+start, 120, 300);
         
            start--;
         }
         else{
            s.stop();
            i.start();
         }
         repaint();
      }
   }
   private class Instruct implements ActionListener{
   /**
   * Displays the Instruction panel which displays the instructions to play Pong
   * @param e ActionEvent
   */
      public void actionPerformed(ActionEvent e){
         ImageIcon pic = new ImageIcon("pong.gif");
         myBuffer.drawImage(pic.getImage(),0,0,400,400, null);
         myBuffer.setColor(new Color(0,255,51));
         myBuffer.setFont(new Font("Monospaced",1,50));
         myBuffer.drawString("P O N G", 85, 100);
         myBuffer.setFont(new Font("Monospaced", 1, 15));
         myBuffer.drawString("Press A to move left, Press D to move right",10,120);
         myBuffer.drawString("Press <-- for left, --> for right(bottom)",10,140);
         myBuffer.drawString("Space to Reset", 120, 160);
         myBuffer.setColor(Color.RED);        
         myBuffer.setFont(new Font("Arial", 1, 50));       
         myBuffer.drawString("Select Difficulty: ", 20, 250);
         myBuffer.drawString("Easy", 30, 320);
         myBuffer.drawString("Hard", 260, 320);
         myBuffer.drawString("Two Player", 70, 370);
         
         repaint();
      }
   }
         
   private class Listener implements ActionListener
   {    
   /**
   * Plays the actual game of Pong
   * @param e ActionEvent
   */
      public void actionPerformed(ActionEvent e)
      {     
         myBuffer.setColor(BACKGROUND);
         myBuffer.fillRect(0, 0, FRAME, FRAME);
         
         myBuffer.setColor(new Color(0,255,51));
         for(int a = 0; a<= 400; a+= 25)
            myBuffer.drawLine(a,200,a+5,200);
         
         ball.move(FRAME,FRAME);
         BumperCollision.collide(btop, ball);
         BumperCollision.collide(bbot, ball);
         btop.move();
         bbot.play(ball,difficulty);
                  
         ball.draw(myBuffer);
         btop.draw(myBuffer);
         bbot.draw(myBuffer);
      
         if(ball.getY() < 30){
            ball.setX(200);
            ball.setY(200);
            ball.setdx(0);
            ball.setdy(0);
            bhits ++;
         }
         if(ball.getY()>360){
            ball.setX(200);
            ball.setY(200);
            ball.setdx(0);
            ball.setdy(0);
            hits ++;
         }
         myBuffer.setColor(new Color(0,255,51));
         myBuffer.setFont(new Font("Monospaced", 1, 24));
         myBuffer.drawString("Top: " + hits, 250, 25);
         myBuffer.drawString("Bottom: " + bhits, 250,45);
         repaint();
      }
   }
/**
* Sees if a Ball and Polkadot have collided
* @param b Ball object 
* @param p Polkadot object
*/
   public void collide(Ball b, Polkadot p)
   {
      double dist = distance(b.getX(), b.getY(), p.getX(), p.getY());
      if (dist < 37)
      {
         hits += 1;
      
         p.jump(FRAME, FRAME);
      }
   }
/**
* Calculates the distance between two points
* @param x1 x-coordinate of first point
* @param y1 y-coordinate of first point
* @param x2 x-coordinate of second point
* @param y2 y-coordinate of second point
* @return distance between the two points
*/
   private double distance(double x1, double y1, double x2, double y2)
   {
      return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
   }
/**
* Sees if it is ready to transition between instructions panel to game panel
* @param a decides if transition can execute
*/
   private void transition(boolean a){
      if(a){
         i.stop();
         t.start();
      }
   }
   private class Hack implements ActionListener{
      public void actionPerformed(ActionEvent e){
         ImageIcon pic = new ImageIcon("pic.gif");
         myBuffer.drawImage(pic.getImage(),0,0,400,400, null);
         repaint();
      }
   }
}
