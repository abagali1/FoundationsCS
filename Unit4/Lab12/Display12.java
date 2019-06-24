import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Display12
  extends JPanel
{
  private JButton[] button;
  
  public Display12(ActionListener a)
  {
    setLayout(new GridLayout(5, 5, 5, 5));
    
    this.button = new JButton[25];
    for (int x = 0; x < 25; x++)
    {
      this.button[x] = new JButton("" + (x + 1));
      this.button[x].addActionListener(a);
      this.button[x].setHorizontalAlignment(0);
      this.button[x].setFont(new Font("Serif", 1, 20));
      this.button[x].setBackground(Color.yellow);
      add(this.button[x]);
    }
  }
  
  public void reset()
  {
    for (int x = 0; x < 25; x++)
    {
      this.button[x].setText("" + (x + 1));
      this.button[x].setEnabled(true);
      this.button[x].setBackground(Color.yellow);
    }
  }
  
  public void displayWinner(int target)
  {
    this.button[(target - 1)].setBackground(Color.green);
    for (int x = 0; x < 25; x++) {
      this.button[x].setEnabled(false);
    }
  }
  
  public void displayLoser(int target)
  {
    for (int x = 0; x < 25; x++)
    {
      this.button[x].setEnabled(false);
      if (x + 1 != target)
      {
        this.button[x].setText("");
        this.button[x].setBackground(Color.red);
      }
      else
      {
        this.button[x].setBackground(Color.black);
      }
    }
  }
  
  public void displayTooHigh(int guess)
  {
    for (int x = guess - 1; x < 25; x++)
    {
      this.button[x].setEnabled(false);
      this.button[x].setBackground(Color.red);
      this.button[x].setText("");
    }
  }
  
  public void displayTooLow(int guess)
  {
    for (int x = 0; x < guess; x++)
    {
      this.button[x].setEnabled(false);
      this.button[x].setBackground(Color.red);
      this.button[x].setText("");
    }
  }
}
