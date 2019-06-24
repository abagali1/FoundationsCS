   //Torbert, e-mail: mr@torbert.com, website: www.mr.torbert.com
	//version 4.4.2003

   import javax.swing.JFrame;
   public class NecklaceMaker
   {
      public static void main(String[] args)
      {
         JFrame frame = new JFrame("High-Low");
         frame.setSize(500, 500);
         frame.setLocation(200, 100);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new DisplayN());
         frame.setVisible(true);
      }
   }