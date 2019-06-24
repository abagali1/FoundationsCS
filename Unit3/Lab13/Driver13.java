//name:    date:

import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;
public class Driver13
{
   public static int first;
   public static int second;
   public static void main(String[] args)
   {
   
      while(true){
         try{
            first = Integer.parseInt(JOptionPane.showInputDialog("First Digit"));
            if(first < 0)
               System.exit(0);
            second = Integer.parseInt(JOptionPane.showInputDialog("Second Digit"));
            
           if(first >= 10 || second >= 10){
             System.out.println("Nice Try, but I dont want my computer to explode ;)");
            }else{
               System.out.println("" + necklace(first, second));
            }
            
         }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please enter a number");
            continue;
         }
      }
         
   }
   public static ArrayList<Integer> necklace(int a, int b)
   {
      ArrayList<Integer> num = new ArrayList<Integer>();     
      int iterations = 0;
      a %= 10;
      b %= 10;
      num.add(a);
      num.add(b);
      do
      {
         int c = (a + b);
         if(c > 9)
            c %= 10;
         a = b;
         b = c;
         iterations++;
         num.add(c);
      } while ((a != first) || (b != second));
      return num;
   }
}