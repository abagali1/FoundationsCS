	//Name______________________________ Date_____________
    public class Salesperson 
   {
   	//data fields
      private String myName;
      private int myCars, myTrucks;
   
   	//constructors
      public Salesperson(){
         this.myName = "Bob";
         this.myCars = this.myTrucks = 0;
      }
      
      public Salesperson(Salesperson arg){
         this.myName = arg.getName();
         this.myCars = arg.getCars();
         this.myTrucks = arg.getTrucks();
      }
      public Salesperson(String a, int x, int y){
         this.myName = a;
         this.myCars = x;
         this.myTrucks =y;
      }
   
   
   	//accessors and modifiers
      public String getName(){
         return myName;
      }
      public int getCars(){
         return myCars;
      }
      public int getTrucks(){
         return myTrucks;
      }
      public void setName(String a){
         myName = a;
      }
      public void setCars(int a){
         myCars = a;
      }
      public void setTrucks(int a){
         myTrucks = a;
      }
   
   
   	//other methods: toString
   
      public String toString(){
         return "My name is " + myName + " and I have " + myCars + " cars and " + myTrucks + " trucks!";
      }
   }