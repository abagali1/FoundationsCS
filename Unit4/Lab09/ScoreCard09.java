//Name______________________________ Date_____________
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
public class ScoreCard09 extends JPanel
{
   private JTextField[] input;
   public ScoreCard09()
   {
      setLayout(new GridLayout(2, 18));
   
      for(int x = 1; x <= 18; x++)
      {
         add(new JLabel("" + x, SwingConstants.CENTER));
      }
   
      input = new JTextField[18];
      for(int x = 0; x < input.length; x++)
      {
         input[x] = new JTextField();
         add(input[x]);
      }
   }
   public void randomize()
   {
      for(JTextField i: input)
         i.setText(""+((int)(1+Math.random()*4)));
   }
   public int findTotal()
   {
      int sum =0;
      for(JTextField i: input)
         sum += Integer.parseInt(i.getText());
      return sum;
   }
   public int findAces()
   {
      int count = 0;
      for(JTextField i: input){
         if(Integer.parseInt(i.getText()) == 1){
            count++;
         }
      }
      return count;
   }
   public int findHardestHole()
   {
      int hole = 0;
      for(JTextField i: input){
         if(Integer.parseInt(i.getText()) == 4){
            hole = (int)(Arrays.asList(input).indexOf(i)+1);
            break;
         }
      }
      return hole;
   }
}