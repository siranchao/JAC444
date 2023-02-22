
/**********************************************
Workshop 4
Course: JAC444
Last Name: CAO
First Name: Siran
ID: 159235209
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 02/21/2023
**********************************************/


package ws4.caseStudy;

import java.util.Scanner;

/**
 * This is a test class, use to test all functionalities of the program
 * @author Siran
 *
 */
public class Test {
	/**
	 * We can set the max item limit to the Payroll system is 30;
	 */
	public static final int maxItems = 30;
	
	
	/**
	 * the static main method will initiated a Payroll system can call its menu method.
	 * @param args arguments
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Payroll system = new Payroll();
		
		system.menu(scan);
	
		scan.close();
		
	}

	
	
}
