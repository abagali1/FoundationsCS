/**
* Bumper class which instantiates a moveable
* rectangle which can deflect objects which hit it
*
* @author Anup Bagali
* @version 2.0
* @since 2017-11-01
*/
import java.awt.*;
import javax.swing.ImageIcon;

public class Bumper
{
   private int myX;
   private int myY;
   private int myWidth;
   private int myHeight;
   private Color myColor;
   private boolean lAcc, rAcc;
   private int dX;
   
/**
* Instantiates a default bumper
* Default bumpers are at (200,200),
* have a width of 50, height of 100, and
* are a blue color
*/
   public Bumper()          {
      myX = 200;
      myY = 200;
      myWidth = 50;
      myHeight = 100;
      myColor = Color.BLUE;
   }
/**
* Overloaded constructor for bumper
*
* @param x the x-coordinate
* @param y the y-coordinate
* @param w the width
* @param h the height
* @param c the color
*/   
   public Bumper(int x, int y, int w, int h, Color c)
   {
      myX = x;
      myY = y;
      myWidth = w;
      myHeight = h;
      myColor = c;  
   }
/** 
* Accessor for the x-coordinate
* @return myX current x-coordinate
*/
   public int getX(){
      return myX;
   }
/** 
* Accessor for the x-coordinate
* @return myY current y-coordinate
*/
   public int getY(){
      return myY;
   }
/** 
* Accessor for the width
* @return myWidth current width
*/
   public int getWidth(){
      return myWidth;
   }
/**
* Accessor for the height
* @return myHeight current height
*/
   public int getHeight(){
      return myHeight;
   }
/**
* Accessor for the color
* @return myColor current color
*/
   public Color getColor(){
      return myColor;
   }
/**
* Accessor for the Left Acceleration
* @return lAcc current left acceleration
*/
   public boolean getLAcc(){
      return lAcc;
   }
/**
* Accessor for the Right Acceleration
* @return rAcc current right acceleration
*/
   public boolean getRAcc(){
      return rAcc;
   }
/**
* Accessor for the change in X
* @return dX current change in X
*/
   public int getdX(){
      return dX;
   }
/**
* Modifier for the x-coordinate
* @param x wanted x-coordinate
*/
   public void setX(int x){
      myX = x;
   }
/**
* Modifier for the y-coordinate
* @param y wanted y-coordinate
*/
   public void setY(int y){
      myY=y;
   }
/**
* Modifier for the width
* @param w wanted width
*/
   public void setWidth(int w){
      myWidth = w;
   }
/**
* Modifier for the color
* @param c wanted color
*/
   public void setColor(Color c){
      myColor = c;
   }
/**
* Modifier for the left acceleration
* @param a wanted left acceleration
*/
   public void setLAcc(boolean a){
      lAcc = a;
   }
/**
* Modifier for the right acceleration
* @param a wanted right acceleration
*/
   public void setRAcc(boolean a){
      rAcc = a;
   }
/**
* Modifier for the dX(change in X)
* @param a wanted dX
*/
   public void dX(int a){
      dX = a;
   }
/**
* Changes the location of the bumper to a random spot inside the frame
* @param rightEdge right-most bound of the frame
* @param bottomEdge bottom-most bound of the frame
*/
   public void jump(int rightEdge, int bottomEdge)
   {
      setX((int)((Math.random()*(rightEdge-myWidth)))); 
      setY((int)((Math.random()*(bottomEdge-myHeight))));     
   }
/**
* Draws the bumper onto the frame as a buffered image
* @param myBuffer desired buffer for the bumper to be drawn
*/
  public void draw(Graphics myBuffer)
  {
    ImageIcon pic = new ImageIcon("walls.jpg");
    myBuffer.drawImage(pic.getImage(), (int)(getX() - getWidth()), (int)(getY() - getHeight()), 50, 50, null);
  }
/**
* Sees if a polkadot(Ball) is within the bumper
* @param dot the polkadot which is going to be checked
* @return whether the polkadot is inside the bumper
*/   
   public boolean inBumper(Polkadot dot)
   {
      for(int x = getX(); x <= getX() + getWidth(); x++)   
         for(int y = getY(); y <= getY() + getHeight(); y++)
            if(distance(x, y, dot.getX(), dot.getY()) <= dot.getRadius() ) 
               return true;            
      return false;
   }  
/**
* Calculates the distance between two points 
* @param x1 x-coordinate of first point
* @param y1 y-coordinate of first point
* @param x2 x-coordinate of second point
* @param y2 y-coordinate of second point
* @return the distance between the two points
*/
   public double distance(double x1, double y1, double x2, double y2)
   {
      return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
   }
/**
* Smoothly moves the bumper left or right
*/	
   public void move(){
      if(rAcc){
         dX += 1;
      }else if(lAcc){
         dX -= 1;
      } else if(!rAcc && !lAcc){
         dX *= 0.1;
      }
      setX(getX() + dX);
      if(dX >= 5)
         dX = 5;
      if(dX <= -5)
         dX = -5;
      if(getX() >= 320) {
         setX(320);
         rAcc = false;
      }
      else if(getX() <= 0){
         setX(0);
         lAcc = false;
      }
   }
}
