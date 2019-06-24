   //Name______________________________ Date_____________
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Panel08 extends JPanel
{
   private Display08 display;
   public Panel08()
   {
      setLayout(new BorderLayout());
    
      display = new Display08();
      add(display, BorderLayout.CENTER);
    
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout());
      add(panel, BorderLayout.SOUTH);
    
      JButton button1 = new JButton("Finite");
      button1.addActionListener(new Listener1());
      panel.add(button1);
    
      JButton button2 = new JButton("Infinite");
      button2.addActionListener(new Listener2());
      panel.add(button2);
   
      
   }
   private class Listener1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         
            display.sumFinite();
         
      }
   }
   private class Listener2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         
            display.sumInfinite();
         
      }
   }
}