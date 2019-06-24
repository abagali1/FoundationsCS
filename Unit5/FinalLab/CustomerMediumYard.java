public class CustomerMediumYard implements Yard{

   private String firstName, lastName;
   private int size;
   private double cost;
   
   public CustomerMediumYard(String l, String f, int size){
      firstName = f;
      lastName = l;
      this.size = size;
      this.cost = (double)this.size * (double)0.004;
   }
   
   public double getCost(){
      return cost;
   }
   
   public String getFirstName(){
      return firstName;
   }
      
   public String getLastName(){
      return lastName;
   }
         
   public String toString(){
      return firstName + " " + lastName + " has a medium yard of size " + size + " and costs " + cost + " to mow.";
   }
           
   public int getSize(){
      return size;
   }
   
   public int compareTo(Yard y){
      if(getLastName().compareTo(y.getLastName()) > 0)
         return 1;
      else if(getLastName().compareTo(y.getLastName()) == 0)
         return 0;
      else
         return -1;
   }           
}