import javax.swing.*;
import java.io.*;

public class DriverSampleYard{
   
   public static void main(String[] args) throws Exception{
   
      JFrame frame = new JFrame("Sample Final Exam");
      frame.setLocation(200,100);
      frame.setSize(200,200);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new PanelSampleYard());
      frame.setVisible(true);
   }
}
