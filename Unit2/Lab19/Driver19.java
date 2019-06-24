import javax.swing.JFrame;

public class Driver19
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame("Unit2, Lab19");
    frame.setSize(400, 400);
    frame.setLocation(100, 50);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(new PrizePanel());
    frame.setVisible(true);
  }
}
