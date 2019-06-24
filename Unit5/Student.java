public class Student{
   
   private String name;
   private int grade;
   private double gpa;
   
   public Student(String n, int g, double p){
      this.name = n;
      this.grade = g;
      this.gpa = p;
   }
      
   public String getName(){
      return name;
   }
   public int getGrade(){
      return grade;
   }
   public double getGPA(){
      return gpa;
   }
   public void setName(String s){
      this.name =s;
   }
   public void setGrade(int g){
      this.grade = g;
   }
   public void setGPA(int p){
      this.gpa=p;
   }
}