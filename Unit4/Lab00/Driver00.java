import java.util.Scanner;
public class Driver00{
   public static final int ITEMS = 10;
   public static void main(String[] args){
   
      double[] arr = new double[ITEMS];
      Scanner key = new Scanner(System.in);
      for(int x = 0; x<ITEMS;x++){
         System.out.print("#"+(x+1) + ":   ");
         arr[x] = key.nextDouble();
      }
      System.out.println("The numbers you typed in, backwards:");
      for(int x=0;x<ITEMS;x++){
         System.out.println("\t" + arr[ITEMS-x-1]);
      }
   }
}
