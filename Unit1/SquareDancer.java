import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
public class SquareDancer extends Dancer{

   public SquareDancer(){
      super(1,1,Display.EAST,0);
   }
   public SquareDancer(int x, int y, int dir, int beep){
      super(x,y,dir,beep);
   }
   public void danceStep(){
      int count = 1;
      while(count==1){
         move();
         move();
         move();
         move();
         turnLeft();
      }
      
   }
}