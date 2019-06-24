/**
* Polkadot class which instantiates a moveable
* polkadot which does not actively move
* @author Marion Billington
* @version 11.16.2017
* @since 25-7-2007
*/
import java.awt.*;

public class Polkadot
{
   private double myX;   
   private double myY;
   private double myDiameter;
   private Color myColor; 
   private double myRadius;

/**
* Instantiates a default polkadot
* Defaults polkadots are at (200,200)
* Have a diameter of 25 and are red
*/
   public Polkadot()     //default constructor
   {
      myX = 200;
      myY = 200;
      myDiameter = 25;
      myColor = Color.RED;
      myRadius = myDiameter/2;
   }
/**
* Overloaded constructor for polkadot
* @param x desired x-coordinate
* @param y desired y-coordinate
* @param d desired diameter
* @param c desired color
*/
   public Polkadot(double x, double y, double d, Color c)
   {
      myX = x;
      myY = y;
      myDiameter = d;
      myColor = c;
      myRadius = d/2;
   }

/**
* Accessor for the x-coordinate
* @return current x-coordinate
*/
   public double getX() 
   { 
      return myX;
   }
/**
* Accessor for the y-coordinate
* @return current y-coordinate
*/
   public double getY()      
   { 
      return myY;
   }
/**
* Accessor for the diameter
* @return current diameter
*/
   public double getDiameter() 
   { 
      return myDiameter;
   }
/**
* Accessor for the color
* @return current color
*/
   public Color getColor() 
   { 
      return myColor;
   }
/**
* Accessor for the radius
* @return current radius
*/
   public double getRadius() 
   { 
      return myRadius;
   }
/**
* Modifier for the x-coordinate
* @param x desired x-coordinate
*/
   public void setX(double x)
   {
      myX = x;
   }
/**
* Modifier for the y-coordinate
* @param y desired y-coordinate
*/ 
   public void setY(double y)
   {
      myY = y;
   }
/**
* Modifier for the color
* @param c desired color
*/ 
   public void setColor(Color c)
   {
      myColor = c;
   }
/**
* Modifier for the diameter
* @param d desired diameter
*/
   public void setDiameter(double d)
   {
      myDiameter = d;
      myRadius = d/2;
   }
/**
* Modifier for the radius
* @param r desired radius
*/
   public void setRadius(double r)
   {
      myRadius = r;
      myDiameter = 2*r;
   }
/**
* Changes the polkadot to a random spot inside the frame
* @param rightEdge right-most edge of the frame
* @param bottomEdge bottom-most edge of the fram
*/
   public void jump(int rightEdge, int bottomEdge)
   {
      // moves location to random (x, y) within the edges
      myX = (Math.random()* (rightEdge-myDiameter) + myRadius);
      myY = (Math.random()* (bottomEdge-myDiameter) + myRadius);
   }
/**
* Draws the polkadot onto the frame as a buffered image
* @param myBuffer desired image which the polkadot will be drawn
*/
   public void draw(Graphics myBuffer) 
   {
      myBuffer.setColor(myColor);
      myBuffer.fillOval((int)(getX() - getRadius()), (int)(getY()-getRadius()), (int)getDiameter(), (int)getDiameter());
   }
}