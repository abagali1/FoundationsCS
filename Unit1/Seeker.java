import edu.fcps.karel2.*;
public class Seeker extends Athlete{
   
   public void fetchBeeper(){
     
     
      while(!rightIsClear()){
         move();
      }
      turnRight();
      move();
      turnRight();
      while(!nextToABeeper()){
         move();
      }
      pickBeeper();
      turnAround();
      while(!leftIsClear()){
         move();
      }
      turnLeft();
      move();
      turnLeft();
      while(frontIsClear()){
         move();
      }
      turnAround();
   }
}
               
