import javax.swing.JFrame;

public class Driver16
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame("Unit2, Lab16");
    frame.setSize(408, 438 );
    frame.setLocation(100, 50);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(new PrizePanel());
    frame.setVisible(true);
  }
}
