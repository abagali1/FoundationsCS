import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javafx.util.*;
import java.util.Arrays;
public class Gameboard16 extends JPanel{
   private Color currentColor;
   private int rowCount, colCount;
   private Color[] pattern;
   private JButton[][] board;
   private JButton[][] marker;
   private Color[] colors;
   private Color background = this.getBackground();
   private int whitepegs, blackpegs, markersRowCount;
   public Gameboard16(){
      setLayout(new BorderLayout());
      
      rowCount=7; colCount=0;
      colors = new Color[6];
      colors[0] = Color.red; colors[1] = Color.green; colors[2] = Color.blue; colors[3] = Color.yellow; colors[4] = Color.orange; colors[5] = Panel16.pink;
      pattern = new Color[4];
      generatePattern();
      board = new JButton[8][4]; 
      marker = new JButton[16][2];
      
      JPanel gameboard = new JPanel();
      gameboard.setLayout(new GridLayout(8,4));
      add(gameboard,BorderLayout.CENTER);
      
      
      
      for(int i=0;i<=board.length-1;i++){
         gameboard.add(new JLabel("                   "));
         for(int j=0; j<=board[0].length-1;j++){
            board[i][j] = new JButton();
            board[i][j].addActionListener(new Listener(i,j));
            board[i][j].setBackground(Color.gray);
            board[i][j].setEnabled(false);
            board[i][j].setOpaque(true);
            gameboard.add(board[i][j]);
         }
      }
      
      JPanel markers = new JPanel();
      markers.setLayout(new GridLayout(16,2));
      add(markers,BorderLayout.EAST);
      
      for(int r=0;r<=marker.length-1;r++){
         markers.add(new JLabel(""));
         for(int c=0;c<=marker[0].length-1;c++){
            marker[r][c] = new JButton();
            marker[r][c].setEnabled(false);
            marker[r][c].setOpaque(true);
            marker[r][c].setBackground(Color.gray.brighter());
            marker[r][c].setPreferredSize(new Dimension(15,15));
            markers.add(marker[r][c]);
         }
      }
      for(int c=0;c<=board[0].length-1;c++)
         board[7][c].setEnabled(true);
   }
   private class Listener implements ActionListener{
      private int myX, myY;
      public Listener(int x,int y){
         myX = x;
         myY = y;
      }
      public void actionPerformed(ActionEvent e){ 
         
         if(board[myX][myY].getBackground().equals(Color.gray))
            colCount++;
         
         board[myX][myY].setBackground(currentColor);
         
         if(colCount==4 && !winner() && rowCount!=0){
            for(int i=0;i<4;i++)
               board[rowCount][i].setEnabled(false);
            for(int i=0;i<4;i++)
               board[rowCount-1][i].setEnabled(true);
            checkDots();
            placePegs();
            rowCount--;
            colCount = 0;
         }else if(winner()){
            Stuff.print("WON");
            for(int i =0;i<=board.length-1;i++){
               for(int j=0 ;j<=board[0].length-1;j++){
                  board[i][j].setEnabled(false);
               }
            }
         }else if(!winner() && rowCount==0 && colCount==4){
            Stuff.print("LOS");
         } 
      }
   }
   public void setColor(Color c){
      currentColor = c;
   }
   public void reset(){
      colCount = 0;
      rowCount = 7;
      for(int r=0; r<=board.length-1;r++){
         for(int c=0; c<=board[0].length-1;c++){
            board[r][c].setBackground(background);
            board[r][c].setEnabled(false);
            board[r][c].setOpaque(true);
         }
      }
      for(int c=0;c<=board[0].length-1;c++)
         board[rowCount][c].setEnabled(true);
      generatePattern();
   }
   public void generatePattern(){
      for(int i=0;i<=pattern.length-1;i++){
         int count = (int)(Math.random() * (6));
         pattern[i] = colors[count];
         //pattern[i] = Color.red;
      }
      Stuff.print(java.util.Arrays.toString(pattern));   
   }
   public boolean winner(){
      Color[] check = new Color[4];
      for(int i=0;i<=3;i++)
         check[i] = board[rowCount][i].getBackground();
      return java.util.Arrays.equals(pattern, check);
         
   }
   public boolean loser(){
      return rowCount ==0 && colCount == 4 && !winner();
   }
   public boolean won(){
      return winner();
   }
   public void checkDots(){
      whitepegs = 0;
      blackpegs = 0;
      Color[] ans = new Color[4];
      ans[0] = board[rowCount][0].getBackground();
      ans[1] = board[rowCount][1].getBackground();
      ans[2] = board[rowCount][2].getBackground();
      ans[3] = board[rowCount][3].getBackground();
   
      for(int i = 0; i<4;i++){
         if(ans[i].equals(pattern[i]))
            blackpegs++;
      }
      for(int i=0;i<4;i++){
         if(Arrays.asList(pattern).contains(ans[i]) && !ans[i].equals(pattern[i]))
            whitepegs++;
      }
      Stuff.print(blackpegs);
      Stuff.print("--------");     
      Stuff.print(whitepegs);       
   }
   public void placePegs(){
      switch(rowCount){
         case 0:
            markersRowCount = 0;
            break;
         case 1:
            markersRowCount = 2;
            break;
         case 2:
            markersRowCount = 4;
            break;
         case 3:
            markersRowCount = 6;
            break;
         case 4:
            markersRowCount = 8;
            break;
         case 5:
            markersRowCount = 10;
            break;
         case 6:
            markersRowCount = 12;
            break;
         case 7:
            markersRowCount  = 14;
            break;
         default:
            Stuff.print("Its most probably Alex's fault");
            System.exit(0);
      }
      if(whitepegs == 4){
         for(int i = 0;i<2;i++)
            marker[markersRowCount][i].setBackground(Color.white);
         for(int i=0;i<2;i++)
            marker[markersRowCount+1][i].setBackground(Color.white);
      }
      else if(whitepegs == 3){
         for(int i=0;i<2;i++)
            marker[markersRowCount][i].setBackground(Color.white);
         marker[markersRowCount+1][0].setBackground(Color.white);
      }else if (whitepegs != 0){
         for(int i=0;i<2;i++)
            marker[markersRowCount][i].setBackground(Color.white);
      }
      if(blackpegs == 4){
         for(int i = 0;i<2;i++)
            marker[markersRowCount][i].setBackground(Color.black);
         for(int i=0;i<2;i++)
            marker[markersRowCount+1][i].setBackground(Color.black);
      }
      else if(blackpegs == 3){
         for(int i=0;i<2;i++)
            marker[markersRowCount][i].setBackground(Color.black);
         marker[markersRowCount+1][0].setBackground(Color.black);
      }else if(blackpegs != 0){
         for(int i=0;i<2;i++)
            marker[markersRowCount][i].setBackground(Color.black);
      }
            
      markersRowCount = Integer.MIN_VALUE;
      blackpegs = 0;
      whitepegs = 0;
   
   }
}