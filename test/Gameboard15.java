//Name______________________________ Date_____________
  

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;
import java.util.ArrayList;
public class Gameboard15 extends JPanel
{
   private JButton[][] board;
   private String gamepiece;
   private Color color;
   private int count;
   private int[][] game;
   private Timer ai;
   private ArrayList<Integer> moves;
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
            board[x][y] = new JButton("absdlkj");
            board[x][y].setFont(new Font("Monospaced", Font.PLAIN, 20));
            board[x][y].setBackground(Color.white);
            board[x][y].setFocusPainted(false);
            board[x][y].addActionListener(a); // <---Add this one first!!!!!
            board[x][y].addActionListener(new Listener(x, y));
            add(board[x][y]);
            game[x][y] = 2;
         }
      ai = new Timer(10, new Mover(true));
      ai.start();
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
         board[myX][myY].setText(gamepiece);
         board[myX][myY].setBackground(color);
         board[myX][myY].setFont(new Font("Serif", 1, 40));
         board[myX][myY].setEnabled(false);
         if ("X".equals(gamepiece))
         {
            gamepiece = "O";
            color = Color.blue;
            game[myX][myY] = 1;
            count++;
            
         }  
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
   public int gameState(int[][] arr){
      if(((arr[0][0]==1)&&(arr[0][1]==1)&&(arr[0][2]==1)) || ((arr[1][0]==1)&&(arr[1][1]==1)&&(arr[1][2]==1)) || ((arr[2][0]==1)&&(arr[2][1]==1)&&(arr[2][2]==1)) || ((arr[0][0]==1)&&(arr[1][0]==1)&&(arr[2][0]==1)) || ((arr[0][1]==1)&&(arr[1][1]==1)&&(arr[2][1]==1)) || ((arr[0][2]==1)&&(arr[1][2]==1)&&(arr[2][2]==1)) || ((arr[0][0]==1)&&(arr[1][1]==1)&&(arr[2][2]==1)) || ((arr[0][2]==1)&&(arr[1][1]==1)&&(arr[2][0]==1))/*O*/|| ((arr[0][0]==0)&&(arr[0][1]==0)&&(arr[0][2]==0)) || ((arr[1][0]==0)&&(arr[1][1]==0)&&(arr[1][2]==0)) || ((arr[2][0]==0)&&(arr[2][1]==0)&&(arr[2][2]==0)) || ((arr[0][0]==0)&&(arr[1][0]==0)&&(arr[2][0]==0)) || ((arr[0][1]==0)&&(arr[1][1]==0)&&(arr[2][1]==0)) || ((arr[0][2]==0)&&(arr[1][2]==0)&&(arr[2][2]==0)) || ((arr[0][0]==0)&&(arr[1][1]==0)&&(arr[2][2]==0)) || ((arr[0][2]==0)&&(arr[1][1]==0)&&(arr[2][0]==0)))
         return 10;
      else if(filled())
         return 0;
      else
         return -10;
         
   }
   public boolean terminalState(){
      return filled() || (gameState(game) == 10 || gameState(game) == -10);
   }
      
   public int[][] getGame(){
      return game;
   }
   private class Mover implements ActionListener{
      private boolean go;
      
      public Mover(boolean a){
         go = a;
      }
      
      public void actionPerformed(ActionEvent e){
         int[][] arr = getGame();
         int x = 0;
         int y=0;
         int acount = 0;
         int[] aiMove = new int[2];
         while(go && gamepiece.equals("O") && color == Color.blue){
            if(count<2){               
               do{
                  x = Stuff.random(0,2);
                  y = Stuff.random(0,2);
               }while(game[x][y] != 0);
               
               board[x][y].setText(gamepiece);
               board[x][y].setBackground(color);
               board[x][y].setFont(new Font("Serif", 1, 40));
               board[x][y].setEnabled(false);
               count++; 
               game[x][y] = 0;
               gamepiece = "X";
               color = Color.green;
               go = false;
            }else{ 
               aiMove = findBestMove(game);
               x = aiMove[0];
               y = aiMove[1];
               board[x][y].setText(gamepiece);
               board[x][y].setBackground(color);
               board[x][y].setFont(new Font("Serif", 1, 40));
               board[x][y].setEnabled(false);
               count++; 
               game[x][y] = 0;
               gamepiece = "X";
               color = Color.green;
               go = false;
            }
         }
      }
   }   
   
   public int minimax(int[][] gameBoard, int length, boolean isMax){
      int bestVal;
      int val;
      int count;
      moves = new ArrayList<Integer>();
      for(int i=0;i<=gameBoard.length-1;i++){
         for(int j=0;j<=gameBoard[0].length-1;j++){
            if(gameBoard[i][j]==2)
               moves.add(gameBoard[i][j]);
            
         }
      }
      if(terminalState()){
         return ((gameState(gameBoard)));
      }
      if(isMax){
         bestVal = -10000;
         for(int i: moves){
            val = minimax(gameBoard, length+1, false);
            bestVal = Math.max(bestVal, val);
         }
         return bestVal;
      }else{
         bestVal = 100000;
         for(int i: moves){
            val = minimax(gameBoard, length+1, true);
            bestVal = Math.min(bestVal, val);
         }
         return bestVal;
      }
   }
   public int[] findBestMove(int[][] gBoard){
      int bestMove = -1000;
      int[] move = new int[2];
      int moveVal;
      for(int i=0;i<=gBoard.length-1;i++){
         for(int j=0;j<=gBoard[0].length-1;j++){
            if(gBoard[i][j] == 2){
               gBoard[i][j] = 0;
               moveVal = minimax(gBoard, 0, false);
               gBoard[i][j] = 2;
               if(moveVal > bestMove){
                  move[0] = i;
                  move[1] = j;
                  bestMove = moveVal;
               }
            }
         }
      }
      return move; 
   }
}
    
