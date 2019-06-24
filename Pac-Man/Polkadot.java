/**
* Polkadot class which instantiates a moveable
* polkadot which does not actively move
* @author Marion Billington
* @version 11.16.2017
* @since 25-7-2007
*/
import java.awt.*;
import javax.swing.ImageIcon;

public class Polkadot
{
   private double myX;   
   private double myY;
   private double myDiameter;
   private Color myColor; 
   private double myRadius;
   private boolean lAcc, rAcc, dAcc, uAcc, ans;
   private int dir;

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
      dir =1;
   }
/**
* Overloaded constructor for polkadot
* @param x desired x-coordinate
* @param y desired y-coordinate
* @param d desired diameter
* @param c desired color
*/
   public Polkadot(double x, double y, double d, Color c, int di) {
      myX = x;
      myY = y;
      myDiameter = d;
      myColor = c;
      myRadius = d/2;
      dir = di;
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
   public void setLAcc(boolean a){
      lAcc = a;
   }
   public void setRAcc(boolean a){
      rAcc = a;
   }
   public void setDAcc(boolean a){
      dAcc = a;
   }
   public void setUAcc(boolean a){
      uAcc = a;
   }
   public boolean frontIsClear(Bumper[] arr){
      setX(getX()+1);
      setY(getY()+1);
      do{
         for(Bumper a: arr)
            ans = inBumper(a);
      }while(ans!=true);
      setX(getX()-1);
      setY(getY()-1);
      return ans;
   }
   public int isFacing(){
      return dir;
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
   public double distance(double x1, double y1, double x2, double y2)
   {
      return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
   }
/**
* Draws the polkadot onto the frame as a buffered image
* @param myBuffer desired image which the polkadot will be drawn
*/
   public void draw(Graphics myBuffer)
   {
      ImageIcon pic = new ImageIcon("pac"+dir+".gif");
      myBuffer.drawImage(pic.getImage(), (int)(getX() - getRadius()), (int)(getY() - getRadius()), 50, 50, null);
   }
   public boolean inBumper(Bumper dot)
   {
      for(int x = dot.getX(); x <= dot.getX() + dot.getWidth(); x++)   
         for(int y = dot.getY(); y <= dot.getY() + dot.getHeight(); y++)
            if(distance(x, y, getX(), getY()) <= getRadius() ) 
               return true;            
      return false;
   }  
   public void move(Bumper[] arr){
      if(lAcc){
         if(dir != 1){
            dir = 1;
         }else{
            if(frontIsClear(arr))
               setX(getX()+5);
         }
      }else if(rAcc){
         if(dir != 3){
            dir = 3;
         }else{
            if(frontIsClear(arr))
               setX(getX()-5);
         }
      }else if(dAcc){
         if(dir != 4){
            dir = 4;
         }else{
            if(frontIsClear(arr))
               setY(getY()-5);
         }
      }else if(uAcc){
         if(dir != 2){
            dir = 2;
         }else{
            if(frontIsClear(arr))
               setY(getY()+5);
         }
      }      
   }
}