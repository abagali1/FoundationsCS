   //Torbert, e-mail: mr@torbert.com, website: www.mr.torbert.com
	//version 7.14.2003

   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
    public class Panel10 extends JPanel
   {
      Display10 display;
       public Panel10()
      {
         setLayout(new BorderLayout());
      
         display = new Display10();
         add(display, BorderLayout.CENTER);
      
         JPanel panel = new JPanel();
         panel.setLayout(new FlowLayout());
         add(panel, BorderLayout.SOUTH);
      
         JButton button1 = new JButton("Randomize");
         button1.addActionListener(new Listener1());
         panel.add(button1);
      
         JButton button2 = new JButton("Reverse");
         button2.addActionListener(new Listener2());
         panel.add(button2);
      
         JButton button3 = new JButton("Shift");
         button3.addActionListener(new Listener3());
         panel.add(button3);
      
         JButton button4 = new JButton("Rotate");
         button4.addActionListener(new Listener4());
         panel.add(button4);
      }
       private class Listener1 implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            display.randomize();
         }
      }
       private class Listener2 implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            display.reverse();
         }
      }
       private class Listener3 implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            display.shift(); //your code goes here;
         }
      }
       private class Listener4 implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
             display.rotate();
         }
      }
   }