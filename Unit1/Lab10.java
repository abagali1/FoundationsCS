import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
import javax.swing.JOptionPane;

public class Lab10{
   public static void followWallsRight(Robot arg){
      while(!arg.nextToABeeper()){
         if((!arg.rightIsClear())&&(arg.frontIsClear())){
            arg.move();
         }
         else if(arg.rightIsClear()){
            arg.turnLeft();
            arg.turnLeft();
            arg.turnLeft();
            arg.move();
         }
         else{
            arg.turnLeft();
         }
      }
   }
   public static void followWallsLeft(Robot arg){
      while(!arg.nextToABeeper()){
         if((!arg.leftIsClear()&& (arg.frontIsClear()))) {
            arg.move();
         }
         else if(arg.leftIsClear()){
            arg.turnLeft();
            arg.move();
         }
         else{
            arg.turnLeft();
            arg.turnLeft();
            arg.turnLeft();
         }
      }
   }
   public static void main(String [] args){
      String filename = JOptionPane.showInputDialog("What robot world?");
      Display.openWorld("maps/"+filename+".map");
      Display.setSize(10,10);
      Display.setSpeed(10);
      
      Robot a = new Robot();
      if(Math.random() < 0.5){
      
         followWallsRight(a);
         
      }
      else {
         followWallsLeft(a);
      }
   }
}