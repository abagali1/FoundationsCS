import edu.fcps.Turtle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TwistyTurtle2 extends Turtle{

   public void drawShape(){
   
      for(int x =0; x<=150; x+=2){
         forward(x);
         turnLeft(30);
      
      }
   }

}