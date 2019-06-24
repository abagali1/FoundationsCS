import edu.fcps.Digit;
import edu.fcps.karel2.Robot;
import edu.fcps.karel2.Display;

public class Point extends Digit{
   public Point(int x, int y){
      super(x,y);
   }
   public void display(){
      segment1_Off();
      segment2_Off();
      segment3_Off();
      segment4_Off();
      segment5_On();
      segment6_Off();
      segment7_Off();
   
   }
   public void makePoint(){
      turnAround();
      while(!nextToABeeper()){
         move();
      }
      turnLeft();
      pickBeeper();
      move();
      pickBeeper();
   }
}
