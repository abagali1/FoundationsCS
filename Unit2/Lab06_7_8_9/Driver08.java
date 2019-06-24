import edu.fcps.Turtle;
import java.awt.Color;
import javax.swing.JFrame;

public class Driver08
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Flower Turtle");
      frame.setSize(400, 400);
      frame.setLocation(200, 100);
      frame.setDefaultCloseOperation(3);
      frame.setContentPane(new TurtlePanel());
      frame.setVisible(true);
      
      Turtle.setCrawl(false);
      Turtle.clear(Color.WHITE);
      FlowerTurtle smidge = new FlowerTurtle(60.0D, 50.0D, Color.PINK);
      FlowerTurtle lisa = new FlowerTurtle(175.0D, 50.0D, Color.BLACK);
      FlowerTurtle2 pete = new FlowerTurtle2();
      FlowerTurtle mary = new FlowerTurtle(425.0D, 50.0D, Color.BLUE);
      smidge.drawShape();
      lisa.drawShape();
      pete.drawShape();
      mary.drawShape();
   }
}
