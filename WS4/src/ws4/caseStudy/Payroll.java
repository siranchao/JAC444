package ws4.caseStudy;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Payroll {
	
	Payable[] items;
	private int counter;
	
	
	public Payroll() {
		items = new Payable[Test.maxItems];
		counter = 0;
	}
	
	
	public void addInvoice(Scanner scan) {
		if(counter >= Test.maxItems) {
			throw new IndexOutOfBoundsException("Reach Maximum item limits");
		}
		System.out.println("\n======== Add New Invoice ========");
		try {
			System.out.print("Please enter part number: ");
			String partNum = scan.next();
			
			System.out.print("Please enter part description: ");
			String partDesc = scan.next();
			
			System.out.print("Please enter item quantity: ");
			int qty = scan.nextInt();
			
			System.out.print("Please enter item price: ");
			double price = scan.nextDouble();
			
			items[counter] = new Invoice(partNum, partDesc, qty, price);
		}
		catch(InputMismatchException | IllegalArgumentException e) {
			e.printStackTrace();
			scan.nextLine();
			System.out.println("Unable to add Invoice, please try again");
		}
		
		if(items[counter] != null) {
			System.out.println("New Invoice Added!");
			System.out.println(items[counter]);
			items[counter].displayAmount();
			counter++;
		}
	}
	
	
	
	public void addEmployee(Scanner scan, int type) {
		if(counter >= Test.maxItems) {
			throw new IndexOutOfBoundsException("Reach Maximum item limits");
		}
		System.out.println("\n======== Add New Employee ========");
		System.out.print("Please enter first name: ");
		String fname = scan.next();
		
		System.out.print("Please enter last name: ");
		String lname = scan.next();
		
		System.out.print("Please enter social security number: ");
		String ssn = scan.next();
		
		try {
			switch(type) {
			case 2:
				System.out.println("<Employment Type>: Fixed Salary");
				System.out.print("Please enter weekly salary: ");
				double salary = scan.nextDouble();
				items[counter] = new SalariedEmployee(fname, lname, ssn, salary);
				break;
			case 3:
				System.out.println("<Employment Type>: Hourly Salary");
				System.out.print("Please enter hourly wage: ");
				double wage = scan.nextDouble();
				System.out.print("Please enter working hours: ");
				double hours = scan.nextDouble();
				items[counter] = new HourlyEmployee(fname, lname, ssn, wage, hours);
				break;
			case 4:
				System.out.println("<Employment Type>: Commission Only");
				System.out.print("Please enter commission rate: ");
				double rate = scan.nextDouble();
				System.out.print("Please enter gross sales in this period: ");
				double grossSales = scan.nextDouble();
				items[counter] = new CommissionEmployee(fname, lname, ssn, grossSales, rate);				
				break;
			case 5: 
				System.out.println("<Employment Type>: Commission and Base");
				System.out.print("Please enter commission rate: ");
				double rate2 = scan.nextDouble();
				System.out.print("Please enter gross sales in this period: ");
				double grossSales2 = scan.nextDouble();
				System.out.print("Please enter base salary(weekly): ");
				double base = scan.nextDouble();
				items[counter] = new BasePlusCommissionEmployee(fname, lname, ssn, grossSales2, rate2, base);
				((BasePlusCommissionEmployee) items[counter]).setBaseSalary(0.1);
				break;
			}
		}
		catch(InputMismatchException | IllegalArgumentException e) {
			e.printStackTrace();
			scan.nextLine();
			System.out.println("Unable to handle your choice, please try again");
		}
		catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
			scan.nextLine();
			System.out.println("Unable to add new item, payroll item list is full");
		}
		
		if(items[counter] != null) {
			System.out.println("New Employee Added!");
			System.out.println(items[counter]);
			items[counter].displayAmount();
			counter++;
		}
	}
	

	public void menu(Scanner scan) {
		boolean flag = false;
		while(!flag) {
			System.out.println("********** Welcome to Payroll System **********");
			System.out.println("#1\t\t\t New Invoice");
			System.out.println("#2\t\t\t Salaried Employee");
			System.out.println("#3\t\t\t Hourly Wage Employee");
			System.out.println("#4\t\t\t Commission Employee");
			System.out.println("#5\t\t\t Commission & Base Employee");
			System.out.println("#6\t\t\t Print All Items");
			System.out.print("Select Your Choice: ");
			try {
				int type = scan.nextInt();
				if(type == 1) {
					addInvoice(scan);
				} 
				else if(type > 1 && type < 6) {
					addEmployee(scan, type);	
				} 
				else if(type == 6) {
					printAll();
				}
				else {
					throw new IllegalArgumentException("Invalid menu selection!");
				}
			}
			catch(InputMismatchException | IllegalArgumentException e) {
				e.printStackTrace();
				scan.nextLine();
				System.out.println("Invalid input, please try again");
			}
			
			System.out.print("Exit the Menu? (Y/N)");
			String val = scan.next();
			if(val.charAt(0) == 'Y' || val.charAt(0) == 'y') {
				flag = true;
				System.out.println("********** Payroll System Closed**********");
			}
		}
		
	}
	
	
	public void printAll() {
		for(Payable item : items) {
			if(item != null) {
				System.out.println(item);
				item.displayAmount();
				System.out.println("\n\n");
			}
		}
	}

	

}
