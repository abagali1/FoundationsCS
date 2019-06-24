import edu.fcps.Turtle;
import java.awt.Color;
import javax.swing.JFrame;

public class Driver09
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
      
      Turtle.setCrawl(false);
      Turtle.clear(Color.GREEN);
      /*
      TwistyTurtle smidge = new TwistyTurtle();
      smidge.setColor(Color.RED);
      twisties(smidge);
      
      TwistyTurtle2 lisa = new TwistyTurtle2();
      lisa.setColor(Color.BLUE);
      twisties(lisa);
     
      TwistyTurtle3 pete = new TwistyTurtle3();
      pete.setColor(Color.YELLOW);
      twisties(pete); 
      
      
      
      */
        SquareTurtle a = new SquareTurtle();
        a.setColor(Color.MAGENTA.darker());
        twisties(a);
        
        
        PolygonTurtle b = new PolygonTurtle();
        b.setSize(50);
        b.setSides(8);
        b.setColor(Color.BLACK);
        twisties(b);
        
        FlowerTurtle c = new FlowerTurtle();
        c.setColor(Color.YELLOW);
        twisties(c);
        
        TwistyTurtle d = new TwistyTurtle();
        d.setColor(Color.BLUE);
        twisties(d);
        
        
          
     
     
   }
}
