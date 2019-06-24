	//Name______________________________ Date_____________
import javax.swing.*;
import java.awt.*;
public class Dice extends JPanel
{
   private JLabel label1, label2;
   public Dice()
   {
      setLayout(new GridLayout(1, 2, 5, 5));
      
      label1 = new JLabel();
      label1.setIcon(new ImageIcon("one.jpg"));
      add(label1);
      
      label2 = new JLabel();
      label2.setIcon(new ImageIcon("one.jpg"));
      add(label2);
   }
   public int roll()
   {
      int a = rollOne(label1);
      int b = rollOne(label2);
      return a + b;
   }
   private int rollOne(JLabel label)
   {
      int x = (int)(Math.random() * 6.0D + 1.0D);
      switch (x)
      {
         case 1: 
            label.setIcon(new ImageIcon("one.jpg"));
            break;
         case 2: 
            label.setIcon(new ImageIcon("two.jpg"));
            break;
         case 3: 
            label.setIcon(new ImageIcon("three.jpg"));
            break;
         case 4: 
            label.setIcon(new ImageIcon("four.jpg"));
            break;
         case 5: 
            label.setIcon(new ImageIcon("five.jpg"));
            break;
         case 6: 
            label.setIcon(new ImageIcon("six.jpg"));
            break;
      }
      return x;
   }
}
