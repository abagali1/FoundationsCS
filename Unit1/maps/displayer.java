import edu.fcps.karel2.Robot; 
import edu.fcps.karel2.Display;

public abstract class displayer extends Athlete{
public displayer (){
         super();
         }

  public displayer (int x, int y){
         super(x,y,1,5000);
         }

   public abstract void tacMove();
   
   }