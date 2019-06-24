/**
* AiBumper class which instantiates a automatically moving
* rectangle which can deflect objects which hit it
*
* @author Anup Bagali
* @version 2.0
* @since 2017-12-01
*/

import java.awt.*;

public class AiBumper extends Bumper{
/**
* Instantiates a default AiBumper
* inherits all characteristics of a default Bumper
*/
   public AiBumper(){
      super();
   }
/**
* Overloaded constructor for AiBumper
* @param x desired starting x-coordinate
* @param y desired starting y-coordinate
* @param w desired starting width
* @param h desired starting height
* @param c desired starting color
*/
   public AiBumper(int x, int y, int w, int h, Color c){
      super(x,y,w,h,c);
   }
/**
* Sets the pace which the AiBumepr will move at
* @param setting desired pace 
* @return the desired difficulty
*/
   public int difficulty(int setting){
      switch(setting){
         case 1:
            return 113;
         case 3:
            return 40;
         case 5:
            return 100;
      }
      return 40;
            
   }
/**
* Moves the AiBumper based on the location of a specified Ball
* @param b Ball in which the bumper should follow
* @param a Difficulty desired
*/
   public void play(Ball b,int a){
      if(difficulty(a) == 100){
         move();
      }else{
         setX((int)b.getX() - difficulty(a));
         if(getX() <= 0)
            setX(0);
      }
   }
}