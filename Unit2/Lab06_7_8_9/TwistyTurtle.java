import edu.fcps.Turtle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TwistyTurtle extends Turtle{

   
   public void drawShape(){
   
      for(int x =0; x<=400; x+=10){
         forward(x);
         turnLeft(123);
      
      }
   }

}