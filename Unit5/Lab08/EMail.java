//Name______________________________ Date_____________
public class EMail
{
   private String myUserName;
   private String myHostName;
   private String myExtension;
   public EMail(String address)
   {
      int at = address.indexOf("@");
      int dot = address.indexOf(".", at);
      myUserName = address.substring(0, at);
      myHostName = address.substring(at + 1, dot);
      myExtension = address.substring(dot + 1);
      
   }
   public String getUserName()
   {
      return myUserName;
   }
   public String getHostName()
   {
      return myHostName;
   }
   public String getExtension()
   {
      return myExtension;
   }
   public String toString()
   {
      return myUserName + "@" + myHostName + "." + myExtension;
   }
}