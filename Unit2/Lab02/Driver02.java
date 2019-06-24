import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class Driver02
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame("Our Fearless Leader");
    frame.setSize(400, 400);
    frame.setLocation(100, 50);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(new Panel02());
    frame.setVisible(true);
  }
}
class Panel02
  extends JPanel
{
   public void paintComponent(Graphics g)
   {
      g.setColor(Color.RED.darker());
      g.fillRect(0, 0, 700, 400);
   
      ImageIcon thomas = new ImageIcon("tj.jpg");
      g.drawImage(thomas.getImage(), 150, 75, 110, 150, null);       
    
      g.setColor(Color.YELLOW.darker());
      for (int x = 125; x <= 265; x += 20) {
         g.fillOval(x, 50, 20, 20);
      }
      for (int x = 125; x <= 265; x += 20) {
        g.fillOval(x, 230, 20, 20);
      }
      for (int y = 50; y <= 230; y += 20) {
         g.fillOval(125, y, 20, 20);
      }
      for (int y = 50; y <= 230; y += 20) {
         g.fillOval(265, y, 20, 20);
      }
   
   
      g.setFont(new Font("Serif", 3, 30));
      g.setColor(Color.WHITE);
      g.drawString("Our fearless leader", 70, 270);
   }
}
