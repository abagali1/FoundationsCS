   /**
   * A Rectangle is a Shape which maintains information about its height
   * and width. A Rectangle knows how to return and set its height and width, 
   * calculates and return its area, calculate and return its perimeter, and calculate and return its diagonal.
   
   * @author Anup Bagali
   * @version 1
   **/
public class Rectangle extends Shape{
   
   private double myHeight;
   private double myWidth;
      
   /**
   * Constructs a Rectange with initial height specified by h 
   * and intial height specified by w
   * @param h initial height
   * @param w initial width
   **/
   public Rectangle(double h, double w){
      myHeight = h;
      myWidth = w;
   }
   /**
   * Returns the current height of the Rectangle
   * @return height
   */
   public double getHeight(){
      return myHeight;
   }
   /**
   * Returns the current width of the Rectangle
   * @return width
   */
   public double getWidth(){
      return myWidth;
   }
   /**
   * Sets the height to input number
   * @param x desired height
   **/
   public void setHeight(double x){
      myHeight = x;
   }
   /**
   * Sets the width to input number
   * @param x desired width
   **/
   public void setWidth(double x){
      myWidth =x;
   }
   /**
   * Calculates and returns the area of the Rectangle
   * @return current area of Rectangle
   **/
   public double findArea(){
      return myHeight*myWidth;
   }
   /**
   * Calculates and returns the perimeter of the Rectangle
   * @return current perimeter of Rectangle
   **/
   public double findPerimeter(){
      return myHeight+myHeight+myWidth+myWidth;
   }
   /**
   * Calculates and returns the diagonal of the Rectangle
   * @return current diagonal of Rectangle
   **/
   public double findDiagonal(){
      return Math.pow((Math.pow(myWidth,2.0)+Math.pow(myHeight,2.0)),0.5);
   }
}
