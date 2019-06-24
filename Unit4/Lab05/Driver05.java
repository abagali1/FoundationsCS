//Name:    Date:
public class Driver05{
   public static int TRIALS = 0;
   public static void main(String[] args){
      Dice d = new Dice();
      // Experiment  1
      int count = 0;
      do
      {
         d.roll();
         count = count + 1;
      }while(d.total() != 12);
      System.out.println("It took " + count + " rolls to get boxcars.");
   
   
      // Experiment  2
      count = 0;
      do{
         d.roll();
         count++;
      }while(!d.doubles());
      System.out.println("It took " + count +" rolls to get doubles: " + d.toString());
      
      
               
      // Experiment  3
      int[] freq = new int[13];
      count = 0;
      for(int x: freq)
         x = 0;
         
      do{
         d.roll();
         freq[d.total()] += 1;
         if(d.doubles())
            count++;
         TRIALS++;
      }while(TRIALS != 100);
      for(int y = 2; y<=freq.length-1;y++)
         System.out.println("" + y + "'s: "+ freq[y]);
      System.out.println("Number of doubles in 100 rolls: " + count);
   }
}
/******
 It took 35 rolls to get boxcars.
 It took 4 rolls to get doubles: {1, 1}
 2's:  6
 3's:  6
 4's:  5
 5's:  10
 6's:  12
 7's:  20
 8's:  17
 9's:  6
 10's:  10
 11's:  4
 12's:  4
 Number of doubles in 100 rolls: 18
 ********/