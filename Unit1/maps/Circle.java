import edu.fcps.karel2.Robot; 
import edu.fcps.karel2.Display;
public class Circle extends displayer{
   public Circle (){
      super();
   }
   public Circle (int x, int y){
      super(x,y);
   }
 /**
 * Draws a circle on the map
 */  
   public void tacMove(){
              
      putBeeper();
      turnRight();
      move();
      turnRight();
      move();
      putBeeper();
      move();
      turnRight();
      move();
      putBeeper();
      move();
      turnRight();
      move();
      putBeeper();
      turnRight();
      move();
      turnLeft();

              
   }
}