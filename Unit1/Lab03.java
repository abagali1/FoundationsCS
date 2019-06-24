//Anup Bagali 9-5-17
import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Lab03{

   public static void main(String [] args){
   
      Display.openWorld("maps/mountain.map");
      Display.setSpeed(5);
      Display.setSize(16,16);
   
      Climber c = new Climber(8);
      Climber c1 = new Climber(8);
   
      c.putBeeper();
      c.turnRight();
      c1.turnRight();
      c.move();
      c1.move();
      c.climbUpRight();
      c1.climbUpRight();
      c.climbUpRight();
      c1.climbUpRight();
      c.climbUpRight();
      c1.climbUpRight();
      c.climbDownRight();
      c1.climbDownRight();
      c.climbDownRight();
      c1.climbDownRight();
      c.pickBeeper();
      c.turnAround();
      c1.turnAround();
      c.climbUpLeft();
      c1.climbUpLeft();
      c.climbUpLeft();
      c1.climbUpLeft();
      c.climbDownLeft();   
      c1.climbDownLeft();
      c.climbDownLeft();
      c1.climbDownLeft();  
      c.climbDownLeft();
      c1.climbDownLeft();
      c.move();
      c1.move();
      c.pickBeeper();
      c.move();
      c1.move();
      
      
   }
   
}