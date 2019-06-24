   //Name___Anup Bagali___________________________ Date__09/7/17___________
import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
import javax.swing.JOptionPane;
public class Lab06
{
   public static void main(String[] args) 
   {
      String filename = JOptionPane.showInputDialog("What robot world?");
      Display.openWorld("maps/" + filename + ".map");
      Display.setSize(10, 10);
      Display.setSpeed(10);
      
     
      task_01(); //go to the end of the row of beepers
      task_02(); //go to the beeper
      task_03(); //go to the wall
      task_04(); //go to the wall, pick up all the beepers (max one per pile)
      task_05(); //go to the wall, pick up all the beepers
      task_06(); //go to the end of the row of beepers, there is one gap
   }
   public static void task_01()	
   { //go to the end of the row of beepers
      Robot temp = new Robot(1, 1, Display.EAST, 0);
      while(temp.nextToABeeper()){
         temp.move();
      }
      
   }
   public static void task_02()	
   { //go to the beeper
      Robot temp = new Robot(1, 2, Display.EAST, 0);
      while(!temp.nextToABeeper()){
         temp.move();
      }
         
      	
   }
   public static void task_03()	
   { //go to the wall
      Robot temp = new Robot(1, 3, Display.EAST, 0);
      while(temp.frontIsClear()){
         temp.move();
      }
       
   }
   public static void task_04()	
   { //go to the wall, picking up the single beepers 
      Robot temp = new Robot(1, 4, Display.EAST, 0);
      int count = 0;
      if(temp.nextToABeeper()){
         temp.pickBeeper();
         count ++;
      }
   
      while(temp.frontIsClear()){
         if(temp.nextToABeeper()){
            temp.pickBeeper();
            count ++;
         }
         temp.move();
         if(temp.nextToABeeper()){
            temp.pickBeeper();
            count++;
         }
      }
      System.out.println("The count is "+ count);
   
   }
   public static void task_05()	
   { //go to the wall, picking up the piles of beepers
      Robot temp = new Robot(1, 5, Display.EAST, 0);
      int count = 0;
      while(temp.nextToABeeper()){
         temp.pickBeeper();
         count ++;
      }
      while(temp.frontIsClear()){
      
         temp.move();
         while(temp.nextToABeeper()){
            temp.pickBeeper();
            count++;
         }
      }
      System.out.println("The count is "+ count);
   }
   public static void task_06()
   { //go to the end of the row of beepers, there is one gap
      Robot temp = new Robot(1, 6, Display.EAST, 0);
      while(temp.nextToABeeper()){
         temp.move();
      }
      temp.move();
      while(temp.nextToABeeper()){
         temp.move();
      }
      
   
  /* public static void task_07(){
      int count = 0;   
      Robot temp = new Robot(1 ,2  , Display.EAST,0);
      while(temp.frontIsClear()){
         if(temp.nextToABeeper()){
            break;
         }
         temp.move(); 
         count ++;
      }
      System.out.println("The count is "+ count);
    
   }
   public static void task_08(){
      Robot karel = new Robot(1, 2, Display.EAST, 59);
      while(!karel.nextToARobot()){
         karel.move();
      }
      if(karel.nextToARobot()){
         while(karel.hasBeepers()){
            karel.putBeeper();
         }
      }
   }
   public static void task_09(){
      Racer karel= new Racer(1);
      for(int k =0; k<=4; k++){
         karel.put(4);
         karel.move();
      }
   }
   public static void task_10(){
      Racer karel= new Racer(2);
      while(karel.frontIsClear() ){
         karel.putBeeper();
         karel.move();
      }
      karel.putBeeper();
   }
   public static void task_11(){
      Racer karel= new Racer(2);
      while(!karel.rightIsClear()){
         karel.move();
      }
   
   }
   public static void task_12(){
      Racer karel= new Racer(2);
      while(!karel.rightIsClear()){
         if(!karel.nextToABeeper()){
            karel.move();
         }
      }*/
   }
}
      
