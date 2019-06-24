import java.awt.Color;
import java.awt.Graphics;

public class Spot
{
  int x;
  int y;
  int r;
  Color c;
  
  public Spot(int x, int y, int r, Color c)
  {
    x = x;
    y = y;
    r = r;
    c = c;
  }
  
  public boolean intersect(Spot b)
  {
    return Math.sqrt(Math.pow(x - b.x, 2) + Math.pow(y - b.y, 2)) <= r + b.r;
  }
  
  public void drawme(Graphics g)
  {
    g.setColor(c);
    g.fillOval(x - r, y - r, 2 * r, 2 * r);
  }
}
