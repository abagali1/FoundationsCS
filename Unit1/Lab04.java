//Anup Bagali 9-5-17
import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Lab04{

   public static void takeTheField(Athlete arg){
      
      arg.move();
      arg.move();
      arg.move();
      arg.move();
      arg.turnRight();
      arg.move();
      arg.move();
   }
   public static void main(String [] args){
      Display.openWorld("Maps/arena.map");
      Display.setSpeed(10);
      Display.setSize(10,10);
      
      Athlete coach = new Athlete(2,7,Display.EAST, 0);
      Athlete a = new Athlete();
      Athlete b = new Athlete();
      Athlete c = new Athlete();
      Athlete d = new Athlete();
      Athlete e = new Athlete();
      Athlete f = new Athlete();
      takeTheField(a);
      takeTheField(b);
      takeTheField(c);
      takeTheField(d);
      takeTheField(e);
      takeTheField(f);
      a.move();
      a.move();
      a.move();
      a.turnLeft();
      a.move();
      a.move();
      a.turnAround();
      b.move();
      b.move();
      b.move();
      b.move();
      b.move();
      b.turnLeft();
      b.move();
      b.turnAround();
      c.move();
      c.move();
      c.move();
      c.move();
      c.turnRight();
      d.move();
      d.move();
      d.move();
      d.turnRight();
      e.move();
      e.move();
      e.turnRight();
      f.move();
      f.turnLeft();
      f.move();
      f.turnAround();
   }
}
