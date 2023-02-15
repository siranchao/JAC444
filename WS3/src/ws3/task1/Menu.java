package ws3.task1;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * This class creates a menu object to display ticket type and prices
 * let user to select and purchase tickets
 * @author Siran
 *
 */
public class Menu {
	/**
	 * static field set ID start with 100
	 */
	private static int ticketID = 100;
	private static int maxSeats = 30;
	private static int maxAdcanceDays = 45;
	
	private Ticket[] sales; 
	private int sold;
	
	public Menu() {
		sales = new Ticket[maxSeats];
		sold = 0;
	}
	

	/**
	 * display header and ticket info
	 */
	private void display() {
		System.out.println("No" + "\t\t" + "Ticket Type" + "\t\t\t" + "Price");
		System.out.println("#1" + "\t\t" + "Walkup Ticket" + "\t\t\t" + Test.walkup);
		System.out.println("#2" + "\t\t" + "Advanced Ticket" + "\t\t\t" + Test.advance1 + "/" + Test.advance2);
		System.out.println("#3" + "\t\t" + "Student Ticket" + "\t\t\t" + Test.advance1/2 + "/" + Test.advance2/2);
	}
	
	
	/**
	 * this method use logic control to let user select from list of tickets and calculate subtotal
	 * test polymorphism: use super class Ticket type to invoke different override behaviors from subclasses 
	 * @param scan Scanner obj
	 */
	public void purchase(Scanner scan) {
		boolean run = true;
		
		while(run && sold < maxSeats) {
			boolean flag = false;
			int select = 0;
			
			display();
			
			while(!flag) {
				System.out.print("Select your ticket: ");
				if(!scan.hasNextInt()) {
					System.out.println("Invalid number!");
				}
				else {
					select = scan.nextInt();
					flag = select > 0 && select <= 3 ? true : false;
				}
				scan.nextLine();
			}
			
			Ticket ticket = null;
			
			switch(select) {
				case 1:
					ticket = new WalkupTicket(ticketID++);
					sales[sold] = ticket;
					sold++;
					System.out.println(ticket);
					break;
				case 2:
					try {
						System.out.print("How many days in advanced: ");
						int days = scan.nextInt();
						if(days <= maxAdcanceDays ) {
							ticket = new AdvancedTicket(ticketID++, days);
							sales[sold] = ticket;
							sold++;
							System.out.println(ticket);
						} else {
							System.out.println("Maximun advanced day is: " + maxAdcanceDays);
						}
					}
					catch(InputMismatchException | NumberFormatException e) {
						e.printStackTrace();
						System.out.println("Warning! Invalid inputs");
						scan.nextLine();
					}
					break;
				case 3:
					try {
						//validate student ID
						System.out.print("Please enter student ID: ");
						scan.nextInt();
						
						System.out.print("How many days in advanced: ");
						int days = scan.nextInt();
						
						if(days <= maxAdcanceDays ) {
							ticket = new StuAdvancedTicket(ticketID++, days);
							sales[sold] = ticket;
							sold++;
							System.out.println(ticket);
						} else {
							System.out.println("Maximun advanced day is: " + maxAdcanceDays);
						}
					}
					catch(InputMismatchException | NumberFormatException e) {
						e.printStackTrace();
						System.out.println("Warning! Invalid inputs");
						scan.nextLine();
					}
					break;
				default:
					break;
			}

			System.out.print((maxSeats-sold) + " Tickets left. Continue purchase? (Y/N)");

			String val = scan.next();
			if(val.charAt(0) == 'N' || val.charAt(0) == 'n') {
				run = false;
				summary();
			}
		}
	}

	
	public void summary() {
		double total = 0.0;
		for(Ticket ticket : sales) {
			if(ticket != null)
				total += ticket.getPrice();
		}
		System.out.println("\n=========== Summary ============\n");
		System.out.println("Total Tickets purchased: " + sold);
		System.out.println("Subtotal: $" + total + "\n");
	}

}
