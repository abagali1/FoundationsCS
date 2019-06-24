   /**
   * A Square is a Rectangle with the same height and width. A Square inherits its
   * width and height from Rectangle, but they are equal. A Square knows how to set
   * its side length in addition to its inherited methods from Rectangle
   *
   * @author Anup Bagali
   * @version 1
   **/
   
public class Square extends Rectangle{
   
   /**
   * Constructs a Square with initial height and width specified by x
   * @param x desired side length
   **/
   public Square(double x){
      super(x,x);
   }
   /**
   * Sets the current side length of the Square to input number
   * @param s desired side length
   **/
   public void setSide(double s){
      setHeight(s);
      setWidth(s);
   }
   /**
   * Returns the current side length of the Square
   * @return current side length of square
   **/
   public double getSide(){
      return getHeight();
   }
}