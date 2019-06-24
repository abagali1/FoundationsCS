import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
public class LineDancer extends Dancer{

   public LineDancer(){
      super(1,1,Display.EAST,0);
   }
   public LineDancer(int x, int y, int dir, int beep){
      super(x,y,dir,beep);
   }
   public void danceStep(){
      int count = 1;
      while(count==1){
         move();
         move();
         move();
         move();
         turnAround();
         
      }
   }
}