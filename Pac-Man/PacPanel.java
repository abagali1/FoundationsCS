  //Name:    Date:
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class PacPanel extends JPanel
{
   private static final int FRAME = 400;
   private static final Color BACKGROUND = Color.black.darker();
   private BufferedImage myImage;
   private Graphics myBuffer;
   private Polkadot man;
   private Timer s,t; 
   private int start = 5;
		//constructor   
   public PacPanel()
   {
      myImage = new BufferedImage(FRAME, FRAME, 1);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME, FRAME);
    
      man = new Polkadot();
        
      s = new Timer(1000, new Starter());
      s.start();
    
    
      addKeyListener(new Key());
      setFocusable(true);
   }
   private class Key extends KeyAdapter{
   /**
   * Checks if a key has been pressed and which key has been pressed
   * e KeyEvent 
   */
   
      public void keyPressed(KeyEvent e)
      {
         if ((e.getKeyCode() == KeyEvent.VK_LEFT)) {
            man.setLAcc(true);
         } 
         else if ((e.getKeyCode()== KeyEvent.VK_RIGHT)) {
            man.setRAcc(true);
         } 
         if((e.getKeyCode() == KeyEvent.VK_DOWN)) {
            man.setDAcc(true);
         } 
         else if((e.getKeyCode() == KeyEvent.VK_UP)) {
            man.setUAcc(true);
         }
      }
      
   /**
   * Checks if a key has been released and which key is released
   * @param e KeyEvent
   */
      public void keyReleased(KeyEvent e){
         {
            if ((e.getKeyCode() == KeyEvent.VK_LEFT)) {
               man.setLAcc(false);
            } 
            else if ((e.getKeyCode()== KeyEvent.VK_RIGHT)) {
               man.setRAcc(false);
            } 
            if((e.getKeyCode() == KeyEvent.VK_DOWN)) {
               man.setDAcc(false);
            } 
            else if((e.getKeyCode() == KeyEvent.VK_UP)) {
               man.setUAcc(false);
            }
         }
      }
   }
   private class Starter implements ActionListener{
      public void actionPerformed(ActionEvent e){
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

         repaint();
      }
   }
   
   
   
   
   
   
   
   
      
}