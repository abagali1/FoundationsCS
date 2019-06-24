import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Display11 extends JPanel{
   
   private JLabel label;
   private int total;
   
   public Display11(){
      
      setLayout(new GridLayout(1, 1));
      total = 12;
    
      label = new JLabel(new ImageIcon(new ImageIcon("stones12.gif").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
      label.setHorizontalAlignment(0);
      add(label);
   }
   
   public int pickUp(int x){
      total -= x;
      if(total <= 0)
         total = 12;
      
      ImageIcon imageIcon = new ImageIcon(new ImageIcon("stones" + total + ".gif").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
      label.setIcon(imageIcon);      
      return total;      
   }
}