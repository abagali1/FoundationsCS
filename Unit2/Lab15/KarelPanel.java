import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class KarelPanel
  extends JPanel
{
  private static final int WIDTH = 395;
  private static final int HEIGHT = 391;
  private static final Color BACKGROUND = new Color(204, 204, 204);
  private int xPos;
  private int yPos;
  private int dir;
  private ImageIcon[] myArray;
  private BufferedImage myImage;
  private Graphics myBuffer;
  
  public KarelPanel()
  {
    myImage = new BufferedImage(395, 391, 1);
    myBuffer = myImage.getGraphics();
    myArray = new ImageIcon[4];
    myArray[0] = new ImageIcon("karele.gif");
    myArray[1] = new ImageIcon("kareln.gif");
    myArray[2] = new ImageIcon("karelw.gif");
    myArray[3] = new ImageIcon("karels.gif");
    dir = 0;
    xPos = 5;
    yPos = (388 - myArray[dir].getImage().getHeight(null));
    Timer t = new Timer(1000, new Listener());
    t.start();
  }
  
  public void paintComponent(Graphics g)
  {
    g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
  }
  
  private class Listener
    implements ActionListener
  {
    private Listener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      switch (dir)
      {
      case 0: 
        xPos = (xPos + 30);
        break;
      case 1: 
        yPos = (yPos - 28);
        break;
      case 2: 
        xPos = (xPos - 30);
        break;
      case 3: 
        yPos = (yPos + 28);
      }
      if (yPos >= 381)
      {
        if (dir != 0)
        {
          xPos = 5;
          yPos = (388 - myArray[0].getImage().getHeight(null));
        }
        dir = 0;
      }
      if (xPos >= 395)
      {
        if (dir != 1)
        {
          yPos = (386 - myArray[1].getImage().getHeight(null));
          xPos = (392 - myArray[1].getImage().getWidth(null));
        }
        dir = 1;
      }
      if (yPos <= -4)
      {
        if (dir != 2)
        {
          yPos = -4;
          xPos = (390 - myArray[2].getImage().getWidth(null));
        }
        dir = 2;
      }
      if ((xPos < -3) && (dir != 0))
      {
        if (dir != 3)
        {
          xPos = 3;
          yPos = -3;
        }
        dir = 3;
      }
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, 395, 391);
      myBuffer.setColor(Color.red);
      for (int x = 17; x < 395; x += 30) {
        myBuffer.drawLine(x, 0, x, 391);
      }
      for (int y = 9; y < 391; y += 28) {
        myBuffer.drawLine(0, y, 395, y);
      }
      myBuffer.drawImage(myArray[dir].getImage(), xPos, yPos, null);
      myBuffer.fillRect(107, 121, 180, 56);
      myBuffer.setColor(Color.black);
      myBuffer.setFont(new Font("SansSerif", 1, 20));
      myBuffer.drawString("Karel the Robot", 125, 155);
      repaint();
    }
  }
}
