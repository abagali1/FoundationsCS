   //Name:     Date:

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Panel11 extends JPanel
{
   private JTextField box;
   private JLabel label;
   private Display11 display;
   private JButton button2;
   public Panel11()
   {
      setLayout(new BorderLayout());
      
      JPanel north = new JPanel();
      north.setLayout(new FlowLayout());
      add(north, BorderLayout.NORTH);
      north.add(new JLabel("Enter an integer from 0 to 255:"));
      box = new JTextField(5);
      north.add(box);
    
      display = new Display11();
      add(display, "Center");
    
      JPanel south = new JPanel();
      south.setLayout(new FlowLayout());
      add(south, BorderLayout.SOUTH);
      JButton button1 = new JButton("Convert");
      button1.addActionListener(new Listener1());
      south.add(button1);
      button2 = new JButton("Step");
      button2.addActionListener(new Listener2());
      south.add(button2);
      button2.setEnabled(false);
      label = new JLabel("");
      south.add(label);
   }
   private class Listener1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         button2.setEnabled(false);
         int x;
         try
         {
            x = Integer.parseInt(box.getText());
         }
         catch(NumberFormatException f)
         {
            label.setText("That's not a number!");
            display.setBlank();
            return;
         }
         if( x > 255 || x < 0 )
         {
            label.setText("Number must be from 0 to 255.");
            display.setBlank();
            return;
         }
         label.setText("");
         display.setValue(x);
         button2.setEnabled(true);
      }
   }
   private class Listener2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         int i = Integer.parseInt(box.getText());
         i += 1;
         if (i == 256) 
            i = 0;
         
         box.setText("" + i);
         label.setText("");
         display.setValue(i);
      }
   }
}