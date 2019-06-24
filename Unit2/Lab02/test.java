import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class test{
   public static void main(String [] args){
      
      JFrame frame = new JFrame("Our Fearless Leader");
      frame.setSize(400, 400);
      frame.setLocation(100, 50);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new testPanel());
      frame.setVisible(true);
 
   }
}
class testPanel extends JPanel{
   public void paintComponent(Graphics g)
   {
   
   
      g.setColor(Color.MAGENTA);
      int y =0;
      for(int x=0;x < 400; x+=50)
         g.drawOval(x,y+=50,50,50);
       
       
         
       
   }
}
