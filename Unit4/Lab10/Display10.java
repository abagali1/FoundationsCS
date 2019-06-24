   //Name______________________________ Date_____________
import javax.swing.*;
import java.awt.*;
public class Display10 extends JPanel
{
   private JLabel[] bits;
   private JLabel convert;
   public Display10()
   {
      setLayout(new GridLayout(1, 8));
      bits = new JLabel[8];
      for(int x = 0; x < bits.length; x++)
      {
         bits[x] = new JLabel("", SwingConstants.CENTER);
         bits[x].setFont(new Font("Serif", Font.BOLD, 50));
         add(bits[x]);
      }
      convert = new JLabel("");
      convert.setFont(new Font("Serif", Font.BOLD, 10));
      add(convert);
      randomize();
   }
   public void randomize()
   {
      for(JLabel b: bits)
         b.setText(""+(int)(Math.random()*2));
      convert();
   }
  
   public void reverse()
   {
      String[] temp = new String[bits.length];
      for (int i = 0; i < bits.length; i++) {
         temp[i] = bits[i].getText();
      }
      for (int i = 0; i < bits.length; i++) {
         bits[i].setText(temp[(bits.length - i - 1)]);
      }
      convert();
   }
  
   public void shift()
   {
      for (int x = 0; x < bits.length - 1; x++) {
         bits[x].setText(bits[(x + 1)].getText());
      }
      bits[(bits.length - 1)].setText("0");
      convert();
   }
  
   public void rotate()
   {
      String temp = bits[0].getText();
      for (int x = 0; x < bits.length - 1; x++) {
         bits[x].setText(bits[(x + 1)].getText());
      }
      bits[(bits.length - 1)].setText(temp);
      convert();
   }
   public void convert(){
      int[] digits = new int[bits.length];
      double sum =0;
      int place = 0;
      
      for(int i=0;i<=bits.length-1;i++)
         digits[i] = Integer.parseInt(bits[i].getText());
         
      for(int x=digits.length-1;x>=0;x--){
         if(digits[x]==1){
            sum += Math.pow(2,place);
         }
         place++;
      }
      convert.setText(""+sum);
   }     
}
