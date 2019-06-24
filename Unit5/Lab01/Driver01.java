import java.io.*;
import java.util.*;
public class Driver01
{
  public static void main(String[] args) throws Exception
  {
  ///*
    System.setOut(new PrintStream(new FileOutputStream("output.txt")));
    Scanner infile = new Scanner(new File("../Lab00/data.txt"));
    double[] myArray = new double[infile.nextInt()];
    
    for(int i=0;i<=myArray.length-1;i++)
      myArray[i] = infile.nextDouble();
    //  */
    //double[] myArray = {2.0, 3.7, 9.9, 8.1, 8.5, 7.4, 1.0, 6.2};
    for (int k = 0; k < myArray.length; k++)
    {
      int max = 0;
      for (int j = 1; j < myArray.length - k; j++) {
        if (myArray[j] > myArray[max]) {
          max = j;
        }
      }
      double temp = myArray[(myArray.length - k - 1)];
      myArray[(myArray.length - k - 1)] = myArray[max];
      myArray[max] = temp;
    }
    for (int k = 0; k < myArray.length; k++) {
      System.out.println(myArray[k]);
    }
  }
}
