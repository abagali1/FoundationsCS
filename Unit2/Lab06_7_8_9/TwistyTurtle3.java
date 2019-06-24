import edu.fcps.Turtle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TwistyTurtle3 extends Turtle{

   public void drawShape(){
   
    for (int x = 25; x <= 150; x += 5)
    {
      for (int y = 1; y <= 4; y++)
      {
        forward(x);
        turnLeft(90);
      }
      turnLeft(45);
    }
  }
}