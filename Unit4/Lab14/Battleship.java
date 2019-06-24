//Name______________________________ Date_____________
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Battleship extends JPanel
{
   private JButton[][] board;
   private boolean[][] matrix;
   private int hits, torpedoes;
   private Scoreboard14 score;
   private JLabel label;
   private JButton reset;
   private int isWin = 0;
   public Battleship()
   {
      setLayout(new BorderLayout());
      hits = 0;
      torpedoes = 20;
   
      JPanel north = new JPanel();
      north.setLayout(new FlowLayout());
      add(north, BorderLayout.NORTH);
      
      score = new Scoreboard14();
      north.add(score);
      
      //label = new JLabel("Welcome to Battleship -- You have 20 torpedoes.");
      //north.add(label);
   
      JPanel center = new JPanel();
      center.setLayout(new GridLayout(10,10));
      add(center, BorderLayout.CENTER);
   
      board = new JButton[10][10];
      matrix = new boolean[10][10];
      for(int r = 0; r < 10; r++)
         for(int c = 0; c < 10; c++)
         {
            board[r][c] = new JButton();
            board[r][c].setBackground(Color.blue);
            board[r][c].addActionListener( new Handler1(r, c) );
            center.add(board[r][c]);
         }
   
      reset = new JButton("Reset");
      reset.addActionListener( new Handler2() );
      reset.setEnabled(false);
      add(reset, BorderLayout.SOUTH);
   
      placeShip();
   }
   private void placeShip()
   {
      int rowOrCol = (int)(Math.random()*2+1);
      if(rowOrCol == 1){
         int row = (int)(Math.random()*7);
         int col = (int)(Math.random()*10);
         for(int x=0;x<=3;x++)
            matrix[(row+x)][col]=true;
      }else{
         int row = (int)(Math.random()*10);
         int col = (int)(Math.random()*7);
         for(int x=0;x<=3;x++)
            matrix[row][(col+x)] =true;
      }
   }
   private class Handler1 implements ActionListener
   {
      private int myRow, myCol;
      public Handler1(int r, int c)
      {
         myRow = r;
         myCol = c;
      }
      public void actionPerformed(ActionEvent e)
      {
         
         if(torpedoes > 0){
            if(matrix[myRow][myCol] == true){
               board[myRow][myCol].setBackground(Color.red);
               torpedoes--;
               score.toggleH();
               board[myRow][myCol].setEnabled(false);
               isWin++;
            }else{
               board[myRow][myCol].setBackground(Color.white);
               torpedoes--;
               score.toggleM();
               board[myRow][myCol].setEnabled(false);
            }
         }
         if(isWin == 4){
            score.win();;
            torpedoes = 0;
            freeze();
            reset.setEnabled(true);
         }else if(isWin!=4 && torpedoes ==0){
            for(int x=0;x<=matrix.length-1;x++){
               for(int y=0;y<=matrix[0].length-1;y++){
                  if(matrix[x][y] == true){
                     board[x][y].setBackground(Color.black);
                  }
               }
            }
            torpedoes = 0;
            score.loss();
            freeze();
            reset.setEnabled(true);
         }
            
      }
   }
   private class Handler2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         for(int x=0;x<=board.length-1;x++){
            for(int y=0;y<=board[0].length-1;y++){
               board[x][y].setBackground(Color.blue);
               matrix[x][y] = false;
               board[x][y].setEnabled(true);
            }
         }
         isWin = 0;
         torpedoes = 20;
         placeShip();
         reset.setEnabled(false);
      }
   }
   public void freeze(){
      for(int i =0; i<=board.length-1;i++){
         for(int j=0;j<=board[0].length-1;j++){
            board[i][j].setEnabled(false);
         }
      }
   }
}