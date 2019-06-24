import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class Driver02
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Hello Button");
      frame.setSize(400, 120);
      frame.setLocation(200, 100);
      frame.setDefaultCloseOperation(3);
      frame.setContentPane(new Panel02());
      frame.setVisible(true);
   }
}
class Panel02 extends JPanel{
   private JLabel label;
   private double starter = Math.random();
   public Panel02(){
      setLayout(new FlowLayout());
   
   
      JButton rand = new JButton("Random");
      rand.addActionListener(new Random());
      add(rand);
      
      JButton cube = new JButton("Cube");
      cube.addActionListener(new Cuber());
      add(cube);
      
      
      JButton reci = new JButton("Reciprocal");
      reci.addActionListener(new Recipro());
      add(reci);
      
      JButton exit = new JButton("Quit");
      exit.addActionListener(new Exiter());
      add(exit);
      
      
   
      label = new JLabel(""+starter);
      label.setFont(new Font("Serif", Font.BOLD, 20));
      label.setForeground(Color.BLUE);
      add(label);
   }
   private class Cuber implements ActionListener{
      public void actionPerformed(ActionEvent e){
         double x = Double.parseDouble(label.getText());
         double y = Math.pow(x, (1.0/3.0));
         label.setText(""+y);
         
      }
   }
   private class Random implements ActionListener{
      public void actionPerformed(ActionEvent e){
         label.setText(""+(Math.random()));
      }
   }
   private class Recipro implements ActionListener{
      public void actionPerformed(ActionEvent e){
         double x = Double.parseDouble(label.getText());
         label.setText(""+(1/x));
      }
   }
   private class Exiter implements ActionListener{
      public void actionPerformed(ActionEvent e){
         System.exit(0);
      }
   }
}