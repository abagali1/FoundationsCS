/**
* TJ class which instantiates a ball
* which looks like a picture of an important person 
* @author Anup Bagali
* @version 1.0
* @since 11-12-2017
*/

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class TJ extends Ball
{
/**
* Overrides the draw method in Ball and displays a picture instead
* @param myBuffer desired buffered image to draw to
*/
  public void draw(Graphics myBuffer)
  {
    ImageIcon pic = new ImageIcon("tj.jpg");
    myBuffer.drawImage(pic.getImage(), (int)(getX() - getRadius()), (int)(getY() - getRadius()), 50, 50, null);
  }
}
