import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class PanelSampleYard extends JPanel {

   private Yard[] customers;
   private DisplaySampleYard display;
   private JButton next, exit;
   private int runningTotal = 0;
   private int index = 0;

   public PanelSampleYard() throws Exception{
   
      setLayout(new BorderLayout());
      
      
      add(new JLabel("Green and Grow Mowing Company"),BorderLayout.NORTH);
      
      Scanner infile = new Scanner(new File("greenGrow.txt"));
      customers = new Yard[infile.nextInt()];
      
      for(int i=0;i<=customers.length-1;i++){
         String lname = infile.next();
         String fname = infile.next();
         int size = infile.nextInt();
         
         if(size <= 10000)
            customers[i] = new CustomerSmallYard(lname,fname,size);
         else if((size > 10000) && (size <=20000))
            customers[i] = new CustomerMediumYard(lname,fname,size);
         else
            customers[i] = new CustomerLargeYard(lname,fname,size);
         
      }
      
   
      sort(customers);
      System.out.println(Arrays.toString(customers));
                   
      display = new DisplaySampleYard(customers);
      this.add(display,BorderLayout.CENTER);
       
      JPanel buttons = new JPanel();
       
      buttons.setLayout(new FlowLayout());
       
      next = new JButton("Next");
      next.addActionListener(new Listener()
         );
      buttons.add(next);
       
      exit = new JButton("Quit");
      exit.addActionListener(new Listener2());
      buttons.add(exit);
      
      this.add(buttons, BorderLayout.SOUTH);
       
      
   
   
   }
   
   public static void sort(Yard[] arr){   
      for(int k=0;k< arr.length ;k++){
         int max = 0;
         for(int i=1;i<arr.length-k;i++){
            if(arr[i].compareTo(arr[max]) > 0)
               max = i;
         }
         
         Yard temp = arr[(arr.length - k - 1)];
         arr[(arr.length - k - 1)] = arr[max];
         arr[max] = temp;
      
      }
   }
   
   private class Listener implements ActionListener{
      public void actionPerformed(ActionEvent e){
      
         if(index <= customers.length-1){
            runningTotal += customers[index].getCost();
            display.next(runningTotal);
            index++;
            
         }else{
            next.setEnabled(false);
         } 
      }
   }
   
   private class Listener2 implements ActionListener{
      public void actionPerformed(ActionEvent e){
         System.exit(0);
      }
   }
   
}