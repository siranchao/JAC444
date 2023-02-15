/**********************************************
Workshop 3
Course: JAC444
Last Name: CAO
First Name: Siran
ID: 159235209
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 02/10/2023
**********************************************/

package ws3.task1;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;


/**
 * This Test class use to run testing method of the program
 * @author Siran
 *
 */
public class Test {
	
	/**
	 * set static constant for event date, prices for different tickets
	 */
	public static final double walkup = 50.0;
	public static final double advance1 = 30.0;
	public static final double advance2 = 40.0;
	public static int ID = 100;
	
	
	/**
	 * this static method will create all types of tickets from the inheritance hierarchy
	 * test override method and constructor
	 */
	public static void checkInheritance() {
		//walkup
		WalkupTicket walkup1 = new WalkupTicket();
		WalkupTicket walkup2 = new WalkupTicket(ID++);
		System.out.println(walkup1);
		System.out.println(walkup2);
		
		//advanced
		AdvancedTicket adv1 = new AdvancedTicket();
		AdvancedTicket adv2 = new AdvancedTicket(ID++, 18);
		AdvancedTicket adv3 = new AdvancedTicket(ID++, 3);
		System.out.println(adv1);
		System.out.println(adv2);
		System.out.println(adv3);
		
		//student advanced
		StuAdvancedTicket student1 = new StuAdvancedTicket();
		StuAdvancedTicket student2 = new StuAdvancedTicket(ID++, 12);
		StuAdvancedTicket student3 = new StuAdvancedTicket(ID++, 4);
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3);	
		System.out.println("\n\n");
	}
	
	/**
	 * run testing codes in main() method
	 * @param args 
	 */
	public static void main(String[] args) {
		
		//System.out.println("=========== test Inheritance ============");
		//checkInheritance();
		
		
		System.out.println("=========== test Polymorphism ============");
		
		Scanner scan = new Scanner(System.in);
		Menu menu = new Menu();
		menu.purchase(scan);
		scan.close();
		
		System.out.println("=========== Menu Closed ============");

	}	

}
