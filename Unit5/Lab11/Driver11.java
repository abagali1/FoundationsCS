//Name______________________________ Date_____________
 
import javax.swing.JOptionPane;
public class Driver11
{
   public static int power(int base, int exp)  //do not use Math.pow
   {

      return (exp == 1) ? base: base*power(base,exp-1);
   }
   public static int factorial(int n)
   {
     return (n == 0) ?  1: n*factorial(n-1);
   }
   public static int fib(int n)
   {
      return ((n == 1) || (n==2)) ? 1: fib(n-1) + fib(n-2);
   }
  
   
   public static int gcd(int a, int b)
   {
      
      return (a % b ==0) ? b: gcd(a,a%b);
   }
   public static void main(String[] args)
   {
      int choice = 0, a, b;
      while(choice != 6)
      {
         String message = "";
         message = message + "\n1. Find powers.";
         message = message + "\n2. Find factorials.";
         message = message + "\n3. Find Fibonacci numbers.";
         message = message + "\n4. Find a greatest common divisor (GCD).";
         message = message + "\n5. Quit.";
         choice = Integer.parseInt(JOptionPane.showInputDialog(message));
         switch(choice)
         {
            case 1: 
               a = Integer.parseInt(JOptionPane.showInputDialog("Enter base:"));
               b = Integer.parseInt(JOptionPane.showInputDialog("Enter exponent:"));
               JOptionPane.showMessageDialog(null, 
                                    a + "^" + b + " = " + power(a, b));
               break;
            case 2: 
               a = Integer.parseInt(JOptionPane.showInputDialog("Enter n:"));
               JOptionPane.showMessageDialog(null, 
                                    "factorial(" + a + ") = " + factorial(a) );
               break;
            case 3: 
               a = Integer.parseInt(JOptionPane.showInputDialog("Enter n:"));
               JOptionPane.showMessageDialog(null, 
                                    "fib(" + a + ") = " + fib(a) );
               break;
            case 4: 
               a = Integer.parseInt(JOptionPane.showInputDialog("First number:"));
               b = Integer.parseInt(JOptionPane.showInputDialog("Second number:"));
               JOptionPane.showMessageDialog(null, 
                                    "gcd(" + a + ", " + b + ") = " + gcd(a, b));
               break;
            case 5: 
               JOptionPane.showMessageDialog(null, "Bye-bye!");
               System.exit(0);
            default: 
               JOptionPane.showMessageDialog(null, "Not a valid selection.");
               continue;
         }
      }
      System.exit(0);
   }
 
}