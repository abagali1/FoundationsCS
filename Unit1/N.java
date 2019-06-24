import edu.fcps.karel2.Display;
import edu.fcps.Digit;
public class N extends Digit{
   public N(int x, int y){
      super(x,y);
   }
   public void display(){
      segment1_On();
      segment2_On();
      segment3_On();
      segment4_Off();
      segment5_On();
      segment6_On();
      segment7_Off();
   }
}