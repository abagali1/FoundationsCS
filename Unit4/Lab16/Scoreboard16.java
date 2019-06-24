import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
@SuppressWarnings("serial")
/**
 * Scoreboard16 keeps track of the current color and the amount of wins and losses during
 * a game of Mastermind
 * @author Anup Bagali
 * @version 1.1
 *
 */
public class Scoreboard16 extends JPanel{
   private static JButton showCol;
   private JLabel w,l, p;
   private int wins=0;
   private int losses=0;
   private int games=0;
   private DecimalFormat d= new DecimalFormat("0.00%");
   
   /*
    * Creates a new Scoreboard
    * @param a ActionListener which displays the current color whenever it changes
    */
   public Scoreboard16(ActionListener a){
      setLayout(new FlowLayout());
      
      add(new JLabel("Current Color: "));
      showCol = new JButton();
      showCol.setEnabled(true);
      showCol.addActionListener(a);
      showCol.setBackground(Color.red);
      add(showCol);
      
      w = new JLabel("Wins: " + wins);
      add(w);
      
      l = new JLabel(" | Losses: " + losses);
      add(l);
      
      p = new JLabel(" | %: ---");
      add(p);
   }
   /*
    * Sets the JButton's, which displays the current color, background to the new color
    * @param c desired color
    */
   public void setColor(Color c){
      showCol.setBackground(c);
   }
   /*
    * Changes the Scoreboard whenever the user wins a game of Mastermind and records the new win
    */
   public void winner(){
      wins++;
      games++;
      w.setText("Wins: " + wins);
      p.setText(" | %: " + d.format(wins/(double)games));
   }
   /*
    * Changes the Scoreboard whenever the user loses a game of Mastermind and records the new loss
    */
   public void loser(){
      losses++;
      games++;
      l.setText(" | Losses: " + losses);
      p.setText(" | %: " + d.format(wins/(double)games));
   }
}