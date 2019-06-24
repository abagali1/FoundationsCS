import javax.swing.JFrame;

public class Driver07
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame("Lab7");
    frame.setSize(220, 200);
    frame.setLocation(200, 100);
    frame.setDefaultCloseOperation(3);
    frame.setContentPane(new Panel07());
    frame.setVisible(true);
  }
}
