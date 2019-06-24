	//Name:    Date:
   public class Dice
   {
      private int myOne, myTwo;
      public Dice()
      {
         myOne = random();
         myTwo = random();
      }
      public void roll()
      {
         myOne = random();
         myTwo = random();
         	/************************/
         	/*                      */
         	/* Your code goes here. */
         	/*                      */
         	/************************/
      }
      public int total()
      {
         return myOne + myTwo;
         	/************************/
         	/*                      */
         	/* Your code goes here. */
         	/*                      */
         	/************************/
      }
      public boolean doubles()
      {
         return myOne == myTwo;
         	/************************/
         	/*                      */
         	/* Your code goes here. */
         	/*                      */
         	/************************/
      }
      public String toString()
      {
         return "{" + myOne + ", " + myTwo + "}";
      }
      private int random()
      {
         return (int)(Math.random() * 6 + 1);
      }
   }