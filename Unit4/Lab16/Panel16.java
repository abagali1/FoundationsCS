import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class Panel16 extends JPanel{
   private Gameboard16ext g;//Gameboard16 g;
   private Scoreboard16 s;
   private JButton reset;
   private JButton[] colors;
   private JLabel[] winningLabel;
   private JLabel subL, subR;
   private Timer t;
public static Color pink = new Color(255,127,252);
   public Panel16(){
      setLayout(new BorderLayout());
               
      s = new Scoreboard16(new Hidden());
      add(s,BorderLayout.NORTH);
       
      g = new Gameboard16ext();//Gameboard16();
      add(g, BorderLayout.WEST);
         
      t = new Timer(10, new Check());
      t.start();
            
      JPanel colorPanel = new JPanel();
      colorPanel.setLayout(new GridLayout(0,4));
      add(colorPanel,BorderLayout.EAST);
      winningLabel = new JLabel[4];
      colors = new JButton[8];
      for(int i=0;i<=winningLabel.length-1;i++) {
    	  winningLabel[i] = new JLabel("-");
    	  //winningLabel[i].setFont(new Font("Arial", 50, Font.BOLD));
    	  colorPanel.add(winningLabel[i]);
      }
      for(int i=0;i<=colors.length-1;i++){
         colors[i] = new JButton();
         switch(i){
            case 0:
               colors[i].setBackground(Color.red);
               break;
            case 1:
               colors[i].setBackground(Color.green);
               break;
            case 2:
               colors[i].setBackground(Color.blue);
               break;
            case 3:
               colors[i].setBackground(Color.yellow);
               break;
            case 4:
               colors[i].setBackground(Color.orange);
               break;
            case 5:
               colors[i].setBackground(new Color(255,127,252));
               break;
            case 6:
            	colors[i].setBackground(Color.CYAN);
            	break;
            case 7:
            	colors[i].setBackground(Color.white);
            	break;
         }
         colors[i].addActionListener(new Listener1(colors[i].getBackground()));
         colorPanel.add(colors[i]);
      }
            
      JPanel subPanel = new JPanel();
      subPanel.setLayout(new FlowLayout());
      add(subPanel,BorderLayout.SOUTH);
      
      subL = new JLabel("WINNER");
      subL.setForeground(this.getBackground());
      subL.setBackground(this.getBackground());
      add(subL);
      
      reset = new JButton("Reset");
      reset.addActionListener(new Listener());
      reset.setEnabled(false);
      reset.setFocusPainted(false);
      subPanel.add(reset);
      
      subR = new JLabel("WINNER");
      subR.setForeground(this.getBackground());
      subR.setBackground(this.getBackground());
      add(subR);
      
      g.setColor(Color.red);
   }
   
   private class Listener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         g.reset();
         for(JLabel w: winningLabel) {
        	w.setText("-");
         }
      }
   }
   
   private class Listener1 implements ActionListener{
      private Color myColor;
      public Listener1(Color c){
         myColor = c;
      }
      public void actionPerformed(ActionEvent e){
         //System.out.println(myColor);
         g.setColor(myColor);
         s.setColor(myColor);
      }
   }
   
   private class Check implements ActionListener{
      public void actionPerformed(ActionEvent e){
         if(g.won()){
             winningLabel[0].setText("W");
             winningLabel[1].setText("O");
             winningLabel[2].setText("N");
             winningLabel[3].setText("!");
            reset.setEnabled(true);
            s.winner();
            t.stop();
         }else if(g.loser()){
            reset.setEnabled(true);
            winningLabel[0].setText("L");
            winningLabel[1].setText("O");
            winningLabel[2].setText("S");
            winningLabel[3].setText("S");
            s.loser();
            t.stop();
            
         }else{
            reset.setEnabled(false);
            winningLabel[0].setText("P");
            winningLabel[1].setText("L");
            winningLabel[2].setText("A");
            winningLabel[3].setText("Y");
         }
      }
   }
   public class Hidden implements ActionListener{
      public void actionPerformed(ActionEvent e){
         g.reset();
      }
   }
}