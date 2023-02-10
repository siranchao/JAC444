package ws3.task1;

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
	
	
	/**
	 * calculate day difference between today and event date
	 * @return day difference
	 */
	private int dayDiff() {
		LocalDate today = LocalDate.now();
		int days = (int)ChronoUnit.DAYS.between(today, Test.eventDate);
		return days;
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
		double subtotal = 0.0;
		
		while(run) {
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
					break;
				case 2:
					ticket = new AdvancedTicket(ticketID++, dayDiff());
					break;
				case 3:
					ticket = new StuAdvancedTicket(ticketID++, dayDiff());
					break;
				default:
					break;
			}
			
			if(ticket != null)
				subtotal += ticket.getPrice();

			System.out.println(ticket);
			
			System.out.print("Continue purchase? (Y/N) ");
			String val = scan.nextLine();
			if(val.charAt(0) == 'N' || val.charAt(0) == 'n') {
				run = false;
				System.out.println("Purchase complete, Subtotal: $" + subtotal);
			}
		}
	}


}
