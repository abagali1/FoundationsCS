   //Name______________________________ Date_____________
import java.io.*;      //the File class
import java.util.*;    //the Scanner class
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
   
public class Driver03
{
   public static int NUMITEMS = 0;
   public static void main(String[] args) throws Exception
   {
      String filename = JOptionPane.showInputDialog("Filename: ");
      //double[] array = new double[NUMITEMS];	
      Scanner infile = new Scanner(new File(filename));
      LineNumberReader count = new LineNumberReader(new FileReader(filename));
      //DecimalFormat d = new DecimalFormat("0.0");
      
      while(count.skip(Long.MAX_VALUE)>0){
         NUMITEMS = count.getLineNumber()+1;
      }
      double[] array = new double[NUMITEMS];
      int counta = 0;
      while(counta<NUMITEMS){
         array[counta] = infile.nextDouble();
         counta++;
      }
         
      infile.close();
      double[] celsius = new double[NUMITEMS];
      for(int a=0;a<=array.length-1;a++)
         celsius[a] = (array[a]-32)*(5/9.0);
      System.out.println("Fahrenheit\t| Celsius");
      System.out.println("----------------------");
          
      for(int a=0;a<=array.length-1;a++)
         System.out.println((array[a])+"\t|"+(celsius[a]));
   }
}
   
	/************************************
	Fahrenheit      | Celsius
	----------------|-------------------
	5.0             | -15.0
	10.0            | -12.222222222222221
	15.0            | -9.444444444444445
	20.0            | -6.666666666666667
	25.0            | -3.888888888888889
	26.0            | -3.3333333333333335
	28.0            | -2.2222222222222223
	31.0            | -0.5555555555555556
	37.0            | 2.7777777777777777
	45.0            | 7.222222222222222
	48.0            | 8.88888888888889
	51.0            | 10.555555555555555
	75.0            | 23.88888888888889
	98.6            | 37.0
	212.0           | 100.0
	451.0           | 232.77777777777777
	32.0            | 0.0
	0.0             | -17.77777777777778
	9.29            | -12.616666666666667
	19.77           | -6.794444444444445

	END OF EXECUTION, press any key:
	*************************************/