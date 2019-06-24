/**
* Displays and runs the Pong game
* @author Anup Bagali
* @version 2.0
* @since 2017-12-01
*/
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class PongDriver
{
/**
* Runs a Pong game inside a JFrame
* @param args String[]
*/
   public static void main(String[] args)
   { 
      //********DO NOT ENLARGE FRAME!!!!!**********r
      JFrame frame = new JFrame("Pong");
      frame.setSize(408,438);    //makes the mouse location correct
      frame.setLocation(500, 100);
      frame.setUndecorated(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      PongPanel p = new PongPanel();
      frame.setContentPane(p);
      p.requestFocus();
      frame.setVisible(true);
         
   }
}
