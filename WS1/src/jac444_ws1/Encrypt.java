/**********************************************
Workshop 1
Course: JAC444
Last Name: CAO
First Name: Siran
ID: 159235209
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 01/29/2023
**********************************************/

package jac444_ws1;

/**This class is a simple scheme for encrypting data
 * All the data is transmitted as four-digit integers. Program read a four-digit integer entered by the user and encrypt it as follows:
	• Replace each digit with the result of adding 7 to the digit and getting the remainder after dividing the new value by 10.
	• Then swap the first digit with the third and swap the second digit with the fourth.
	• Then print the encrypted integer. 
 * 
 * @author Siran Cao
 * 
 */

import java.util.Scanner;

public class Encrypt {
	
	/**
	 * This method calculate the encrypt input and print the value
	 * @param input integer for encode
	 */
	public void convert(int input) {
		
		//convert 4-digit int into 4 elements array
		int[] arr = new int[4];
		for(int i = 0, j = 1000; i < 4; i++, j /= 10) {
			int digitValue = input / j;
			arr[i] = digitValue;
			input -= j * digitValue;
		}
		
		// replace each digit value
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (arr[i] + 7) % 10;
		}
		
		// swap values
		int temp = arr[0];
		arr[0] = arr[2];
		arr[2] = temp;
		temp = arr[1];
		arr[1] = arr[3];
		arr[3] = temp;
		
		//print value
		System.out.print("The encrypted value is: ");
		for(int item : arr) {
			System.out.print(item);
		}
		System.out.print("\n");
		
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter a 4-digit integer for encrypt: ");
		int input = scan.nextInt();
		
		//create instance and call method
		Encrypt encrypt = new Encrypt();
		encrypt.convert(input);
		
		scan.close();
	}

}