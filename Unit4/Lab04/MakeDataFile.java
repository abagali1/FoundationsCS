   //Torbert, e-mail: mr@torbert.com, website: www.mr.torbert.com
	//version 7.14.2003

   import java.io.*;
   import java.text.DecimalFormat;
   public class MakeDataFile
   {
      public static void main(String[] args) throws Exception
      {  DecimalFormat d = new DecimalFormat("0.0");
         PrintStream outfile = new PrintStream(
                           new FileOutputStream("data3.txt")
                           );
      
         int numitems = 20;//(int)(Math.random() * 5000 + 5000);
         //outfile.println(numitems);
      
         for(int x = 0; x < numitems; x++)
            outfile.println(d.format(Math.random() * 1000));
      
         outfile.close();
      }
   }