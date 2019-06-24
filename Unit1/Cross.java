import edu.fcps.karel2.Robot; 
import edu.fcps.karel2.Display;
public class Cross extends displayer{
   public Cross (){
      super();
   }
   public Cross (int x, int y){
      super(x,y);
   }
 /**
 * Draws a cross on the map
 */  
   public void tacMove(){
      turnLeft();
      move();
      putBeeper();
      turnLeft();
      move();
      move();
      putBeeper();
      turnLeft();
      move();
      move();
      putBeeper();
      turnLeft();
      move();
      move();
      putBeeper();
      turnLeft();
      move();
      turnLeft();
      move();
      putBeeper();
      move();
      turnAround();
   }
}