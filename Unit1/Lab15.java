import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
public class Lab15{
   public static void main(String [] args){
      Display.setSize(15,15);
      Display.setSpeed(10);
      Dancer a = new SquareDancer(5,6,1,1);
      Dancer b = new BackAndForthDancer(3,4,1,1);
      Dancer c = new LineDancer(7,8,1,1);
      Dancer d = new LineDancer(8,8,1,1);
      Thread one = new Thread(a);
      Thread two = new Thread(b);
      Thread three = new Thread(c);
      Thread four = new Thread(d);
      one.start();
      two.start();
      three.start();
      four.start();
   }
}