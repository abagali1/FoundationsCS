  //Name______________________________ Date_____________
  
import java.io.*;       		 //the File class
import java.util.*;     		 //the Scanner class
import javax.swing.JOptionPane;
public class Driver10
{
   public static void main(String[] args) 
   {
      Song[] songList = input();
      int totalTime = calcTime(songList);
      int longestSong = searchLongestSong(songList);
      display(songList, totalTime, longestSong);
      System.exit(0);
   }
   	
  public static Song[] input()
  {
    Scanner infile = null;
    while (infile == null) {
      try
      {
        String filename = JOptionPane.showInputDialog("What file?");
        infile = new Scanner(new File(filename));
      }
      catch (FileNotFoundException e)
      {
        JOptionPane.showMessageDialog(null, "The file could not be found.");
      }
    }
    int numitems = Integer.parseInt(infile.nextLine());
    Song[] arr = new Song[numitems];
    for (int i = 0; i <=numitems-1; i++)
    {
      String temp = infile.nextLine();
      arr[i] = new Song(temp);
    }
    infile.close();
    return arr;
  }
   
   public static int calcTime(Song[] songs)
   {
      int total = 0;
      for (int i = 0; i <= songs.length-1; i++) {
         total += songs[i].getTotalTime();
      }
      return total;
   }
      
   public static int searchLongestSong(Comparable[] songs)
   {
      int currentTime = 0;
      int maxPos = 0;
      for (int i = 1; i < songs.length; i++) {
         if (songs[i].compareTo(songs[maxPos]) > 0) {
            maxPos = i;
         }
      }
      return maxPos;
   }
  
   public static void display(Song[] array, int total, int longestSong)
   {
      System.out.println("Total Time: " + total / 60 + "' " + total % 60 + "\"");
    
      System.out.println("Longest Song: " + array[longestSong].toString());
   }
}