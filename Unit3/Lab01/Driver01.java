import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class Driver01
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Hello Button");
      frame.setSize(200, 120);
      frame.setLocation(200, 100);
      frame.setDefaultCloseOperation(3);
      frame.setContentPane(new Panel01());
      frame.setVisible(true);
   }
}
class Panel01 extends JPanel{
   private JLabel label;
   private JTextField box;
   public Panel01(){
      setLayout(new FlowLayout());
         
      box = new JTextField("0.0", 10);
      box.setHorizontalAlignment(SwingConstants.RIGHT);
      add(box);
      
      JButton button = new JButton("SQRT");
      button.addActionListener(new Listener());
      add(button);
      
      label = new JLabel("0.0");
      label.setFont(new Font("Serif", Font.BOLD, 20));
      label.setForeground(Color.BLUE);
      add(label);
   }
   private class Listener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         double num = Double.parseDouble(box.getText());
         if(num< 0){
            num = Math.abs(num);
            double nsqrt = Math.sqrt(num);
            label.setText(""+nsqrt+"i");
         }else{
            double sqrt = Math.sqrt(num);
            label.setText(""+sqrt);
         }
      }
   }
}