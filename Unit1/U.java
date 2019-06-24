import edu.fcps.karel2.Display;
import edu.fcps.Digit;
public class U extends Digit{
   public U(int x, int y){
      super(x,y);
   }
   public void display(){
      segment1_Off();
      segment2_On();
      segment3_On();
      segment4_On();
      segment5_On();
      segment6_On();
      segment7_Off();
   }
}