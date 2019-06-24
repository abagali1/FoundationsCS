/**
* Ball class which instantiates a moveable
* ball which moves around a frame.
*
* @author Anup Bagali
* @version 2.0
* @since 2017-11-01
*/

import java.awt.*;

public class Ball extends Polkadot
{
   private double dx;       
   private double dy;
/**
* Instantiates a default Ball 
* Default balls have a random dX(change in x-coordinate) and dY(change in y-coordinate
* Default balls inherit all characteristics of a default polkadot
*/
   public Ball()         
   {
      super(200, 200, 50, Color.BLACK);
      dx = Math.random() * 12 - 6;          
      dy = Math.random() * 12 - 6;          
   }
/**
* Overloaded constructor for Ball
* @param x starting x-coordinate
* @param y starting y-coordinate
* @param dia diameter
* @param c starting color
*/
   public Ball(double x, double y, double dia, Color c)
   {
      super(x, y, dia, c);
      dx = Math.random()* 12 - 6;
      dy = Math.random() * 12 - 6;
   }
/**
* Modifier for dX(change in X)
* @param x desired dX
*/
   public void setdx(double x)        
   {
      dx = x;
   }
/**
* Modifier for dY(change in Y)
* @param y desired dY
*/
   public void setdy(double y)
   {
      dy = y;
   }
/**
* Sets dX and dY to a random number 
*/
   public void setDelta(){
      dx = Math.random() * 12 -6;
      dy = Math.random() * 12 -6;
   }
/**
* Sets dX and dY to zero
*/
   public void setNormDelta(){
      dx = 0;
      dy=0;
   }
/**
* Accessor for dX
* @return current dX
*/
   public double getdx()             
   {
      return dx;
   }
/**
* Accessor for dY
* @return current dY
*/
   public double getdy()
   {
      return dy;
   }
/**
* Moves the ball withina specified frame
* @param rightEdge right-most edge of the frame
* @param bottomEdge bottom-most edge of the frame
*/  
   public void move(double rightEdge, double bottomEdge)
   {
      setX(getX() + dx);
      setY(getY() + dy);
      if (getX() >= rightEdge - getRadius())
      {
         setX(rightEdge - getRadius());
         dx *= -1.0;
      }
      else if (getX() <= getRadius())
      {
         setX(getRadius());
         dx *= -1.0;
      }
      if (getY() >= bottomEdge - getRadius())
      {
         setY(bottomEdge - getRadius());
         dy *= -1.0;
      }
      else if (getY() <= getRadius())
      {
         setY(getRadius());
         dy *= -1.0;
      }
   }
/**
* Resets dX to 4 and dY to -1
* @param a decides whether dX and dY should be reset
*/
   public void reset(boolean a){
      if(a){
         dx = 4; dy = -1;
      }
   }
}
