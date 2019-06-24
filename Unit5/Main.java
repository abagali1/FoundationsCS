

public class Main{
 
   public static void main(String[] args){
      System.out.println(change(45));
   }
		public static int change(int value)
		{
			if(value < 3)
				return value % 3;
			return value % 3 + 10 * change(value/3);
		}



}