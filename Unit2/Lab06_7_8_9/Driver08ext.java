import edu.fcps.Turtle;
import java.awt.Color;
import javax.swing.JFrame;

public class Driver08ext
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame("A Garden of Flowers");
    frame.setSize(400, 400);
    frame.setLocation(200, 100);
    frame.setDefaultCloseOperation(3);
    frame.setContentPane(new TurtlePanel());
    frame.setVisible(true);
    
    Turtle.setCrawl(false);
    Turtle.clear(Color.WHITE);
    for (int x = 1; x < 50; x++)
    {
      double place = Math.random() * 600;
      double size = Math.random() * 100;
      Color color = new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
      FlowerTurtle everything = new FlowerTurtle(place, size, color);
      everything.drawShape();
    }
  }
}
