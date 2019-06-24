import java.util.Scanner;
import java.util.Arrays;
public class Driver01{

   public static final int NUM = 10;
   public static void main(String[] args){
      double[] arr = new double[NUM];
      double sum = 0;
      double avg, min, max;
      Scanner key = new Scanner(System.in);
      for(int x=0;x<NUM;x++){
         System.out.print("#" + (x+1) + ":  ");
         arr[x] = key.nextDouble();
      }
      for(double i:arr)
         sum += i;       
      avg = sum/NUM;
      Arrays.sort(arr);
      min = arr[0]; max = arr[NUM-1];
      System.out.println("Sum: " + sum);
      System.out.println("Avg: " + avg);
      System.out.println("Min: " + min);
      System.out.println("Max: " + max);
   }
}