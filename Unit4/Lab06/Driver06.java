   //Name______________________________ Date_____________
   import java.io.*;
    public class Driver06
   {
       public static void main(String[] args) throws Exception
      {
         System.setOut(new PrintStream(new FileOutputStream("output.txt")));
      
      //create the objects
         Circle c = new Circle(75);
         Rectangle r = new Rectangle(30.0, 40.);    
         Square s = new Square(50.0);			 	// remove the comment slashes 	
      	Triangle t = new Triangle(37);          // when your classes are finished
      
      //test the instance methods
         System.out.println("Circle");
         System.out.println("------");
         System.out.println("Radius: " + c.getRadius());
         System.out.println("Area: " + c.findArea());
         System.out.println("Circumference: " + c.findCircumference());
         System.out.println();
      
         System.out.println("Rectangle");
         System.out.println("---------");
         System.out.println("Length: " + r.getWidth());
         System.out.println("Height: " + r.getHeight());
         System.out.println("Area: " + r.findArea());
         System.out.println("Perimeter: " + r.findPerimeter());
         System.out.println("Diagonal: " + r.findDiagonal());
         System.out.println();
         
         System.out.println("Square");
         System.out.println("------");
         System.out.println("Side Length: " + s.getSide());
         System.out.println("Area: " + s.findArea());
         System.out.println("Perimeter: " + s.findPerimeter());
         System.out.println("Diagonal: " + s.findDiagonal());
         s.setSide(10.0);
         System.out.println("New side: " + s.getSide());
         System.out.println("New area: " + s.findArea());	
         System.out.println(); 
      
         System.out.println("Triangle");
         System.out.println("--------");
         System.out.println("Side Length: " + t.getSide());
         System.out.println("Area: " + t.findArea());
         System.out.println("Perimeter: " + t.findPerimeter());
         System.out.println();
      }
   }