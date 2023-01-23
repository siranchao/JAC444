package week1;

import java.util.Scanner;

public class CalcSum {

	public static void main(String[] args) {
		int input;

		System.out.print("Enter a number between 0 and 1000: ");
		Scanner scan = new Scanner(System.in);
		input = scan.nextInt();
		scan.close();
		
		int sum = 0;
		for(int i = 0, x = 100; i < 3; i++) {
			if(input / x > 0) {
				sum += input/x;
			}
			input -= input/x*x;
			x /= 10;
			//System.out.println("sum: " + sum + " input: " + input + " x: " + x);
		}
		
		System.out.println("The sum of digits is: " + sum);
		
	}
}
