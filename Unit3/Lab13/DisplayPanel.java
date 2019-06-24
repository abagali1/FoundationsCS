import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class DisplayPanel extends JPanel{

   BufferedImage img;
   
   public DisplayPanel(BufferedImage a){
      img = a;
   }
   public void paintComponent(Graphics g)
   {
      g.drawImage(img, 0, 0, 400, 400, null);
   }
}
