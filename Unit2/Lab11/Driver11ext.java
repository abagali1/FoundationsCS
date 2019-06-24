import javax.swing.JFrame;

public class Driver11ext
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame("Lab11ext");
    frame.setSize(400, 400);
    frame.setLocation(100, 50);
    frame.setDefaultCloseOperation(3);
    frame.setContentPane(new PinballPanelTJ());
    frame.setVisible(true);
  }
}
