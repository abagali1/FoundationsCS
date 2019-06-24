   //Name:    Date:

import javax.swing.*;
import java.awt.*;
public class Display11 extends JPanel
{
   private JLabel[] output;
   private int[] bits;
   public Display11()
   {
      setLayout(new GridLayout(1, 8));
      
      output = new JLabel[8];
      bits = new int[8];
      for(int x = 0; x <= 7; x++)
      {
         output[x] = new JLabel("", SwingConstants.CENTER);
         output[x].setFont(new Font("Serif", Font.BOLD, 50));
         add(output[x]);
      }
      setBlank();
   }
   public void setBlank()
   {    
      for(JLabel o: output)
         o.setText("-"); 
        
   }
   public void setValue(int num)
   {
      for (int x = 7; x >= 0; x--)
      {
         output[x].setText("" + num % 2);
         num /= 2;
      }
   }
}