import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PinballPanelTJ
  extends JPanel
{
  private static final int FRAME = 400;
  private static final Color BACKGROUND = new Color(204, 204, 204);
  private BufferedImage myImage;
  private Graphics myBuffer;
  private Ball ball;
  private Timer t;
  
  public PinballPanelTJ()
  {
    myImage = new BufferedImage(FRAME, FRAME, 1);
    myBuffer = myImage.getGraphics();
    myBuffer.setColor(BACKGROUND);
    myBuffer.fillRect(0, 0, FRAME,FRAME);
    int xPos = (int)(Math.random() * 300 + 50);
    int yPos = (int)(Math.random() * 300+ 50);
    
    ball = new TJ();
    
    t = new Timer(10, new Listener());
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
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME,FRAME);
      
      ball.move(FRAME,FRAME);
      ball.draw(myBuffer);
      
      repaint();
    }
  }
}
