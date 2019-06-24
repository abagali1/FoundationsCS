public class Democrat extends MazeEscaper{
   
   public void walkDownCurrentSegment(){
      while((!nextToABeeper()) && (frontIsClear()) && (!leftIsClear())){
         move();
      }
   }
   public void turnToTheNextSegment(){
      if(!nextToABeeper()){
         if(leftIsClear()){
            turnLeft();
         }
         else if(rightIsClear()){
            turnRight();
         }
         else{
            turnAround();
         }
      }
      move();
   }
}