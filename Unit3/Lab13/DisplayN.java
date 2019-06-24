import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.ArrayList;

public class DisplayN extends JPanel{

   private static final int FRAME = 400;
   private static final Color BACKGROUND = new Color(204, 204, 204);
   private Graphics2D g2d;
   private Timer t;
   private ArrayList<Integer> num;
   private int size;
   private int stop;
   private JLabel label;
   private DisplayPanel sub;

   public void DisplayN(){
      setLayout(new BorderLayout());
      setSize(400, 400);
      
      sub = new DisplayPanel(new BufferedImage(400, 400, 1));
      g2d = sub.img.createGraphics();
      
      g2d.setColor(Color.GRAY);
      g2d.fillRect(0, 0, 400, 400);
      
      sub.setSize(400, 400);
      
      JPanel bottomPanel = new JPanel();
      add(sub, "Center");
      add(bottomPanel, "South");
      JButton start = new JButton("Make Necklace");
      JTextField first = new JTextField("7", 5);
      JTextField second = new JTextField("5", 5);
      start.addActionListener(new Starter(Driver13.necklace(Integer.parseInt(first.getText()), Integer.parseInt(second.getText()))));
      
      bottomPanel.add(first);
      bottomPanel.add(second);
      bottomPanel.add(start);
      
      stop = 0;
      t = new Timer(5, new Listener());   
      
   
   }
   private class Listener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         if (stop >= num.size())
         {
            t.stop();
         }
         size = num.size() * 2;
         double angle = 360 / num.size();
         double angleOfBead = 90 - angle * stop;
         
         int xCen = (int)(Math.cos(Math.toRadians(angleOfBead)) * size + 200);
         int yCen = (int)(Math.sin(Math.toRadians(angleOfBead)) * size + 200);
         int rad = 2 * (((Integer)num.get(stop)).intValue() + 1);
         
         int x = xCen - rad;
         int y = yCen - rad;
         
         g2d.setColor(new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
         g2d.fillOval(x, y, rad * 2, rad * 2);
         repaint();
         stop++;
      }
   }
   private class Starter implements ActionListener{
         
      public Starter(ArrayList<Integer> a){
         num = a;
      }
      public void actionPerformed(ActionEvent e){
         t.start();
      }
   }
}