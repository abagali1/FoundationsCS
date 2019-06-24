import edu.fcps.karel2.Display;
import edu.fcps.Digit;
public class Lab11{
   public static void main(String [] args){
       
      Display.setSize(42, 37);
      Display.setSpeed(10);
       
      new One(1,9).display();
      new Seven(7,9).display();
      new Three(13,9).display();
      new Eight(21,9).display();
      new One(25,9).display();
      new One(29,9).display();
      new Four(37,9).display();
   
   }
}