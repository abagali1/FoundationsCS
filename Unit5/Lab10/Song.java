//Name______________________________ Date_____________

public class Song implements Comparable<Song>
{
   	//data fields
   private String myTitle;
   private int myMinutes, mySeconds;
   
   	//constructors
   public Song(String toBeParsed)
   {
      int col = toBeParsed.indexOf(":");
      myMinutes = Integer.parseInt(toBeParsed.substring(0,col));
      mySeconds = Integer.parseInt(toBeParsed.substring(col+1,col+3));
      myTitle = toBeParsed.substring(col+5,toBeParsed.length());
   
   
   }
     
   public String getTitle(){
      return myTitle;
   }
   public int getMin(){
      return myMinutes;
   }
   public int getSec(){
      return mySeconds;
   }
   public void setTitle(String a){
      myTitle = a;
   }
   public void setMinutes(int a){
      myMinutes = a;
   }
   public void setSeconds(int a){
      mySeconds = a;
   }      
   public int getTotalTime()
   {
      return myMinutes * 60 + mySeconds;
   }
  
   public int compareTo(Song s)
   {
      if (getTotalTime() < s.getTotalTime()) {
         return -1;
      }
      if (getTotalTime() > s.getTotalTime()) {
         return 1;
      }
      return 0;
   }
   public boolean equals(Song arg)
   {
      return compareTo(arg) == 0;
   }
   public String toString(){
      return myTitle + " (" + myMinutes + "' " + mySeconds + "\")";
   }
      //other methods:  compareTo(), equals(), toString()
      
   	
   	
}