	//Name______________________________ Date_____________
import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
public class Shifter extends Robot implements Runnable, Workable
{
   private int myBeepers;
   public Shifter(int y)
   {
      super(1, y, Display.EAST, 0);
      
   }
   public void sprint(int n){
      for (int c =n; c!=0; c--){
         move();
      }
   }
   public void turnAround(){
      turnLeft();
      turnLeft();
   }
   public void workCorner(){
      
      while(nextToABeeper()){
         pickBeeper();
      }
   
   }
   
   
   public void moveOneBlock(){
      move();
   }
   public void turnToTheRight(){
      turnLeft();
      turnLeft();
      turnLeft();
   }
   public void turnToTheNorth(){
      while(!facingNorth()){
         turnLeft();
      }
   }
   public void run(){
      sprint(6);
      while(frontIsClear()){
         turnAround();
         move();
         if(!nextToABeeper()){
            move();
            if(!frontIsClear() && nextToABeeper()){
               continue;
            }
            else if(!frontIsClear() && !nextToABeeper()){
               break;
            }
               
         }
         while(nextToABeeper()){
            pickBeeper();
         }
         turnAround();
         move();
         while(hasBeepers()){
            putBeeper();
         }
      
      }
      if(nextToABeeper()){
         while(nextToABeeper()){
            pickBeeper();
         }
         turnAround();
         move();
         while(hasBeepers()){
            putBeeper();
         }
         turnAround();
         while(frontIsClear()){
            move();
         }
      }
   }
       
}

