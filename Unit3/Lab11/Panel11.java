import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Panel11 extends JPanel
{
   private Display11 display;
   private Scoreboard11 scoreboard;
   
   public Panel11()
   {
      setLayout(new BorderLayout());
    
      scoreboard = new Scoreboard11();
      add(scoreboard, BorderLayout.NORTH);
    
      display = new Display11();
      add(display, BorderLayout.CENTER);
    
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout());
      add(panel, BorderLayout.SOUTH);
      addButton(panel, "One", 1);
      addButton(panel, "Two", 2);
      addButton(panel, "THree", 3);
   }
   private void addButton(JPanel panel, String s, int x)
   {
      JButton button = new JButton(s);
      button.addActionListener(new Listener(x));
      panel.add(button);
   }
   
   private class Listener implements ActionListener{
      
      private int myX;
      
      public Listener(int x){
         myX = x;
      }
      
      public void actionPerformed(ActionEvent e){
        
         scoreboard.update(display.pickUp(myX) == 12);
      }   
   }
}
