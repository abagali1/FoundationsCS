 //Torbert, e-mail: smtorbert@fcps.edu	
 //version 6.17.2003
 //version 11.4.2009  mlbillington@fcps.edu
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class Driver05
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Bugs");
      frame.setSize(400, 400);
      frame.setLocation(100, 50);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new BugPanel());
      frame.setVisible(true);
   }
}
class BugPanel extends JPanel
{
   private BufferedImage myImage;
   final int N = 400;
   public BugPanel()
   {
      myImage = new BufferedImage(N, N, BufferedImage.TYPE_INT_RGB);
      Graphics buffer = myImage.getGraphics();
      buffer.setColor(Color.BLUE);
      buffer.fillRect(0, 0, N, N);
      buffer.setColor(Color.YELLOW);
      Bug ltop = new Bug(0,0);
      Bug lbot = new Bug(0,400);
      Bug rtop = new Bug(400,0);
      Bug rbot = new Bug(400,400);
      while(!ltop.sameSpot(rtop)){
         ltop.walkTowards(rtop,0.1);
         rtop.walkTowards(rbot,0.1);
         rbot.walkTowards(lbot,0.1);
         lbot.walkTowards(ltop,0.1);
         
         buffer.drawLine(ltop.getX(),ltop.getY(),rtop.getX(),rtop.getY());
         buffer.drawLine(rtop.getX(),rtop.getY(),rbot.getX(),rbot.getY());
         buffer.drawLine(rbot.getX(),rbot.getY(),lbot.getX(),lbot.getY());
         buffer.drawLine(lbot.getX(),lbot.getY(),ltop.getX(),ltop.getY());
      }
   }
   public void paintComponent(Graphics g)
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }
}