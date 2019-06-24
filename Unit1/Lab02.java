//Anup Bagali 8-31-17
import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Lab02{

   public static void main(String [] args){
   
      Display.openWorld("maps/maze.map");
      Display.setSpeed(10);
      Display.setSize(8,8);
      Athlete a= new Athlete();
   
      a.putAndMove();
      a.turnRight();
      a.putAndMove();
      a.turnRight();
      a.putAndMove();
      a.turnLeft();
      a.putAndMove();
      a.turnLeft();
      a.putAndMove();
      a.turnRight();
      a.putAndMove();
      a.putAndMove();
      a.turnRight();
      a.putAndMove();
      a.turnLeft();
      a.putAndMove();
      a.turnLeft();
      a.putAndMove();
      a.putAndMove();
      a.putAndMove();
      a.putAndMove();
      a.turnRight();
      a.putAndMove();
      a.putAndMove();
            

   }
}