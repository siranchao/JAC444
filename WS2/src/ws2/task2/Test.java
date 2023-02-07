/**********************************************
Workshop 2
Course: JAC444
Last Name: CAO
First Name: Siran
ID: 159235209
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 02/27/2023
**********************************************/


package ws2.task2;

import java.util.Scanner;
/**
 * This class defines key constants of the program and test the functionalities in its main() method
 * @author Siran
 *
 */
public class Test {
	/**
	 * Define static constants for max item number and testing examples
	 */
	public static final int maxItems = 10;
	public static String[] items = {"Apple", "Banana", "Lemon", "Pits", "Orange", "Berries", "Mongos", "Tomato", "Carrot", "Pears"};
	public static double[] prices = {1.99, 3.99, 5.49, 3.99, 2.15, 3.29, 19.99, 9.99, 1.50, 2.50};

	
	/**
	 * This main() will test the program by using logic control for user inputs
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		GroceryList shoppingList = new GroceryList();
		Menu menu = new Menu(items, prices);
		
		boolean run = true;
		while(run) {
			int select = 0, qty = 0;
			boolean exit = false;
			String val;
			
			menu.display();
			
			while(!exit) {
				System.out.print("Select item number to add into shopping list: ");
				if(scan.hasNextInt()) {
					select = scan.nextInt();
					exit = (select <= items.length) ? true : false;
				}
				else {
					System.out.println("Please enter valid number!");
				}	
				scan.nextLine();
			}
			exit = false;
			while(!exit) {
				System.out.print("Please enter quantity: ");
				if(scan.hasNextInt()) {
					qty = scan.nextInt();
					exit = (qty <= 500) ? true : false;
				}
				else {
					System.out.println("Please enter valid number!");
				}
				scan.nextLine();
			}
			shoppingList.add(menu.order(select, qty));
			
			System.out.print("Do you want to exit (Y/N): ");
			val = scan.nextLine();
			if(val.charAt(0) == 'Y' || val.charAt(0) == 'y') {
				run = false;
				shoppingList.show();
				System.out.println("--- Program ends ---");
			}
			
		}
		
		scan.close();
	}
}
