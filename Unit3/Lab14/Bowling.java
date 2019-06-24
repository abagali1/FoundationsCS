import javax.swing.JOptionPane;
public class Bowling
{
   public static void main(String[] args)
   {
      int frame = 1;
      int ball = 1;
      int pins1, pins2;
      int score = 0;
      JOptionPane.showMessageDialog(null, "Welcome to Bowling");
      for(int x=1; x<=10;x++){
         pins1 = Integer.parseInt(JOptionPane.showInputDialog("Score " + score +"\n Frame " + frame + " Ball " + ball));
         while(ball ==1){
            if(pins1 > 10 || pins1 < 0){
               JOptionPane.showMessageDialog(null, "Invalid Number!");
               pins1 = Integer.parseInt(JOptionPane.showInputDialog("Score " + score +"\n Frame " + frame + " Ball " + ball));
               continue;      
            }else{
               break;
            }   
         }
         if(pins1 == 10){
            score+=10;
            frame++;
            ball++;
         }else{
            score+= pins1;
            ball++;
         }
         while(ball==2){
            pins2 = Integer.parseInt(JOptionPane.showInputDialog("Score " + score +"\n Frame " + frame + " Ball " + ball));
            if(pins2 > 10 || pins2<0 || pins1+pins2 > 10){
               JOptionPane.showMessageDialog(null, "Invalid Number"); 
               continue;           
            }else{
               score += pins2;
               ball--;
               frame++;
            }
         
         }
      }
      
      
   }
}