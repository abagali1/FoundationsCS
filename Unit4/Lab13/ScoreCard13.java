//Name______________________________ Date_____________
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
public class ScoreCard13 extends JPanel
{
   private JTextField[][] input;
   public ScoreCard13()
   {
      setLayout(new GridLayout(5, 18));
   
      for(int hole = 1; hole <= 18; hole++)
      {
         add(new JLabel("" + hole, SwingConstants.CENTER));
      }
   
      input = new JTextField[4][18];
      for(int r = 0; r < input.length; r++)
         for(int c = 0; c < input[0].length; c++)
         {
            input[r][c] = new JTextField();
            add(input[r][c]);
         }
   }
   public void randomize()
   {
      for(int r = 0; r < input.length; r++)
         for(int c = 0; c < input[0].length; c++)
         {
            input[r][c].setText(""+((int)(1+Math.random()*4)));
         }
   }
   
   public int findTotal(int r)
   {
      int sum =0;
      for(JTextField i: input[r])
         sum += Integer.parseInt(i.getText());
      return sum;
               
   }
   public int findAces(int r)
   {
      int count =0;
      for(JTextField i: input[r]){
         if((i.getText()).equals("1")){
            count++;
         }
      }
      return count;
      
   }
   public int findHardestHole(int r)
   {
      int hole = 0;
      for(JTextField i: input[r]){
         if(Integer.parseInt(i.getText()) == 4){
            hole = (int)(Arrays.asList(input[r]).indexOf(i)+1);
            break;
         }
      }
      return hole;
   }
   public int findHardestHole(){
      int hole = 0;
      int max = 0;
      for (int c = 0; c < input[0].length; c++)
      {
         int vert = 0;
         for (int r = 0; r < input.length; r++) {
            vert += Integer.parseInt(input[r][c].getText());
         }
         if (vert > max)
         {
            hole = c;
            max = vert;
         }
      }
      return hole + 1;
   }

}