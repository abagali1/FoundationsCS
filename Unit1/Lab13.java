/// DO NOT TOUCH///
import edu.fcps.karel2.Robot;
import edu.fcps.karel2.Display;
import javax.swing.JOptionPane;

public class Lab13{
   
   public static void gameLoop(){
      int user_input;
      String a;
      int game = 0; 
      int[] crossX= {2,5,9,2,5,9,2,5,9}; // defines the x-coordinates for the "x"s     
      int[] crossY= {10,10,10,6,6,6,3,3,3}; //defines y-coordinates for the "x"s
      int[] circleX= {2,5,9,2,5,9,2,5,9}; //defines the x-coordinates for "o"s
      int[] circleY= {10,10,10,7,7,7,3,3,3};//defines the y-coordinates for "o"s
      boolean[] possible_moves = {true,true,true,true,true,true,true,true,true}; //games computer from choosing invalid moves
      int[] board = {0,0,0,0,0,0,0,0,0}; //used in determining terminating situation
      int[] displayboard = {0,0,0,0,0,0,0,0,0};//used in determining where to display the "x" or "o" 
     
      JOptionPane.showMessageDialog(null, "To choose your option, type the number corresponding to your tile. You are X, and computer is O.");
      JOptionPane.showMessageDialog(null, "Make sure to run the jar file in jGRASP");
     
      while(game != 1){
         try{
            a = JOptionPane.showInputDialog("Enter number from 0 to 8:");
            user_input = Integer.parseInt(a);

            if(possible_moves[user_input] == false){
               JOptionPane.showMessageDialog(null,"This move is already taken");
               continue;
            }
         
            board[user_input] += 1; //user moves are represented with a 1
            displayboard[user_input] += 1;
         
            possible_moves[user_input] = false;
         
            int comp_choice = (int) (Math.random() *8 + 1);
         
            while(possible_moves[comp_choice]==false){ //randomly chooses an open spot
               comp_choice = (int)(Math.random() *7 +1);
            }
         
            possible_moves[comp_choice]=false;
         
            board[comp_choice] -=1;// computer moves are represented with a -1
            displayboard[comp_choice] -= 1;
         
            if(board[0] == 1 && board[1] == 1 && board[2] == 1){
               displayCross(displayboard,crossX,crossY);
               JOptionPane.showMessageDialog(null,"You win!");
               game++;
            }
            else if(board[0] == -1 && board[1] == -1 && board[2] == -1){
            
               displayCircle(displayboard,circleX,circleY);
               JOptionPane.showMessageDialog(null,"Computer wins");            
               game++;
            }
            else if(board[3] == 1 && board[4] == 1 && board[5] ==1){
               displayCross(displayboard,crossX,crossY);
               JOptionPane.showMessageDialog(null,"You win!");
               game++;
            }
            else if(board[3]== -1 && board[4] == -1 && board[5] == -10){
            
               displayCircle(displayboard,circleX,circleY);
               JOptionPane.showMessageDialog(null,"Computer wins");            
               game++;
            }
            else if(board[6] == 1 && board[7] == 1 && board[8]==1){
               displayCross(displayboard,crossX,crossY);
               JOptionPane.showMessageDialog(null,"You win!");
               game++;
            }
            else if(board[6] == -1 && board[7] == -1 && board[8] == -1){
            
               displayCircle(displayboard,circleX,circleY);
               JOptionPane.showMessageDialog(null,"Computer wins");            
               game++;
            }
            else if(board[0] == 1 && board[3] == 1 && board[6] ==1){
               displayCross(displayboard,crossX,crossY);
               JOptionPane.showMessageDialog(null,"You win!");
               game++;
            }
            else if(board[0] == -1 && board[3] == -1 && board[6] == -1){
            
               displayCircle(displayboard,circleX,circleY);
               JOptionPane.showMessageDialog(null,"Computer wins");            
               game++;
            }
            else if(board[1] == 1 && board[4] == 1 && board[7] == 1){
               displayCross(displayboard,crossX,crossY);
               JOptionPane.showMessageDialog(null,"You win!");
               game++;
            }
            else if(board[1] == -1 && board[4] == -1 && board[7] == -1){
            
               displayCircle(displayboard,circleX,circleY);
               JOptionPane.showMessageDialog(null,"Computer wins");            
               game++;
            }
            else if (board[2] == 1 && board[5] == 1 && board[8] == 1){
               displayCross(displayboard,crossX,crossY);
               JOptionPane.showMessageDialog(null,"You win!");
               game++;
            }
            else if(board[2] == -1 && board[5] == -1 && board[8] == -1){
               displayCircle(displayboard,circleX,circleY);
               JOptionPane.showMessageDialog(null,"Computer wins");
               game++;
            }
            else if(board[0] == 1 && board[4]==1 && board[8]==1){
               displayCross(displayboard,crossX,crossY);
               JOptionPane.showMessageDialog(null,"You win!");
               game++;
            }
            else if(board[0] == -1 && board[4]== -1 && board[8] == -1){
            
               displayCircle(displayboard,circleX,circleY);
               JOptionPane.showMessageDialog(null,"Computer wins");            
               game++;
            }
            else if(board[2] == 1 && board[4]==1 && board[6]==1){
               displayCross(displayboard,crossX,crossY);
               JOptionPane.showMessageDialog(null,"You win!");
               game++;
            }
            else if(board[2] == -1 && board[4] == -1 && board[6] == -1){
            
               displayCircle(displayboard,circleX,circleY);
               JOptionPane.showMessageDialog(null,"Computer wins");            
               game++;
            }   
            if(testTie(board)){
               for(int m=0; m <9; m++){
                  new Circle(circleX[m],circleY[m]).tacMove();
                  new Cross(crossX[m], crossY[m]).tacMove();
               }
               System.out.println("Tie!");
               game++;
            }   
            if(game == 0){
               for(int i =0; i < 9; i++){
                  if(displayboard[i]==1){
                     new Cross(crossX[i],crossY[i]).tacMove();//displays "x"s
                     displayboard[i]--;
                     continue;
                  }
               } 
               for(int j=0;j < 9; j++){
                  if(displayboard[j]== -1){
                     new Circle(circleX[j], circleY[j]).tacMove(); //displays "o"s
                     displayboard[j]+=1;
                  
                  }
               }
            }          
         }          
         catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please enter a number");
            continue;            
         } 
         catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Please enter a number");
            continue;
         } 
         catch(ArrayIndexOutOfBoundsException e){JOptionPane.showMessageDialog(null, "Choice has to be between 0-8");
            continue;
         }
         
      }
   }
 
   public static void displayCross(int[] a, int[] b, int[] c){
      for(int i =0; i < 9; i++){
         if(a[i]==1){
            displayer d = new Cross(b[i],c[i]);
            d.tacMove();
            continue;
         }
      } 
   }
   
   public static void displayCircle(int[] board, int[] x, int[] y){
      for(int j = 0; j < 9; j++){
         if(board[j]==-1){
            displayer b = new Circle(x[j],y[j]);
            b.tacMove();   //displays "o"s
            continue;
         }
      }
   }
   public static boolean testTie(int[] board){
      for(int k =0; k<9; k++){
         if((board[k] == 0)){
            return false;
         }
      }
      return true;
   } 
   
   public static void main(String [] args){
      Display.openWorld("maps/tictac.map");
      Display.setSpeed(10);
      JOptionPane.showMessageDialog(null, "Welcome to Tic Tac Toe!");
      System.out.println("  0   |   1      |   2  ");
      System.out.println("------------------------");
      System.out.println("  3   |   4      |   5  ");
      System.out.println("------------------------");
      System.out.println("  6   |   7      |   8  ");
      gameLoop();
      System.exit(69);
   }
}