 //name:    date:  

import java.io.*;      //the File class
import java.util.*;    //the Scanner class
import javax.swing.JOptionPane;
import java.util.Arrays;
public class Driver04
{
   public static void main(String[] args) 
   {
      Scanner infile = null;
      int tries = 0;
      
      double sum = 0;
      double avg = 0;
      double min = 0;
      double max = 0;
      while(tries<3){
         try{
            String filename = JOptionPane.showInputDialog("Enter Filename");
            if(filename.contains(".txt")){
              infile = new Scanner( new File(filename) );
            }else{
               infile = new Scanner( new File(filename+".txt") );
            }
            
            final int NUMITEMS = infile.nextInt();
            double[] arr = new double[NUMITEMS];
            
            for(int x=0; x<NUMITEMS; x++)
               arr[x] = infile.nextDouble();
            
            infile.close();
            Arrays.sort(arr);
            
            for(double i: arr)
               sum += i;     
            
            avg = (sum/NUMITEMS);
            min = arr[0];
            max = arr[arr.length-1];
            
            System.out.println("Sum: " + sum);
            System.out.println("Avg: " + avg);
            System.out.println("Min: " + min);
            System.out.println("Max: " + max);
            
            tries = 9999;
         
         }catch(FileNotFoundException e){
            
            JOptionPane.showMessageDialog(null, "Invalid Filename");
            tries += 1;
            continue;
         }
      }
      if(tries == 3){
         System.out.println("Your stupid");
         System.out.println("^Get it?");
      }
   
   }
}
/************************************
Sum: 3291074.1965423366
Avg: 504.3791872095535
Min: 0.027375512843708094
Max: 999.9780398236477

*************************************/