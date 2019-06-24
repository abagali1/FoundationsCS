//Name______________________________ Date_____________
  

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;
public class Gameboard15 extends JPanel
{
   private JButton[][] board;
   private String gamepiece;
   private Color color;
   private int count;
   public int[][] game;
   private int score;
   public Gameboard15(ActionListener a)
   {
      gamepiece = "X";
      color = Color.green;
      count = 0;
   
      setLayout(new GridLayout(3, 3));
      setBackground(Color.black);
   
      board = new JButton[3][3];
      game = new int[3][3];
      for(int x = 0; x < 3; x++)
         for(int y = 0; y < 3; y++)
         {
            board[x][y] = new JButton("-");
            board[x][y].setFont(new Font("Monospaced", Font.PLAIN, 20));
            board[x][y].setBackground(Color.white);
            board[x][y].setFocusPainted(false);
            board[x][y].addActionListener(a); // <---Add this one first!!!!!
            board[x][y].addActionListener(new Listener(x, y));
            add(board[x][y]);
            game[x][y] = 2;
         }
   }
   private class Listener implements ActionListener
   {
      private int myX, myY;
      public Listener(int x, int y)
      {
         myX = x;
         myY = y;
      }
      public void actionPerformed(ActionEvent e)
      {
         if ("X".equals(gamepiece))
         {
            board[myX][myY].setText(gamepiece);
            board[myX][myY].setBackground(color);
            board[myX][myY].setFont(new Font("Serif", 1, 40));
            board[myX][myY].setEnabled(false);
            gamepiece = "O";
            color = Color.blue;
            game[myX][myY] = 1;
            count++;
            if(!winner())
               placeMove();/**/
         }/*else{
            board[myX][myY].setText(gamepiece);
            board[myX][myY].setBackground(color);
            board[myX][myY].setFont(new Font("Serif", 1, 40));
            board[myX][myY].setEnabled(false);
            gamepiece = "X";
            color = Color.green;
            game[myX][myY] = 0;
            count++;
         }*/
      }
   }
   public void freeze()
   {
      for(int x=0;x<=board.length-1;x++){
         for(int y=0;y<=board[0].length-1;y++){
            board[x][y].setEnabled(false);
         }
      }
   }
   public void reset()
   {
      for(int x=0;x<=board.length-1;x++){
         for(int y=0;y<=board[0].length-1;y++){
            board[x][y].setText("-");
            board[x][y].setBackground(Color.white);
            board[x][y].setFont(new Font("Monospaced", 0, 20));
            board[x][y].setBackground(Color.white);
            board[x][y].setFocusPainted(false);
            board[x][y].setEnabled(true);
            game[x][y]=2;
            
         }
      }
      count =0;
   }
   public boolean filled()
   {
      return count==9;
   }
   public boolean winner()
   {
      return(((game[0][0]==1)&&(game[0][1]==1)&&(game[0][2]==1)) || ((game[1][0]==1)&&(game[1][1]==1)&&(game[1][2]==1)) || ((game[2][0]==1)&&(game[2][1]==1)&&(game[2][2]==1)) || ((game[0][0]==1)&&(game[1][0]==1)&&(game[2][0]==1)) || ((game[0][1]==1)&&(game[1][1]==1)&&(game[2][1]==1)) || ((game[0][2]==1)&&(game[1][2]==1)&&(game[2][2]==1)) || ((game[0][0]==1)&&(game[1][1]==1)&&(game[2][2]==1)) || ((game[0][2]==1)&&(game[1][1]==1)&&(game[2][0]==1))/*O*/|| ((game[0][0]==0)&&(game[0][1]==0)&&(game[0][2]==0)) || ((game[1][0]==0)&&(game[1][1]==0)&&(game[1][2]==0)) || ((game[2][0]==0)&&(game[2][1]==0)&&(game[2][2]==0)) || ((game[0][0]==0)&&(game[1][0]==0)&&(game[2][0]==0)) || ((game[0][1]==0)&&(game[1][1]==0)&&(game[2][1]==0)) || ((game[0][2]==0)&&(game[1][2]==0)&&(game[2][2]==0)) || ((game[0][0]==0)&&(game[1][1]==0)&&(game[2][2]==0)) || ((game[0][2]==0)&&(game[1][1]==0)&&(game[2][0]==0)));
   }
   
   public int getCount(){
      return count;
   }
   public int gameState(int[][] b){
      for(int r=0;r<3;r++){
         if(b[r][0]==b[r][1] && b[r][1]==b[r][2]){
            if(b[r][0]==1)
               return 10;
            else if(b[r][0]==0)
               return -10;
         }
      }
      for(int c=0;c<3;c++){
         if(b[0][c]==b[1][c] && b[1][c]==b[2][c]){
            if(b[0][c]==1)
               return 10;
            else if(b[0][c]==0)
               return -10;
         }
      }
      if(b[0][0]==b[1][1] && b[1][1]==b[2][2]){
         if(b[0][0]==1)
            return 10;
         else if(b[0][0]==0)
            return -10;
      }
      if(b[0][2]==b[1][1] && b[1][1]==b[2][0]){
         if(b[0][2]==1)
            return 10;
         else if(b[0][2]==0)
            return -10;
      }
      
      return 0;
   }
   public boolean movesLeft(int[][] a){
      for(int i=0;i<3;i++)
         for(int j=0;j<3;j++){
            if(a[i][j]==2)
               return true;
         }
      return false;
   }
   public int[][] getGame(){
      return game;
   }
   public int minimax(int[][] gameBoard, int length, boolean isMax){
      int score = gameState(gameBoard);
      if(score==10)
         return score-length;
      if(score == -10)
         return score+length;
      if(!movesLeft(gameBoard))
         return 0;
         
      if(isMax){
         int best = Integer.MIN_VALUE;
         
         for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
               if(gameBoard[i][j] == 2){
                  gameBoard[i][j] = 1;
                  /*
                  if(length>=1)
                     return best;
                      */
                  best = Math.max(best, minimax(gameBoard,length+1,!isMax));
                  gameBoard[i][j] = 2;
               }
            }
         }
         
         return best;
         
      }else{
         int best = Integer.MAX_VALUE;
         
         for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
               if(gameBoard[i][j] == 2){
                  gameBoard[i][j] = 0;
                  /*
                  if(length>=1)
                     return best;
                    */
                  best = Math.min(best, minimax(gameBoard, length+1,!isMax));
                  gameBoard[i][j] = 2;
               }
            }
         }
         
         return best;
      }
      
   }
   public int[] findBestMove(int[][] gBoard){
      int bestVal = Integer.MIN_VALUE;
      if(!movesLeft(gBoard))
         return null;
      int[] bestMove = new int[2];
      bestMove[0] = -1;
      bestMove[1] = -1;
      for(int i=0;i<3;i++){
         for(int j=0;j<3;j++){
            if(gBoard[i][j] == 2){
               gBoard[i][j] = 1;
               int moveVal = minimax(gBoard, 0, false);
               gBoard[i][j] = 2;
               if(moveVal>bestVal){
                  bestMove[0] = i;
                  bestMove[1] = j;
                  bestVal = moveVal;
               }
            }
         }
      }
      if(bestMove[0] == -1)
         return null;
      else
         return bestMove;
   }
   public void placeMove(){
      int r;
      int c;
      int[] rc = new int[2];
      rc = findBestMove(game);
      if(rc == null){
         r = 0;
         c = 0;
         count = 9;
      }else{
         r = rc[0];
         c = rc[1];
      }
      board[r][c].setText(gamepiece);
      board[r][c].setBackground(color);
      board[r][c].setFont(new Font("Serif", 1, 40));
      board[r][c].setEnabled(false);
      gamepiece = "X";
      color = Color.green;
      game[r][c] = 0;
      count++;
      
   }
}
    
