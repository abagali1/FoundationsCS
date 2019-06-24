import edu.fcps.karel2.*;
public class LabYY{
   public static void main(String [] args){
      final int N = (int)(Math.random()*50+25);
      Display.setSize(N,N);
      Display.setSpeed(10);
      WorldBackend.getCurrent().putBeepers(
               (int)(Math.random()*N+1), (int)(Math.random()*N+1),1);
      int found = 0;
      Athlete[] array = new Athlete[N];
      Thread threadArray[] = new Thread[N];
      for(int index = 0; index <N; index++){
        Athlete a = new Athlete(1,index+1,Display.EAST,0);
        a.setN(N);
        Thread temp = new Thread(a);
        
        temp.start();
         
      }
   
         
   }
}