import java.awt.*;
public class AiBumper extends Bumper{
 
   public AiBumper(){
      super();
   }
   public AiBumper(int x, int y, int w, int h, Color c){
      super(x,y,w,h,c);
   }
   public int distance(){
      return (int)(Math.random()+ 100)*400;
   }
   public int dir(){
      return (int)Math.random()*2;
   }

   public int difficulty(int setting){
      switch(setting){
         case 1:
            return 113;
         case 3:
            return 40;
      }
      return 40;
            
   }
   public void play(Ball b,int a){
      setX((int)b.getX() - difficulty(a));
      if(getX() <= 0)
         setX(0);
   ///**** WORK IN PROGRESS ****\\\
   /*int ldis = distance();
   int rdis = distance();
   int direction = dir();
      if(direction == 0){
         if(direction == 0){
            if(getX()<= 0){
               rdis = distance();
               setX(getX() +1);
               rdis --;
            }
            else if(ldis <= 0){
               rdis = distance();
               setX(getX() + 1);
               rdis--;
            }
            else if(rdis <= 0){
               ldis = distance();
               setX(getX() - 1);
               ldis--;
               }
            else if(getX() >= 400){
               ldis = distance();
               setX(getX() -1);
               ldis--;
            }
            else{
               setX(getX() - 1);
               ldis --;
               
            }
         }
      }*/
      /*if(direction == 1){
         if(direction == 1){
            if(getX() >= 400){
               direction = 0;
               ldis = distance();
            }else if(rdis <= 0){
               direction = 0;
               ldis = distance();
            }
            else{
               setX(getX() + 1);
               rdis ++;
            }
         }*/
   }
}

     /*int distance = (int)(Math.random()+900) * 900;
      int direction = (int)Math.random() * 2;
      if(direction == 0){
         if(direction == 0){
            if(getX()<= 0){
               direction = 1;
               distance = (int)(Math.random() + 900) * 900;
            }
            else if(distance <= 0){
               direction = 1;
               distance = (int)(Math.random() + 900) * 900;
                  
            }
            else{
               setX(getX() - 4);
               distance -= 4;
               
            }
         }
      }
      if(direction == 1){
         if(direction == 1){
            if(getX() >= 400){
               direction = 0;
               distance = (int)(Math.random() + 900) * 900;
            }else if(distance <= 0){
               direction = 0;
               distance =(int)(Math.random() + 900) * 900;
            }
            else{
               setX(getX() + 4);
               distance -= 4;
            }
         }
      }*/