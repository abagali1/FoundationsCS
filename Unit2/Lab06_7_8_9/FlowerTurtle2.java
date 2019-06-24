import edu.fcps.Turtle;
import java.awt.Color;

public class FlowerTurtle2
  extends Turtle
{
  private double mySize;
  private Color myColor;
  
  public FlowerTurtle2()
  {
    mySize = 50;
    myColor = Color.red;
  }
  
  public FlowerTurtle2(double x, double n, Color c)
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
    setColor(myColor);
    for (int x = 1; x <= 30; x++)
    {
      for (int k = 1; k <= 4; k++)
      {
        forward(mySize);
        turnLeft(90);
      }
      turnLeft(12);
    }
    turnLeft(180);
    forward(mySize);
  }
  
  private void drawStem()
  {
    setColor(Color.green.darker());
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
