public class Stuff{
   public static void print(Object o){
      System.out.println(""+o);
   }
   public static void printA2D(Object[] o){
      System.out.println(java.util.Arrays.deepToString(o));
   }
   public static int random(int lowest, int highest){
      return (int)(Math.random() * (highest-lowest + 1) + lowest);
   }
   public static double random(double lowest, double highest){
      return (Math.random() * (highest-lowest+1) + lowest);
   }
   public static int random(int highest){
      return (int)(Math.random() * (highest - 0 + 1) + 0);
   }
   public static double random(double highest){
      return (Math.random() * (highest - 0 + 1) + 0);
   }
   public static void main(String[] args){
      Gameboard15 g = new Gameboard15(null);
      printA2D(g.getGame());
      print(java.util.Arrays.toString(g.findBestMove(g.getGame())));
      
    
   }
      
        
}