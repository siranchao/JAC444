package week6.expection;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestException1 {

	public static void main(String[] args) {
		int num1 = 0, num2 = 0, result = 0;
		Scanner scan = new Scanner(System.in);
		boolean goAtnumber = false;
		
		while(!goAtnumber) {
			try {
				System.out.print("Enter the first number: ");
				num1 = scan.nextInt();
				System.out.println();
				System.out.print("Enter the second number: ");
				num2 = scan.nextInt();
				
				result = num1 / num2;
			}catch(InputMismatchException e) {
				System.out.println("input is not proper ... I quit");
				System.exit(-1);
			}catch(Exception e) {
				System.out.println("Second number is zero, cannot divide");
				System.exit(-1);
			}
			
		System.out.println();
		System.out.println(num2 + " goes into " + num1);
		System.out.println(" this many times: ");
		System.out.println(result);
		}
	}
}