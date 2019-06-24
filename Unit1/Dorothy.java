public class Dorothy extends Athlete{
   public Dorothy(){
      super(2,2,0,1);
   }
   public boolean findPath(){
      if(frontIsClear()){
         move();
         if (nextToABeeper()){
            turnAround();
            move();
            turnAround();
            return true;
         }
         else{
            turnAround();
            move();
            turnAround();
            return false;
         }
      }
      else{
         return false;
      }
   }
      
      
      
     /* 
      if(frontIsClear()){
         move();
         if(nextToABeeper()){
            return true;
         }
         turnAround();
         move();
         turnLeft();
         move();
         if(nextToABeeper()){
            return true;
         }
         turnAround();
         move();
         move();
         return nextToABeeper();
      }
      else{ 
         return false;
      }
      
   }*/
   public void followPath(){
      move();
   }
}
      
   
   
   
   
   
   
   
   
   
     /* if(!frontIsClear()){
         turnLeft();
      }
      while(nextToABeeper() && frontIsClear()){
         if(!frontIsClear()){
            turnLeft();
         }
         move();
         if(!frontIsClear()){
            turnLeft();
         }
      }
      turnAround();
      move();
      turnAround();
      if(!frontIsClear()){
         turnLeft();
      }
   }
}*/
