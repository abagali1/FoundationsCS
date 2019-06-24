import java.awt.*;

public class AiBumper extends Bumper implements Runnable{
   public AiBumper(){
      super();
   }
   public AiBumper(int x, int y, int w, int h, Color c){
      super(x,y,w,h,c);
   }
   public void run(){
      int distance = (int)Math.random() * 400;
      int direction = (int) Math.random() * 2;
         
         if(direction == 0){
            int counter = (int)distance;
            while(direction == 0){
               if(getX() <= 0){
                  direction = 1;
               }
               while(counter > 0){
                  setX(getX()-40);
                  counter -= 40;
                  if(getX() <= 0){
                     direction = 1;
                  }
                  if(counter <= 0 ){//&& getX() > 0){
                     direction = 1;// counter = distance;
                  }
               }
            }
         }
         if(direction == 1){
            int rcounter = distance;
            while(direction ==1){
               if((getX()+100) >= 400){
                  direction = 0;
               }
               while(rcounter > 0){
                  setX(getX()+40);
                  rcounter-=40;
                  if(getX() >= 400){
                     direction = 0;
                  }
                  if(rcounter <= 0 ){//&& getX() < 400){
                     direction = 0;// rcounter=distance;
                  }
               }
            }
         }
      }
   }

