import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import edu.fcps.Bucket;

public class Driver04b{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Buckets");
      frame.setSize(600, 400);
      frame.setLocation(100, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new BucketPanel());
      frame.setVisible(true);
      Bucket.setSpeed(10);
      Bucket.useTotal(true);
      Bucket five = new Bucket(5);
      Bucket three = new Bucket(3);
      Bucket four = new Bucket(4);
      four.fill(); //4
      four.pourInto(three);
      three.spill();
      five.fill();
      five.pourInto(three);
      three.spill();
      four.spill();
      three.fill();
      four.fill();
      five.fill();
      five.spill();
      four.pourInto(five);
      four.fill();
      three.spill();
      four.pourInto(three);
      three.spill();
      four.pourInto(three);
      five.fill(); 
      four.fill();
   }
}

