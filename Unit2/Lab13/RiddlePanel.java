   //Torbert, e-mail: mr@torbert.com, website: www.mr.torbert.com
	//version 6.17.2003

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class RiddlePanel extends JPanel
{
   private static final ImageIcon THOMAS = new ImageIcon("tj.jpg");
   private static final ImageIcon LAUGH = new ImageIcon("laugh.jpg");
   private BufferedImage myImage;
   private Graphics2D myBuffer;
   private Timer t1, t2;
   private int xPos;
   public RiddlePanel()
   {
      xPos = 50;
      myImage =  new BufferedImage(700, 500, BufferedImage.TYPE_INT_RGB);
      myBuffer = (Graphics2D)myImage.getGraphics();
      t1 = new Timer(100, new Listener1());
      t1.start();
      t2 = new Timer(8000, new Listener2());
   }
   public void paintComponent(Graphics g)
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }
   private class Listener1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         int xPoints[] = {xPos, xPos, xPos + 50, xPos, xPos - 50, xPos, xPos, xPos - 50, xPos, xPos + 50};
         int yPoints[] = {150, 225, 175, 225, 175,225, 325, 375, 325, 375};
        
         myBuffer.setColor(Color.PINK.darker());
         myBuffer.fillRect(0,0,700,500);
         myBuffer.setColor(Color.PINK);
         myBuffer.fillRect(0, 0, 700, 360);
         myBuffer.drawImage(THOMAS.getImage(), xPos-30, 50, 75, 125, null);
         myBuffer.setColor(Color.BLUE);
         myBuffer.setStroke(new BasicStroke(10));
         myBuffer.drawPolyline(xPoints,yPoints,10);
      
         if(xPos == 200)
         {
            
            myBuffer.setColor(Color.PINK);
            myBuffer.fillOval(285,93,35,15);
            
            
            int[] xtriangle = {225,285,330};
            int[] ytriangle = {100,93,103};
            myBuffer.setStroke(new BasicStroke(1));
            myBuffer.setColor(Color.BLACK);
            myBuffer.drawOval(285, 63, 390, 50);
            myBuffer.drawPolygon(xtriangle,ytriangle,3);
            myBuffer.setFont(new Font("Monospaced",0,14));
            myBuffer.drawString("What is a programmers favorite coffee?", 330, 90);
            t1.stop();
            t2.start();
         }
         else
         {
            xPos = xPos + 5;
         }
      
         repaint();
      }
   }
   private class Listener2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         t2.stop();
         myBuffer.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 24));
         myBuffer.drawString("Answer: A cup of JAVA",300,240);
         for(int x = 0; x <= 2; x++)
            myBuffer.drawImage(LAUGH.getImage(), ((int)(Math.random()*(400))),360, 75, 125, null);
      
         repaint();
      }
   }
}