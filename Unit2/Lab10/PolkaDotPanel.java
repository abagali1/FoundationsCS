import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PolkaDotPanel
  extends JPanel
{
   private static final int FRAME = 400;
   private static final Color BACKGROUND = new Color(204, 204, 204);
   private BufferedImage myImage;
   private Graphics myBuffer;
   private Timer t;
   private Polkadot pd;
   private Polkadot pd2;
   
   public PolkaDotPanel()
   {
      myImage = new BufferedImage(FRAME,FRAME, 1);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME,FRAME);
      pd = new Polkadot();
      pd2 = new Polkadot(0, 0, 90, Color.MAGENTA);
      t = new Timer(1000, new Listener());
      t.start();
   }
   
   public void paintComponent(Graphics g)
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }
   
   private class Listener
     implements ActionListener
   {
      private Listener(){
      }
      
      public void actionPerformed(ActionEvent e)
      {
         myBuffer.setColor(BACKGROUND);
         myBuffer.fillRect(0, 0, FRAME,FRAME);
         
         pd.jump(FRAME,FRAME);
         pd.draw(myBuffer);
         pd2.jump(FRAME,FRAME);
         pd2.draw(myBuffer);
         
         repaint();
      }
   }
}
