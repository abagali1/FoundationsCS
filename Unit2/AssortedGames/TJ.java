import java.awt.Graphics;
import javax.swing.ImageIcon;

public class TJ extends Ball
{
  public void draw(Graphics myBuffer)
  {
    ImageIcon pic = new ImageIcon("tj.jpg");
    myBuffer.drawImage(pic.getImage(), (int)(getX() - getRadius()), (int)(getY() - getRadius()), 50, 50, null);
  }
}
