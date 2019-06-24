import java.awt.Color;
import javax.swing.JFrame;

public class Driver07
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame("Polygon Turtles");
    frame.setSize(400, 400);
    frame.setLocation(200, 100);
    frame.setDefaultCloseOperation(3);
    frame.setContentPane(new TurtlePanel());
    frame.setVisible(true);
    
    PolygonTurtle smidge = new PolygonTurtle(100.0D, 3);
    PolygonTurtle Octo1 = new PolygonTurtle(500.0D, 300.0D, 90.0D, 100.0D, 8);
    PolygonTurtle Octo = new PolygonTurtle(200.0D, 400.0D, 90.0D, 20.0D, 6);
    PolygonTurtle everything = new PolygonTurtle(550.0D, 450.0D, 90.0D, 50.0D, 8);
    
    smidge.setThickness(3);
    smidge.setColor(Color.BLUE);
    smidge.drawShape();
    smidge.setSides(5);
    smidge.setColor(Color.BLACK);
    smidge.drawShape();
    
    Octo1.setThickness(3);
    Octo1.setPenDown(true);
    Octo1.setColor(Color.RED.darker());
    for (int x = 50; x >= 20; x -= 10)
    {
      Octo1.setSize(x);
      Octo1.drawShape();
    }
    Octo.setThickness(10);
    Octo.drawShape();
    
    everything.setColor(Color.YELLOW);
    for (int y = 3; y <= 8; y++)
    {
      everything.setSides(y);
      everything.drawShape();
    }
  }
}
