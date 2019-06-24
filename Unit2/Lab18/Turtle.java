// Torbert, 7.20.06

import java.awt.*;
import java.awt.image.*;

public class Turtle
{
   private static BufferedImage img;
   private static int black = 0;
   private static int blue = 255;       // 2^8-1
   private static int green = 65280;    //(2^8-1)*2^8
   private static int red = 16711680;   //(2^8-1)*2^16
   private static int white = 16777215; // 2^24-1
   private double x,y,theta;            // what does a Turtle know?
   static									 	 // a static initializer list
   {
      img = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
   }
   public Turtle()
   {
      img = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
      x=img.getWidth()/2;           //start at center
      y=img.getHeight()/2;          //start at center
      theta=90;                     //start facing north
   }
   public static Image getImage()
   {
      return img;
   }
   public void turnLeft(double a)
   {
      theta+=a;
   }
   public double distance(int a1, int b1, int a2, int b2){
      return Math.sqrt(Math.pow(a2-a1,2) + Math.pow(b2-b1,2));
   }
   public void forward(int x1, int y1, int x2, int y2)
   {  
   
      int slope = ((y2-y1)/(x2-x1));
      int[] xpoints = new int[800];
      int[] ypoints = new int[800];
      
      for(int horiz = 0; horiz <= 400; horiz ++){
         for(int vertic = 0; vertic <= 400; vertic++){
            if (distance(x1,y1,horiz,vertic) + distance(x2,y2,horiz,vertic) == distance(x1,y1,x2,y2)){
               for(int a =0; a< 800; a++){
                  xpoints[a] = horiz;
                  ypoints[a] = vertic;
                  if(xpoints[a] != (int)xpoints[a]){
                     xpoints[a] = 0;
                  }
                  if(ypoints[a] != (int)ypoints[a]){
                     ypoints[a] = 0;
                  }
                  img.setRGB(xpoints[a],ypoints[a],BufferedImage.TYPE_INT_RGB);
               }
              
            
            }
         }
      }
      
   }
}         
         
