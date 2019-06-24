import edu.fcps.karel2.Robot;
import edu.fcps.karel2.Display;
import edu.fcps.Digit;
import javax.swing.JOptionPane;
import java.util.*;

public class fact{

   public static String factorial(double n){
      double i;
      double fact=1;  
      double number=n;    
      for(i=1;i<=number;i++){    
         fact=fact*i;   
      }
      
      int a = (int)fact;
      String ans = Integer.toString(a);
   
      return ans;
   }
   public static int recursionFact(double n){
      
      if(n ==1){
         return 1;
      }else{
         return (int)(n*recursionFact(n-1)); 

      }
   }
   public static void show(int[] arr){
      int x = 1;
      for(int i =0; i < arr.length; i++){
         if (arr[i] == 1){
            new One(x,9).display();
            x += 6;
         }
         else if(arr[i] == 2){
            new Two(x,9).display();
            x += 6;
         }
         else if (arr[i] == 3){
            new Three(x,9).display();
            x += 6;
         }
         else if (arr[i] == 4){
            new Four(x,9).display();
            x +=6;
         }
         else if(arr[i] == 5){
            new Five(x,9).display();
            x += 6;
         }
         else if(arr [i] == 6){
            new Six(x,9).display();
            x += 6;
         }
         else if(arr[i] == 7){
            new Seven(x,9).display();
            x += 6;
         }
         else if(arr[i] == 8){
            new Eight(x,9).display();
            x +=  6;
         }
         else if(arr[i] == 9){
            new Nine(x,9).display();
            x += 6;
         } 
         else if(arr[i] == 0){
            new Zero(x,9).display();
            x += 6;
         }
      }
   }
   public static void main(String [] args){  
   
      JOptionPane.showMessageDialog(null, "Make sure to enlarge the map after entering value!!");
      String a = JOptionPane.showInputDialog("N=?");
      Display.setSize(150,90);
      Display.setSpeed(10);
      String ans;
      int num = Integer.parseInt(a);
      if(num<11254){
          ans = Integer.toString(recursionFact(num));
      }else{
          ans = factorial(num);
      }
   
      int[] arr = new int[ans.length()];
      for (int i = 0; i < ans.length(); i++)
      {
         arr[i] = ans.charAt(i) - '0';
      }
       
      show(arr);
   
   
   
   
   
   
   }
}