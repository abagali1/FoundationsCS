import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel00
  extends JPanel
{
  private JLabel label;
  
  public Panel00()
  {
    setLayout(new FlowLayout());
    
    label = new JLabel("0");
    label.setFont(new Font("Serif", 1, 20));
    label.setForeground(Color.BLUE);
    add(label);
    
    JButton button = new JButton("Random");
    button.addActionListener(new Panel00.Listener());
    add(button);
  }
  
  private class Listener
    implements ActionListener
  {    
    public void actionPerformed(ActionEvent e)
    {
      double x = Math.random();
      label.setText("" + x);
    }
  }
}
