import edu.fcps.Turtle;

public class PolygonTurtle
  extends Turtle
{
  private double mySize;
  private int mySides;
  
  public PolygonTurtle()
  {
    mySize = 50;
    mySides = 6;
  }
  
  public PolygonTurtle(double n, int s)
  {
    mySize = n;
    mySides = s;
  }
  
  public PolygonTurtle(double x, double y, double h, double n, int s)
  {
    super(x, y, h);
    mySize = n;
    mySides = s;
  }
  
  public void setSize(double n)
  {
    mySize = n;
  }
  
  public void setSides(int s)
  {
    mySides = s;
  }
  
  public void drawShape()   
  {
    int count = mySides;
    while (count != 0)
    {
      forward(mySize);
      turnLeft(360 / mySides);
      count--;
    }
  }
}
