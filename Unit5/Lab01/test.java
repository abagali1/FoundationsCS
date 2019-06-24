import java.util.Arrays;
import java.util.Collections;
import java.util.*;
public class test{
   public static void main(String[] args){
      int[] arr = {1,2,3,4,5};
      ArrayList<Integer> a = new ArrayList<Integer>();
      a = Arrays.asList(arr);
      System.out.println(Collections.max(a));
      
   }
}