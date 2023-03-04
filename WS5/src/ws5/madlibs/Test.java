
/**********************************************
Workshop 5
Course: JAC444
Last Name: CAO
First Name: Siran
ID: 159235209
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 03/04/2023
**********************************************/

package ws5.madlibs;

import java.util.Scanner;

/**
 * This is a test class, use to test all functionalities of the program
 * @author Siran
 *
 */
public class Test {
	
	/**
	 * the static main method will initiated a MadLib game and open its menu for playing
	 * @param args arguments
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		MadLibs game = new MadLibs();
		
		game.menu(scan);
		
		scan.close();
		
	}

}
