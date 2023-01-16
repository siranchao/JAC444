package sampleCodes;

import java.util.Scanner;

public class Testmain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter your choice (Y/N): ");
		
		String value = scan.nextLine();
		char choice = value.charAt(0);
		
		System.out.println("Your choice is: " + choice);
		
		scan.close();
		
		
		//sample loop array
		int[] array = {12, 22, 33, 444, 56};
		for(int x : array) {
			System.out.println("Number is: " + x);
		}
		
		
		
	}
}
