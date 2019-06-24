   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   public class AssortPanel extends JPanel
   {
      private PongPanel pong;
      public AssortPanel()
      {
         setLayout(new FlowLayout());
      
         pong = new PongPanel();
      
         JButton Pong = new JButton("Pong");
         Pong.addActionListener(new Listener());
         add(Pong);
      }
      private class Listener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            add(pong);
            pong.playGame();

         
         
         }
      }
   }