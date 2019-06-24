//M.L. Billington, version 6.25.2009,  mlbillington@fcps.edu
import edu.fcps.Turtle;
import java.awt.Color;
import javax.swing.*;
public class Square
{
   private static Turtle smidge;
   private static int level;

   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Fractal Square");
      frame.setSize(600,600);
      frame.setLocation(100, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new TurtlePanel());
      frame.setVisible(true);
      Turtle.clear(Color.white);
      smidge = 
             new Turtle(400.0, 200.0, 180.0)
             { 
                public void drawShape() 	
                {} 
             };
      level = Integer.parseInt(JOptionPane.showInputDialog("How many levels? (1-7)"));   
      smidge.setCrawl(true);       
      smidge.setSpeed(10);
      square(smidge, 200.0, 90.0, level);
   }
   
   public static void square(Turtle t, double size, double angle, int level)
   {
      t.setCrawl(false);
      if (level == 0)
      {
         return;
      }
      t.forward(size);
      square(t,size/2,angle,level-1);
      t.turnLeft(angle);
      t.forward(size);
      square(t,size/2,angle,level-1);
      t.turnLeft(angle);
      t.forward(size);
      square(t,size/2,angle,level-1);
      t.turnLeft(angle);
      t.forward(size);
      square(t,size/2,angle,level-1);
      t.turnLeft(angle);
     
   
      
         
   }
  
   public static void setColor(Turtle t, double size)
   {
      if(size < 10.0)
         t.setColor(Color.red);
      else if (size < 40.0)
         t.setColor(Color.green.darker());
      else
         t.setColor(new Color(160, 130, 100));
   }
}