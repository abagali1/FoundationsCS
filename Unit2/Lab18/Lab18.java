import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Lab18
  extends JPanel
{
  public static void main(String[] args)
  {
    Turtle c = new Turtle();
    c.forward(200,200,400,400);
      
    
    JFrame a = new JFrame();
    a.setSize(400, 400);
    a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    a.setContentPane(new Lab18());
    a.setVisible(true);
  }
  
  public void paintComponent(Graphics g)
  {
    g.drawImage(Turtle.getImage(), 0, 0, getWidth(), getHeight(), null);
  }
}
