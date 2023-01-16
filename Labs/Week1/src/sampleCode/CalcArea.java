package SampleCode;

//import java base library for input stream
import java.util.Scanner;

public class CalcArea {
  public static final double PI = 3.14;
  
  public static void main(String[] args) {
      double radius;
      double area;
      
      //test input stream
      System.out.print("Please Enter Radius: ");
      Scanner scan = new Scanner(System.in);
      radius = scan.nextDouble();
      
      area = 2 * Math.PI * radius;
      
      System.out.println("Total area is: " + area);
      
      scan.close();
  }
  
}