import javax.swing.*;
import java.awt.*;
public class DisplaySampleYard extends JPanel{
   
   private Yard[] yards;
   private int index = 0;
   private JTextField lname, fname, size, cost, total;

   public DisplaySampleYard(Yard[] arr){
      
      setLayout(new GridLayout(5,2));
      add(new JLabel("Last Name: "));
      
      lname = new JTextField();
      lname.setEnabled(false);
      add(lname);
      
      add(new JLabel("First Name: "));
      
      fname = new JTextField();
      fname.setEnabled(false);
      add(fname);
      
      add(new JLabel("Lawn Size: "));
      
      size = new JTextField();
      size.setEnabled(false);
      size.setHorizontalAlignment(SwingConstants.RIGHT);
      add(size);
      
      add(new JLabel("Total Cost: "));
      
      cost = new JTextField();
      cost.setEnabled(false);
      add(cost);
      
      add(new JLabel("Running Total: "));
      
      total = new JTextField();
      total.setEnabled(false);
      add(total);
      
      yards = arr;
   
   }
   
   public void next(int atotal){
      
      lname.setText(yards[index].getLastName());
      fname.setText(yards[index].getFirstName());
      size.setText("" + yards[index].getSize());
      cost.setText("" + yards[index].getCost());
      total.setText("" + atotal);
      index++;
   
   }
   
}