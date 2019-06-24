import edu.fcps.Turtle;
import java.awt.Color;
import javax.swing.JFrame;

public class Driver09ext
{

   public static void twisties(Turtle arg)
   {
      arg.setPenDown(false);
      arg.turnRight((int)(Math.random() * 360));
      arg.forward((int)(Math.random() * 200));
      arg.setPenDown(true);
      arg.drawShape(); 
      
      
   }

   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Flower Turtle");
      frame.setSize(400, 400);
      frame.setLocation(200, 100);
      frame.setDefaultCloseOperation(3);
      frame.setContentPane(new TurtlePanel());
      frame.setVisible(true);
      
      Turtle.setCrawl(true);
      Turtle.clear(Color.GREEN);
      
      new Thread(new TwistyTurtle1(200.0, 250.0, 45.0)).start();
      new Thread(new TwistyTurtle1(250.0, 400.0, 45.0)).start();
      new Thread(new TwistyTurtle1(400.0, 250.0, 45.0)).start();
     
     
   }
}
