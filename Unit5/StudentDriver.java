import java.io.*;
import java.util.*;
public class StudentDriver{
   public static void main(String[] args){
      try{
         Scanner infile = new Scanner(new File("names.txt"));
         
         Student[] students = new Student[25];
         
         for(int i=0;i<25;i++)
            students[i] = new Student(infile.next(), ((int)(Math.random() * ((12-9)+1) + 9)), (Math.random() * 101));
         
         Student maxGPA = findMax(students);
         
         int numOfFresh = findFresh(students);
         
         
      }catch(Exception e){System.exit(0);}
   }
   
   
   
   public static void sort(Student[] arr){   
      for(int k=0;k< arr.length ;k++){
         int max = 0;
         for(int i=1;i<arr.length-k;i++){
            if((arr[i].getName()).compareTo(arr[max].getName()) > 0)
               max = i;
         }
         
         Student temp = arr[(arr.length - k - 1)];
         arr[(arr.length - k - 1)] = arr[max];
         arr[max] = temp;
      
      }
   }
   
   
   public       
}