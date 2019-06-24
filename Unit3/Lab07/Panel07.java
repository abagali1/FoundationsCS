import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel07
  extends JPanel
{
  private Display07 display;
  
  public Panel07()
  {
    setLayout(new FlowLayout());
    
    display = new Display07();
    add(display);
    
    JButton gcd = new JButton("GCD");
    gcd.addActionListener(new Listener1());
    add(gcd);
    
    JButton lcm = new JButton("LCM");
    lcm.addActionListener(new Listener2());
    add(lcm);
  }
  
  private class Listener1
    implements ActionListener
  {
    private Listener1() {}
    
    public void actionPerformed(ActionEvent e)
    {
      display.showGCD();
    }
  }
  
  private class Listener2
    implements ActionListener
  {
    private Listener2() {}
    
    public void actionPerformed(ActionEvent e)
    {
      display.showLCM();
    }
  }
}
