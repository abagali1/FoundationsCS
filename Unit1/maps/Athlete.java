import edu.fcps.karel2.Robot; 
import edu.fcps.karel2.Display;
public class Athlete extends Robot implements Runnable{
   public Athlete () {
      super(1, 1, Display.NORTH, Display.INFINITY);
   } 
   
   public Athlete (int x, int y, int dir, int beepers){
      super(x, y, dir, beepers);
   } 
   public Athlete(int x, int y){
      super(x,y,Display.NORTH, Display.INFINITY);
   }
   public void setN(int N){
      athleteN = N;
   }
   public void run(){
      
      int found = 0;
      for( int a = 0; a<athleteN; a++){
         if(found != 0){
            found -= athleteN;
         }
         while((found != athleteN) || (!nextToABeeper())){
            if(!nextToABeeper()){
            
               move();
               found++;
            }
            if(nextToABeeper()){
               pickBeeper();
            }
            else{
               continue;
               
            }
         }
      }
   }
   
   public void turnAround(){
      turnLeft(); 
      turnLeft(); 
      
   } 
   public void turnRight(){
      turnLeft();
      turnLeft(); 
      turnLeft(); 
      
   }
   
   public void putAndMove(){
      putBeeper();
      move();
   }
   public void sprint(int n){
      for (int c =n; c!=0; c--){
         move();
      }
   }
   public void shift(){
   
   
      while(nextToABeeper()){
         pickBeeper();
      }
      turnAround();
      move();
      while(hasBeepers()){
         putBeeper();
         
         
         
            
         
      }
   }   
   public void followWallsRight(){
      while(!nextToABeeper()){
         if((!rightIsClear())&&(frontIsClear())){
            move();
         }
         else if(rightIsClear()){
            turnRight();
            move();
         }
         else{
            turnLeft();
         }
      }
   
   }
   private int athleteN;
   public int facingDirection(){
      if(facingNorth()){
         return 1;
      }else if(facingSouth()){
         return 3;
      }else if(facingEast()){
         return 0;
      }else if(facingWest()){
         return 2;
      }else{
         return 4;
      }
   }

      
}

