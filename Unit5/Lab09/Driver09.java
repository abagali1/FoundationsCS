	//Name______________________________ Date_____________
  
import java.io.*;             //the File class
import java.util.*;   		   //the Scanner class
import javax.swing.*;         //the JOptionPane class
import java.util.Arrays;
public class Driver09
{
   public static void main(String[] args) throws Exception
   {
      String[] array = input("data.txt");
      for(int k = 0; k < array.length; k++)
         array[k] = convert(array[k]);
      Arrays.sort(array);              //why don't you have to implement sort()?
      output(array, "output.txt");
   }
   	
   public static String[] input(String filename)
   {
      Scanner infile = null;
      try{
         infile = new Scanner(new File(filename));
      }
      catch(FileNotFoundException e)
      {
         JOptionPane.showMessageDialog(null,"The file could not be found.");
         System.exit(0);
      }
      int numitems = infile.nextInt();
      String[] array = new String[numitems];
      for(int k = 0; k < numitems; k++)
      {
         array[k] = infile.next();
      }
      infile.close();
      return array;
   }
   	
   public static String convert(String website)
   {
      String packageName = "";
      website = website.substring(4);
      int pos;
         
      while (website.contains("."))
      {
         pos = website.lastIndexOf(".");
         String pie = website.substring(pos + 1);
         packageName = packageName + pie + ".";
         website = website.substring(0, pos);
      }
      packageName = packageName + website;
         
      return packageName;
   }
   	
   public static void output(Object[] array, String filename)
   {
      PrintStream outfile = null;
      try{
         outfile = new PrintStream(new FileOutputStream(filename));
      }
      catch(FileNotFoundException e)
      {
         JOptionPane.showMessageDialog(null,"The file could not be created.");
      } 
      for(int k = 0; k < array.length; k++)
         outfile.println(array[k]);
   }
   
}