import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Republican extends MazeEscaper{

   public void walkDownCurrentSegment(){
      while((!nextToABeeper()) && (frontIsClear()) && (!rightIsClear())){
         move();
      }
   }
   public void turnToTheNextSegment(){
      if(!nextToABeeper()){
         if(rightIsClear()){
            turnRight();
         }
         else if(leftIsClear()){
            turnLeft();
         }
         else{
            turnAround();
         }
      }
      move();
   }
}