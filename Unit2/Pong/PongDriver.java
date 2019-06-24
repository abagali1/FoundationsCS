import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class PongDriver
{
   public static void main(String[] args)
   { 
      JOptionPane.showMessageDialog(null,"A,D for top; <-, -> for bottom; press space to restart game, or to increase speed");
      JFrame frame = new JFrame("Pong");
      frame.setSize(408, 438);    //makes the mouse location correct
      frame.setLocation(0, 0);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      PongPanel p = new PongPanel();
      //RVPongPanel p = new VPongPanel();
      frame.setContentPane(p);
      p.requestFocus();
      frame.setVisible(true);
         
   }
}
