	/*****************************************************************
	* A Circle is a Shape that maintains information about its radius. A Circle
	* knows how to return its radius, set its radius, calculate and return its 
	* area, and calculate and return its circumference.
	 
	* @author Anup Bagali
	* @version 1
	****************************************************************/
    public class Circle extends Shape
   {
      private double myRadius;
   	
   	/************************************************************* 
   	* Constructs a circle with initial radius specified by x.
   	* @param x    initial radius
   	**************************************************************/
       public Circle(double x)
      {
         myRadius = x;
      }
   	
   	/*************************************************************** 
   	* Returns the circle's radius
   	* @return	 radius
   	**************************************************************/
       public double getRadius()
      {
         return myRadius;
      }
		
   	/***************************************************************
   	* Sets the radius to the input number.
   	* @param x	 assigns x to myRadius
   	**************************************************************/
       public void setRadius(double x)
      {
         myRadius = x;
      }
		
   	/***************************************************************
   	* Calculates and returns the circle's area.
   	* @return	 area
   	**************************************************************/
       public double findArea()
      {
         return Math.pow(myRadius,2.0)*Math.PI;
      }
		
   	/**************************************************************
   	* Calculates and returns the circle's circumference.
   	* @return	 circumference
   	**************************************************************/
       public double findCircumference()
      {
         return (2*myRadius*Math.PI);
      }
   }