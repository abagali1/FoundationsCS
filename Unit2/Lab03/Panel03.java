import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Panel03
  extends JPanel
{
  private BufferedImage myImage;
  
  public Panel03()
  {
    int N = 400;
    myImage = new BufferedImage(400, 400, 1);
    Graphics buffer = myImage.getGraphics();
    
    buffer.setColor(Color.BLUE);
    buffer.fillRect(0, 0, 400, 400);
    buffer.setColor(Color.YELLOW);
    for (int k = 0; k <= 50; k++)
    {
      buffer.drawLine(400 * k / 50, 0, 400, 400 * k / 50);
      buffer.drawLine(400, 400 * k / 50, 400 * (50 - k) / 50, 400);
      buffer.drawLine(400 * (50 - k) / 50, 400, 0, 400 * (50 - k) / 50);
      buffer.drawLine(0, 400 * (50 - k) / 50, 400 * k / 50, 0);
    }
    int x = 200;int y = 200;
    
    int size = 100;
    int r1 = 60;int r2 = 55;
    for (int angle = 1; angle < 360; angle += 30)
    {
      int x1 = (int)(x + size * Math.cos(angle * 3.141592653589793D / 180.0D));
      int y1 = (int)(y - size * Math.sin(angle * 3.141592653589793D / 180.0D));
      buffer.drawLine(x, y, x1, y1);
    }
    buffer.setColor(Color.BLUE.brighter());
    buffer.fillOval(x - r1, y - r1, r1 * 2, r1 * 2);
    buffer.setColor(Color.YELLOW);
    buffer.fillOval(x - r2, y - r2, r2 * 2, r2 * 2);
  }
  
  public void paintComponent(Graphics g)
  {
    g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
  }
}
