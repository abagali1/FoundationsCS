   //Name:                 Date:
   import java.util.Scanner;
   import java.text.DecimalFormat;
    public class Driver02
   {
      public static final int NUMITEMS = 15;
       public static void main(String[] args)
      {
         double[] arr = new double[NUMITEMS];
         Scanner key = new Scanner(System.in);
         DecimalFormat d = new DecimalFormat("0.0");
         
         for(int x=0;x<=NUMITEMS-6;x++){
            System.out.print("#" + (x+1) + " - Degrees Farenheit: ");
            arr[x] = key.nextDouble();
          }
        for(int a=10;a<=14;a++)
            arr[a] = Math.random()*1000;
        
          double[] celsius = new double[NUMITEMS];
          
          for(int y=0;y<=arr.length-1;y++)
            celsius[y] = (arr[y]-32)*(5/9.0);
          
          System.out.println("Fahrenheit\t| Celsius");
          System.out.println("----------------------");
          
          for(int a=0;a<=arr.length-1;a++)
            System.out.println(d.format(arr[a])+"\t|"+d.format(celsius[a]));
            
      }
   }