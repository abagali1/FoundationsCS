import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
import javax.swing.JOptionPane;

public class Lab09{
   public static void main(String [] args){
      String filename = JOptionPane.showInputDialog("What robot world?");
      Display.openWorld("maps/"+filename+".map");
      Display.setSize(10,10);
      Display.setSpeed(10);
      Athlete a = new Athlete(1,1,Display.EAST,0);
      a.sprint(7);
      a.pileRun();
   }
}

 