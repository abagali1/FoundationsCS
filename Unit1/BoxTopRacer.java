//Anup Bagali 9/14/17
import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
public class BoxTopRacer extends Racer{
   public BoxTopRacer(int x){
      super(x);
   }
   public void jumpRight(){
      turnLeft();
      while(!rightIsClear()){
         move();
      }
   
      turnRight();
      move();
      while(!rightIsClear()){
         move();
      }
   
      turnRight();
         
      while(frontIsClear()){
         move();
      }
      turnLeft();
   }
}
