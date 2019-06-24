import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
public class Scoreboard14 extends JPanel
{
   private JLabel w, c, l;
   private double win = 0;
   private int cstreak = 0;
   private int lstreak = 0;
   private int torpedoes = 20;
   private double game = 0;
   private double percent = 0.0;
   private DecimalFormat d;

   public Scoreboard14(){
      setLayout(new FlowLayout());
      d = new DecimalFormat("0.00%");
      w = new JLabel("Wins: " + win + "/" + game + "(" + d.format(percent) + ")");
      add(w);
   
      c = new JLabel("Torpedoes: " + torpedoes);
      add(c);
   
      l = new JLabel("Longest Streak: " + lstreak);
      add(l);
   
   }
   public void win(){
      win++;
      game++;
      cstreak++;
      percent = win/game;
      if(cstreak>lstreak)
         lstreak = cstreak;
      w.setText("Wins: " + win + "/" + game + "(" + d.format(percent) + ")");
      c.setText("You Win!");
      l.setText("Longest Streak: " + lstreak);
      torpedoes = 20;
   }
   public void loss(){
      game++;
      cstreak = 0;
      percent = win/game;
      w.setText("Wins: " + win + "/" + game + "(" + d.format(percent) + ")");
      c.setText("You Lose!");
      l.setText("Longest Streak: " + lstreak);
      torpedoes = 20;
   }
   public void toggleH(){
      torpedoes--;
      c.setText("Hit! Torpedoes: " + torpedoes);
      
   }  
   public void toggleM(){
      torpedoes--;
      c.setText("Miss! Torpedoes: " + torpedoes);
   }
   public void freeze(JButton[][] arr){
      for(int i =0; i<=arr.length-1;i++){
         for(int j=0;j<=arr[0].length-1;j++){
            arr[i][j].setEnabled(false);
         }
      }
   }
}   
