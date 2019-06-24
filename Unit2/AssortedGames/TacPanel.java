import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class TacPanel extends JPanel {
   private static final int FRAME = 400;
   private  static final Color BACKGROUND = Color.BLACK.darker();
   private BufferedImage myImage;
   private Graphics myBuffer;
   private int game =0;
   private int user_input;
   private boolean[] possible_moves = {true,true,true,true,true,true,true,true,true};
   private int[] board = {0,0,0,0,0,0,0,0,0};
   private int[] displayboard = {0,0,0,0,0,0,0,0};
   private Timer o,t,s,i;
   private int start =5;
   private int enter = 0;
   
   public TacPanel(){
      myImage = new BufferedImage(FRAME,FRAME,1);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,400,400);
    
      o = new Timer(5, new OnePlay());
      t = new Timer(5, new TwoPlay());
      s = new Timer(100, new Starter());
      i = new Timer(5, new Instruct());
      s.start();
      
      addKeyListener(new Key());
      addMouseListener(new Mouse());
      setFocusable(true);
   }
   public void paintComponent(Graphics g)
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }
   private class Starter implements ActionListener{
      public void actionPerformed(ActionEvent e){
         if(start >=0){
            myBuffer.setColor(Color.BLACK);
            myBuffer.fillRect(0,0,FRAME,FRAME);
            myBuffer.setColor(new Color(0,255,51));
            myBuffer.setFont(new Font("Monospaced",1,50));
            myBuffer.drawString("TIC-TAC-TOE", 45, 100);
            myBuffer.setFont(new Font("Monospaced", 1, 25));
            myBuffer.drawString("STARTS IN... ",100,120);
            myBuffer.setColor(Color.RED);
            myBuffer.setFont(new Font("Arial", 1, 240));
            myBuffer.drawString(""+start, 120, 300);
         
            start--;
         }
         else{
            s.stop();
            i.start();
         }
         repaint();
      }
   }
   private class Instruct implements ActionListener{
      public void actionPerformed(ActionEvent e){
         ImageIcon pic = new ImageIcon("tictac.gif");
         myBuffer.drawImage(pic.getImage(),0,0,400,400, null);
         myBuffer.setColor(new Color(0,255,51));
         myBuffer.setFont(new Font("Monospaced",1,50));
         myBuffer.drawString("TIC-TAC-TOE", 45, 100);
         myBuffer.setFont(new Font("Monospaced", 1, 15));/*
         myBuffer.drawString("Press A to move left, Press D to move right",10,120);
         myBuffer.drawString("Press <-- for left, --> for right(bottom)",10,140);
         myBuffer.drawString("Space to Reset", 120, 160);*/
         myBuffer.setColor(Color.RED);        
         myBuffer.setFont(new Font("Arial", 1, 50));       
         myBuffer.drawString("Select Mode: ", 55, 250);
         myBuffer.drawString("Single Player", 60, 320);
         myBuffer.drawString("Two Player", 70, 370);    
         repaint();
      }
   } 
   private class OnePlay implements ActionListener{
      public void actionPerformed(ActionEvent e){
         i.stop();
         myBuffer.setColor(Color.black.darker());
         myBuffer.fillRect(0,0,408,438);
         myBuffer.setColor(new Color(0,255,51));
         myBuffer.fillRect(136,0,20,438);
         myBuffer.fillRect(272,0,20,438);
         myBuffer.fillRect(0,146,400,20);
         myBuffer.fillRect(0,292,400,20);
         repaint();
         
      }
   }
   private class TwoPlay implements ActionListener{
      public void actionPerformed(ActionEvent e){
         i.stop();
         myBuffer.setColor(Color.black.darker());
         myBuffer.fillRect(0,0,408,438);
         myBuffer.setColor(new Color(0,255,51));
         myBuffer.fillRect(136,0,50,438);
         //myBuffer.fillRect(272,0,276,400);
         //myBuffer.fillRect(0,146,400,150);
         //myBuffer.fillRect(0,292,400,296);
         repaint();
      }
   }
   private class Key extends KeyAdapter{
      public void keyPressed(KeyEvent e){
         if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(1);
         }
      }
      public void keyReleased(KeyEvent e){
         if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(1);
         }
      }
   }
   private class Mouse extends MouseAdapter{
      public void mouseClicked(MouseEvent e){
         if(i.isRunning()){
            if(e.getX() >= 70 && e.getY() >= 335 && e.getX() <= 300 && e.getY() <= 400){
               i.stop();
              o.start();
            }
         
         }
      }
   }

}

   



    
