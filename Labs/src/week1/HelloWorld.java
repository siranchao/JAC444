package week1;

public class HelloWorld {

  public static void main(String[] args) {
      System.out.println("Hello, World!");
      HelloWorld obj = new HelloWorld();
      System.out.println(obj);
  }
  
  //override toString() method
  public String toString() {
      return "This is my object";
  }
}