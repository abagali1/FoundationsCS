import edu.fcps.Turtle;
import java.awt.Color;

public class TwistyTurtle1
  extends Turtle
  implements Runnable
{
  public TwistyTurtle1(double x, double y, double h)
  {
    super(x, y, h);
    super.setColor(Color.black);
  }
  
  public void drawShape()
  {
    for (int k = 5; k <= 400; k += 10)
    {
      forward(k);
      turnLeft(123);
    }
  }
  
  public void run()
  {
    drawShape();
  }
}