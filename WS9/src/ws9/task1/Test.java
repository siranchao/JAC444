
/**********************************************
Workshop 9
Course: JAC444
Last Name: CAO
First Name: Siran
ID: 159235209
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 04/03/2023
**********************************************/

package ws9.task1;

import java.io.File;
import java.util.Scanner;


public class Test {

	public static String open(Scanner scan) {
		String fileName;
		System.out.println("This program uses a dictionary to compute the edit distance between pairs of words\n");
		System.out.print("Please enter the name of dictionary file: ");
		fileName = scan.nextLine();
		
		File inputFile = new File(fileName);
		while(!inputFile.exists()) {
			System.out.print("File not found. Try again: ");
			fileName = scan.nextLine();
			inputFile = new File(fileName);
		}
		return fileName;
	}
	
	public static void run() {
		Scanner scan = new Scanner(System.in);
		String fileName = open(scan);
		
		//open editDistance
		EditDistance ed = new EditDistance();
		ed.readDict(fileName);
		
		//run program
		String start = "", end = "";
		boolean exit = false;
		
		while(!exit) {
			System.out.println("Let's find an edit distance between words.");
			System.out.print("\tFirst word: (enter 'q' to quit) ");
			start = scan.nextLine();
			
			if(start.equals("q")) {
				System.out.println("Program terminated");
				return;
			}
			
			if(!ed.checkWord(start)) {
				System.out.println(start + " is not in the dictionary.\n");
			}
			else {
				System.out.print("\tSecond word: ");
				end = scan.nextLine();
				if(!ed.checkWord(end)) {
					System.out.println(end + " is not in the dictionary.\n");
				}
				else {
					ed.calcEditDistance(start, end);
				}
			}		
		}
		
		scan.close();
	}
	
	
	
	
	public static void main(String[] args) {

		run();		
	}
	

	
	
	
	
	
}
