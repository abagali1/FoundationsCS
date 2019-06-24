import java.io.*;
import java.util.Arrays;
import java.util.*;
import javax.swing.JOptionPane;
public class Driver08{
   public static void main(String[] args) throws Exception{
      Scanner infile = new Scanner( new File("words.txt" ) );
      String[] words = new String[infile.nextInt()];
      for(int x=0; x<=words.length-1;x++)
         words[x] = infile.next();
      while(true){
         String trial = JOptionPane.showInputDialog("Word? (-1 to quit.)").toLowerCase();         
         if(trial.equals("-1")){
            System.out.println("Good-bye");
            System.exit(0);
         }else if(Arrays.asList(words).contains(trial)){
            System.out.println("Yes, \"" + trial + "\" is a word, #" + ((int)Arrays.asList(words).indexOf(trial)+1) + ".");
         }else if(!Arrays.asList(words).contains(trial)){
            System.out.println("No, \"" + trial + "\" is not a word.");
         }
      }
   }
}