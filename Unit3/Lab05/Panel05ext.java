//Name______________________________ Date_____________
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Panel05ext extends JPanel
{
   private Display05 display;
   private JButton starter;
   private Timer t;
   public Panel05ext()
   {
      setLayout(new FlowLayout());
   
      display = new Display05();
      add(display);
   
      JButton button = new JButton("Press Your Luck");
      button.addActionListener(new Listener());
      add(button);
      
      t = new Timer(500, new Listener2());
      
      starter = new JButton("Run Repeatedly");
      starter.addActionListener(new Listener1());
      add(starter);
   }
   private class Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         display.update();
      
      
      
      }
   }
   private class Listener1 implements ActionListener{
      public void actionPerformed(ActionEvent e){
         if(t.isRunning()){
            starter.setText("Start Again");
            t.stop();
         }else{
            starter.setText("Pause Run");
            t.start();
         }
      }
   }
   private class Listener2 implements ActionListener{
      public void actionPerformed(ActionEvent e){
         display.update();
         repaint();
      }
   }
      
}
