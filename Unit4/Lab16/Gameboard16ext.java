import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;
@SuppressWarnings("serial")
public class Gameboard16ext extends JPanel{
   private Color currentColor;
   private int rowCount, colCount;
   private Color[] pattern;
   private JButton[][] board;
   private JButton[][] marker;
   private Color[] colors;
   private Color background;
   private RoundedBorder[][] borders;
   private int whitepegs, blackpegs, markersRowCount;
   public Gameboard16ext(){
      setLayout(new BorderLayout());
      
      rowCount=7; colCount=0;
      colors = new Color[8];
      colors[0] = Color.red; colors[1] = Color.green; colors[2] = Color.blue; colors[3] = Color.yellow; colors[4] = Color.orange; colors[5] = Panel16.pink; colors[6] = Color.cyan; colors[7] = Color.white;
      pattern = new Color[4];
      generatePattern();
      board = new JButton[8][4]; 
      marker = new JButton[16][2];
      borders = new RoundedBorder[8][4];
      
      JPanel fill = new JPanel();
      fill.setLayout(new FlowLayout());
      fill.setBackground(this.getBackground());
      add(fill, BorderLayout.EAST);
      
      JPanel gameboard = new JPanel();
      gameboard.setLayout(new GridLayout(8,4));
      gameboard.setBackground(new Color(13,156,242));
      background = gameboard.getBackground();
      add(gameboard,BorderLayout.CENTER);

      for(int i=0;i<=board.length-1;i++){
         //gameboard.add(new JLabel("                   "));
         for(int j=0; j<=board[0].length-1;j++){
            board[i][j] = new JButton();
            board[i][j].addActionListener(new Listener(i,j));
            board[i][j].setBackground(background);
            board[i][j].setEnabled(false);
            board[i][j].setOpaque(true);
            board[i][j].setBounds(50,50,30,25);
            borders[i][j] = new RoundedBorder(25,Color.black);
            board[i][j].setBorder(borders[i][j]);
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
         
         if(borders[myX][myY].getCol().equals(Color.gray))
            colCount++;

         borders[myX][myY].fillPeg(board[myX][myY], currentColor);
         //board[myX][myY].fillBackground(currentColor);
         
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
      this.revalidate();
      this.repaint();
   }
   public void reset(){
      colCount = 0;
      rowCount = 7;
      whitepegs = 0;
      blackpegs = 0;
      borders = new RoundedBorder[8][4];
      for(int i=0; i<=board.length-1;i++){
         for(int j=0; j<=board[0].length-1;j++){
            board[i][j].setBackground(background);
            borders[i][j] = new RoundedBorder(25, Color.black);
            board[i][j].setEnabled(false);
            board[i][j].setOpaque(true);
            board[i][j].setBounds(50,50,30,25);
            board[i][j].setBorder(borders[i][j]);
         }
      }
      for(int i=0;i<=marker.length-1;i++){
         for(int j=0;j<=marker[0].length-1;j++){
            marker[i][j].setEnabled(false);
            marker[i][j].setBackground(Color.gray.brighter());
         }
      }
      for(int c=0;c<=board[0].length-1;c++)
         board[rowCount][c].setEnabled(true);
      generatePattern();
      this.revalidate();
      this.repaint();
   }
   public void generatePattern(){
      for(int i=0;i<=pattern.length-1;i++){
         int count = (int)(Math.random() * (8));
         pattern[i] = colors[count];
         //pattern[i] = Color.red;
      }
      String[] words = patternToString(pattern);
      Stuff.print(java.util.Arrays.toString(words));   
   }
   public boolean winner(){
      Color[] check = new Color[4];
      for(int i=0;i<=3;i++)
         check[i] = borders[rowCount][i].getCol();
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
      ans[0] = borders[rowCount][0].getCol();
      ans[1] = borders[rowCount][1].getCol();
      ans[2] = borders[rowCount][2].getCol();
      ans[3] = borders[rowCount][3].getCol();
   
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
         marker[markersRowCount][0].setBackground(Color.white);
         marker[markersRowCount][1].setBackground(Color.white);
         marker[markersRowCount+1][0].setBackground(Color.white);
      }else if (whitepegs ==2){
         marker[markersRowCount+1][0].setBackground(Color.white);
         marker[markersRowCount+1][1].setBackground(Color.white);
      }else if(whitepegs == 1){
         marker[markersRowCount+1][1].setBackground(Color.white);
      }
      
      
      if(blackpegs == 4){
      
         for(int i = 0;i<2;i++)
            marker[markersRowCount][i].setBackground(Color.black);
         for(int i=0;i<2;i++)
            marker[markersRowCount+1][i].setBackground(Color.black);
      }
      else if(blackpegs == 3){
         marker[markersRowCount][0].setBackground(Color.black);
         marker[markersRowCount][1].setBackground(Color.black);
         marker[markersRowCount+1][0].setBackground(Color.black);
         
      }else if(blackpegs == 2 ){
         marker[markersRowCount][0].setBackground(Color.black);
         marker[markersRowCount][1].setBackground(Color.black);
      }else if(blackpegs == 1){
         marker[markersRowCount][1].setBackground(Color.black);
      }
      markersRowCount = Integer.MIN_VALUE;
      blackpegs = 0;
      whitepegs = 0;
      this.revalidate();
      this.repaint();
      Stuff.print(java.util.Arrays.toString(patternToString(pattern)));
   }
   public String[] patternToString(Color[] a){
      String[] words = new String[a.length];
      
      for(int i=0;i<=a.length-1;i++){
         if(a[i].equals(Color.red))
            words[i] = "RED";
         if(a[i].equals(Color.yellow))
            words[i] = "YELLOW";
         if(a[i].equals(Color.blue))
            words[i] = "BLUE";
         if(a[i].equals(Color.green))
            words[i] = "GREEN";  
         if(a[i].equals(Color.orange))
            words[i] = "ORANGE";
         if(a[i].equals(Panel16.pink))
            words[i] = "PINK";
         if(a[i].equals(Color.CYAN))
        	 words[i] = "CYAN";
         if(a[i].equals(Color.white))
        	 words[i] = "WHITE";
      }
      return words;
   }
}