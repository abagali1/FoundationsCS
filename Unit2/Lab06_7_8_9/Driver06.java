	//Name______________________________ Date_____________
import edu.fcps.Turtle;
import java.awt.Color;
import javax.swing.*;
public class Driver06
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Square Turtles");
      frame.setSize(400, 400);
      frame.setLocation(200, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new TurtlePanel());
      frame.setVisible(true);
         
      Turtle.setCrawl(true);     //a class method
      
    
      SquareTurtle smidge = new SquareTurtle();
      SquareTurtle lisa = new SquareTurtle(600.0, 200.0, 135.0);
      SquareTurtle mary = new SquareTurtle(100.0, 300.0, 45.0, 25.0);
      smidge.setColor(Color.BLUE);
      smidge.setThickness(6);
      lisa.setColor(Color.RED.darker());
      mary.setThickness(10);
      mary.setColor(Color.BLUE);
      smidge.drawShape();
      smidge.setSize(100);
      smidge.setColor(Color.BLACK);
      smidge.setThickness(3);
      smidge.drawShape();
      for(int x = 50; x >= 50/4; x-=11){
         lisa.setSize(x);
         lisa.drawShape();
      }
      mary.setThickness(10);
      mary.drawShape();
   }
}