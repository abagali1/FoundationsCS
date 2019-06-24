import edu.fcps.Turtle;
import java.awt.Color;

public class FlowerTurtle
  extends Turtle
{
  private double mySize;
  private Color myColor;
  
  public FlowerTurtle()
  {
    mySize = 50;
    myColor = Color.RED;
  }
  
  public FlowerTurtle(double x, double n, Color c)
  {
    super(x, 300, 90);
    mySize = n;
    myColor = c;
  }
  
  public void setSize(double n)
  {
    mySize = n;
  }
  
  public void setColor(Color c)
  {
    myColor = c;
  }
  
  private void drawPetals()
  {
    super.setColor(myColor);
    for (int x = 1; x <= 30; x++)
    {
      forward(mySize);
      back(mySize);
      turnLeft(12);
    }
    turnLeft(180);
    forward(mySize);
  }
  
  private void drawStem()
  {
    setColor(Color.GREEN.darker());
    double a = mySize / 2;
    forward(a * 2);
    turnLeft(135);
    forward(a * 2);
    back(a * 2);
    turnLeft(90);
    forward(a);
    back(a);
    turnLeft(135);
    forward(a);
  }
  
  public void drawShape()
  {
    drawPetals();
    drawStem();
  }
}
