import javax.swing.JFrame;

public class Driver11
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame("Lab11");
    frame.setSize(400, 400);
    frame.setLocation(100, 50);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(new PinballPanel());
    frame.setVisible(true);
  }
}
