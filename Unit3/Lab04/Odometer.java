	//Name______________________________ Date_____________
import javax.swing.*;
import java.awt.*;
public class Odometer extends JPanel
{
   private JLabel ones, tens, hundreds;
   private int count = 0;
   private Font f = new Font("Serif", 1, 30);

   public Odometer()
   {
      setLayout(new FlowLayout());
      setBackground(Color.black);
   
    
      ones = new JLabel("0");
      ones.setFont(f);
      ones.setForeground(Color.white);
      add(ones);
    
      tens = new JLabel("0");
      tens.setFont(f);
      tens.setForeground(Color.white);
      add(tens);
    
      hundreds = new JLabel("0");
      hundreds.setFont(f);
      hundreds.setForeground(Color.black);
      hundreds.setBackground(Color.white);
      hundreds.setOpaque(true);
      add(hundreds);   
   }
   public void update()
   {
      count++;
      hundreds.setText(""+count % 10);
      tens.setText(""+(count % 100) /10);
      ones.setText(""+((count % 1000)/100));
   }
}