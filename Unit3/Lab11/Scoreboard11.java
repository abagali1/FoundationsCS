import javax.swing.*;
import java.awt.*;
public class Scoreboard11 extends JPanel
{
   private JLabel label1, label2, one, two;
   private int count1, count2 = 0;
   private int currentPlay = 1;
   
   public Scoreboard11(){
     
      setLayout(new GridLayout(1, 5));
       
      one = new JLabel("One: ", SwingConstants.RIGHT);
      one.setOpaque(true);
      one.setBackground(Color.yellow);
      add(one);
      
      label1 = new JLabel(""+count1);
      label1.setHorizontalAlignment(SwingConstants.LEFT);
      label1.setOpaque(true);
      label1.setBackground(Color.yellow);
      add(label1);
      
      add(new JLabel("Nim", SwingConstants.CENTER));
      
      
      two = new JLabel("Two: ", SwingConstants.RIGHT);
      two.setOpaque(true);
      add(two);
      
      label2 = new JLabel(""+ count2);
      label2.setHorizontalAlignment(SwingConstants.LEFT);
      label2.setOpaque(true);
      add(label2);
   }
   public void turn(){
      if (currentPlay == 1)
      {
         currentPlay = 2;
         one.setBackground(Color.gray);
         label1.setBackground(Color.gray);
         two.setBackground(Color.yellow);
         label2.setBackground(Color.yellow);
      }
      else
      {
         currentPlay = 1;
         two.setBackground(Color.gray);
         label2.setBackground(Color.gray);
         one.setBackground(Color.yellow);
         label1.setBackground(Color.yellow);
      }
   }
   public void isWin(){
      
      switch(currentPlay){
         case 1:
            count1++;
            label1.setText(""+count1);
         case 2:
            count2++;
            label2.setText(""+count2);
      }
   }
   public void update(boolean arg){
      if(arg){
         isWin();
      }else{
         turn();
      }
   }
}