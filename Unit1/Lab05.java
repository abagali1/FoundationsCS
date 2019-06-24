//Anup Bagali 9/5/17
import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Lab05{
   public static void runTheRace(Racer arg){

      arg.shuttle(2,7);
      arg.shuttle(4,5);
      arg.shuttle(6,3);
      arg.move();

      }
      
   
   
   public static void main(String[] args){
   
      Display.openWorld("maps/shuttle.map");
      Display.setSpeed(10);
      Display.setSize(10,10);
      
      Racer bot = new Racer(1);
      Racer mid = new Racer(4);
      Racer top = new Racer(7);
      Thread t1 = new Thread(bot);
      Thread t2 = new Thread(mid);
      Thread t3 = new Thread(top);
      t1.start();
      t2.start();
      t3.start();
   }
}