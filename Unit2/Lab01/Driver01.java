import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Driver01
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame("Build a House");
    frame.setSize(400, 425);
    frame.setLocation(100, 50);
    frame.setDefaultCloseOperation(3);
    frame.setContentPane(new Panel01());
    frame.setVisible(true);
  }
}
class Panel01
  extends JPanel
{
  public void paintComponent(Graphics g)
  {
    g.setColor(Color.BLUE.brighter());
    g.fillRect(0, 0, 400, 400);
    
    g.setColor(Color.GREEN.darker());
    g.fillRect(0,350, 400, 350);
    
    g.setColor(new Color(154,12,12));
    g.fillRect(100, 200, 150, 150);
    g.setColor(Color.BLACK);
    g.fillRect(150, 275, 50, 75);
    
    
    g.setColor(new Color(212,212,155));
    for(int y = 100; y<=250; y+=25)
      g.drawLine(y,200, y, 350);

    
    int[] xPoints = { 75, 175, 275 };
    int[] yPoints = { 200, 150, 200 };
    g.setColor(Color.BLACK);
    g.fillPolygon(xPoints, yPoints, 3);
    
    g.setColor(Color.MAGENTA);
    for(int x=0; x <= 400; x += 10){
      g.drawLine(x, 350,x, 300);
    }
    
    g.setColor(Color.WHITE);
    for(int a = 0; a <= 400; a+= 100)
     g.fillOval(a, 100, 70 ,50);

    
    g.setColor(Color.YELLOW);
    g.fillOval(300, 75, 50, 50);
    
    g.setFont(new Font("Serif", 3, 30));
    g.setColor(Color.WHITE);
    g.drawString("Welcome Home", 50, 50);
    g.drawLine(60,60,250,60);
  }
}

