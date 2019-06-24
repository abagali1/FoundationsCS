/**
* BumperCollision class sees if a ball 
* hits a bumper and calculates the vector at
* which it should reflect off of
* @author Phil Ero
* @version 11.16.2017
* @since 25-7-2007
*/
 
public class BumperCollision
{
   private static double nearestX;	// used to approximate what point of the bumper  
   private static double nearestY;  // a ball collided with
/**
* Sees if ball hits the bumper and if it does calculates the vector at which it
* reflects off of
* @param bumper specific bumper which the ball will collide with
* @param ball specific ball which will collide with the bumper
*/
   public static void collide(Bumper bumper, Ball ball)
   {
      // see if the ball hit the bumper!
      if(bumper.inBumper(ball))
      {	   	
         // back the ball up until it is just outside the bumper
         while(bumper.inBumper(ball))
         {
            ball.setX(ball.getX() - ball.getdx()/10.0);
            ball.setY(ball.getY() - ball.getdy()/10.0);
         }
         
         // find the point on the edge of the bumper closest to the ball
         findImpactPoint(bumper, ball);
      	
         double ux=nearestX-ball.getX();
         double uy=nearestY-ball.getY();
         double ur=Math.sqrt(ux*ux+uy*uy);
         ux/=ur;
         uy/=ur;
         int dx=(int)ball.getdx();
         int dy=(int)ball.getdy();
         double dot_1= ux*dx+uy*dy;
         double dot_2=-uy*dx+ux*dy;
         dot_1*=-1; // this is the actual "bounce"
         double[] d = new double[2];
         d[0]=dot_1*ux-dot_2*uy;      //vector math
         d[1]=dot_1*uy+dot_2*ux;      //vector math
         dx=(int)Math.round(d[0]);
         dy=(int)Math.round(d[1]);
         ball.setdx(dx);
         ball.setdy(dy);
      }
   }
/**
* Find the impact point if a ball collides with a bumper
* @param bumper specific bumper the ball is colliding with
* @param ball specific ball which will collide with the bumper
*/      
   private static void findImpactPoint(Bumper bumper, Ball ball)
   {
       // first assume the nw corner is closest
      nearestX = bumper.getX();  
      nearestY = bumper.getY();
      
      // now work around the edge of the bumper looking for a closer point
      for (int x = bumper.getX(); x <= bumper.getX() + bumper.getWidth(); x++)  // top & bottom edges
      {
         updateIfCloser(x, bumper.getY(), ball);
         updateIfCloser(x, bumper.getY() + bumper.getHeight(), ball);
      }
      for (int y = bumper.getY(); y <= bumper.getY() + bumper.getHeight(); y++)  // right & left edges
      {
         updateIfCloser(bumper.getX(), y, ball);
         updateIfCloser(bumper.getX() + bumper.getWidth(), y, ball);
      }
   }
      
/**
* Makes the (x,y) coordinates the nearest point if it is closer to the ball
* @param x x-coordinate
* @param y y-coordinate
* @param b ball
*/
   private static void updateIfCloser(int x, int y, Ball b)
   {
      if(distance(x, y, b.getX(), b.getY()) < distance(nearestX, nearestY, b.getX(), b.getY()))
      {
         nearestX = x;
         nearestY = y;
      }
   }
       
/**
* Calculates the distance between two points 
* @param x1 x-coordinate of first point
* @param y1 y-coordinate of first point
* @param x2 x-coordinate of second point
* @param y2 y-coordinate of second point
* @return the distance between the two points
*/       
   private static double distance(double x1, double y1, double x2, double y2)
   {
      return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
   }	
}