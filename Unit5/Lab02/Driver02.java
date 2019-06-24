	//Name______________________________ Date_____________
import java.io.*;
import java.util.*;
public class Driver02
{
   public static void main(String[] args) throws Exception
   {
      double[] array = input("../Lab00/data.txt");
      sort(array);
      output(array, "output.txt");
   }
   public static double[] input(String filename) throws Exception
   {
      Scanner infile = new Scanner(new File("../Lab00/data.txt"));
      double[] temp = new double[infile.nextInt()];
    
      for(int i=0;i<=temp.length-1;i++)
         temp[i] = infile.nextDouble();
      return temp;
         
   }
   public static void sort(double[] array)
   {
      int maxPos;
      for(int k = 0; k < array.length; k++)
      {
         maxPos = findMax(array, array.length - k - 1);
         swap(array, maxPos, array.length - k - 1);
      }
   }
   public static int findMax(double[] array, int upper) //what does "upper" do???
   {
      {
         int maxPos = 0;
         for (int j = 1; j <= upper; j++) {
            if (array[j] > array[maxPos]) {
               maxPos = j;
            }
         }
         return maxPos;
      }
   }
   public static void swap(double[] array, int a, int b)//what are "a" and "b" for???
   {
      double temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }
   public static void output(double[] array, String filename) throws Exception
   {
      System.setOut(new PrintStream(new FileOutputStream(filename)));
      for(int k = 0; k < array.length; k++)
         System.out.println(array[k]);
   }
}