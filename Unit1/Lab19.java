import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot; 
import javax.swing.JOptionPane;
public class Lab19{
   public static void main(String [] args){
      String filename = JOptionPane.showInputDialog("What robot world");
      Display.openWorld("maps/" + filename + ".map");
      Display.setSize(10,10);
      Display.setSpeed(10);
      
      Dorothy d = new Dorothy();
      while(d.nextToABeeper())
      {
         if(d.findPath())
         {
            d.followPath();
            continue;
         }
         d.turnLeft();
         if(d.findPath())
         { 
            d.followPath();
            continue;
         }
         d.turnAround();
       
      if(d.findPath()){
         d.followPath();
         continue;
      }else{
      break;
      }
      }
      
      
            
           
      
           System.out.println("We're not in Kansas anymore...");
   }
}