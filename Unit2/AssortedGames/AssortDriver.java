import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class AssortDriver
{
   public static void main(String[] args)
   { 
      JFrame frame = new JFrame("Pong");
      frame.setSize(408,438);    //makes the mouse location correct
      frame.setLocation(100, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      AssortPanel p = new AssortPanel();
      frame.setContentPane(p);
      p.requestFocus();
      frame.setVisible(true);
         
   }
}
