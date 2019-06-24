   /**
   * A Triangle is a Shape with maintains information of its side length. 
   * A Triangle knows how to set and return its side length, calculate and 
   * return its area, and calculate and return its perimeter
   *
   * @author Anup Bagali
   * @version 1
   **/
public class Triangle extends Shape{
   
   private double mySide;
   
   /**
   * Constructs a Triangle with side length specified by x
   * @param x initial side length
   **/
   public Triangle(double x){
      mySide = x;
   }
   /**
   * Sets the current side length of the Triangle to specified length
   * @param s desired side length
   **/
   public void setSide(double s){  
      mySide = s;
   }
   /**
   * Returns the current side length of the Triangle
   * @return current side length of the Triangle
   **/
   public double getSide(){
      return mySide;
   }
   /**
   * Calculates and returns the area of the Triangle
   * @return current area of the Triangle
   **/
   public double findArea(){
      return ((Math.pow(3,0.5)/4.0)*(Math.pow(mySide,2.0)));
   }
   /**
   * Calculates the returns the perimeter of the Triangle
   * @return current perimeter of the Triangle
   **/
   public double findPerimeter(){
      return (3*mySide);
   }
}