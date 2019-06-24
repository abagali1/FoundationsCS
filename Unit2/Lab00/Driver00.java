import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;


public class Driver00
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("PAC-MAN");
      frame.setSize(500, 400);
      frame.setLocation(400,400);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new Panel00modify());
      frame.setVisible(true);
   }
  
}
class Panel00modify
  extends JPanel
{ 
   public void paintComponent(Graphics g)
   {
   
      g.setColor(Color.BLUE.darker());
      g.fillRect(0,0,500,400);
   
   
      g.setFont(new Font("Arial", Font.BOLD, 75));
      g.setColor(Color.RED);
      g.drawString("Pac-Man", 100, 100);
      g.drawLine(110,110,375,110);
      
   
      g.setColor(Color.YELLOW);
      g.fillOval(50, 130, 150, 150);
   
   
      int xPoints[] = {120, 178, 200};
      int yPoints[] = {200, 150, 230};
      g.setColor(Color.BLUE.darker());
      g.fillPolygon(xPoints, yPoints, 3);
      g.fillOval(167,150,40,76);
      
      g.setColor(new Color(148, 207,242));
      for(int x = (167+40); x<= 500; x += 10)
         g.fillOval(x, 186, 5,5);
         
      g.setColor(Color.RED);
      g.fillOval(10,10,50,60);
      g.fillRect(15,20,43,50);
      
      g.setColor(Color.BLUE.brighter());
      g.fillOval(390,10,50,60);
      g.fillRect(395,20,43,50);
     
      g.setColor(Color.WHITE);
      g.fillOval(10,270,50,60);
      g.fillRect(15,280,41,50);
     
      g.setColor(Color.MAGENTA.brighter());
      g.fillOval(390,270,50,60);
      g.fillRect(395,280,43,50);
   }
}
class Panel00
  extends JPanel
{
   public void paintComponent(Graphics g)
   {
      g.setColor(Color.BLUE);
      g.fillRect(75, 50, 300, 125);
    
      g.setFont(new Font("Serif", 1, 50));
      g.setColor(new Color(150, 150, 0));
      g.drawString("Hello World", 100, 150);
   }
}
