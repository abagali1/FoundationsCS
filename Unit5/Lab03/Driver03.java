public class Driver03{
   
   public static void print(int[] arr){
      System.out.println(java.util.Arrays.toString(arr));
   }
   public static void scramble(int[] array)
   {
      for (int k = 1; k <= 100; k++)
      {
         int a = (int)(Math.random() * 10.0D);
         int b = (int)(Math.random() * 10.0D);
         swap(array, a, b);
      }
   }
   public static void swap(int[] array, int a, int b)//what are "a" and "b" for???
   {
      int temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }
   public static void sort(int[] array)
   {
      int maxPos;
      for(int k = 0; k < array.length; k++)
      {
         maxPos = findMax(array, array.length - k - 1);
         swap(array, maxPos, array.length - k - 1);
      }
   }   
   public static int findMax(int[] array, int upper) //what does "upper" do???
   {
      {
         int maxPos = 0;
         for (int j = 1; j <= upper; j++) {
            if (array[j] > array[maxPos]) {
               maxPos = j;
            }
         }
         return maxPos;
      }
   }
   public static void main(String[] args){
      int[] arr = {100,101,102,103,104,105,106,107,108,109};
      print(arr); 
      scramble(arr);
      print(arr);
      sort(arr);
      print(arr);
   
   }
}