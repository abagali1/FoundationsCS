//Name______________________________ Date_____________
import javax.swing.*;
import java.awt.*;
public class Scoreboard10 extends JPanel
{
   private JLabel label1, label2, label3;
   private int run, max;
   public Scoreboard10()
   {
      setLayout(new GridLayout(1, 5));
      run = max = 0;
   
      add(new JLabel("Run: ", SwingConstants.RIGHT));
      label1 = new JLabel(""+run);
      label1.setHorizontalAlignment(SwingConstants.LEFT);
      add(label1);
      
      label2 = new JLabel("---");
      label2.setHorizontalAlignment(SwingConstants.CENTER);
      label2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
      add(label2);
      
      add(new JLabel("Max: ", SwingConstants.RIGHT));
      label3 = new JLabel(""+max);
      label3.setHorizontalAlignment(SwingConstants.LEFT);
      add(label3);
   }
   public void update(boolean arg) //if arg is true, the player guessed correctly
   {
      if(arg){
         label2.setText("Yes");
         run++;
         
         if(run>max)
            max = run;
      
      }else{
         
         label2.setText("--No--");
         run = 0;
      }
      
      label1.setText(""+run);
      label3.setText(""+max);
   
   }
}