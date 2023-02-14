package ws3.task1;

/**
 * This abstract class represent a super class of all kinds of tickets, and define the key methods of a ticket
 * @author Siran
 *
 */
public abstract class Ticket {
	
	/**
	 * ID for each ticket
	 */
	public int ticketID;
	
	/**
	 * Constructor without parameters, will create an empty ticket with ID equal 0
	 */
	public Ticket() {
		ticketID = 0;
		System.out.println("Empty ticket created");
	}
	
	/**
	 * Constructor with parameter will create a ticket by given ID
	 * @param ticketID ticket id
	 */
	public Ticket(int ticketID) {
		this.ticketID = ticketID;
	}
	
	
	/**
	 * this abstract method return the price of a ticket will be defined by subclasses
	 */
	public abstract double getPrice();
	
	
	@Override
	/**
	 * This method override toString() and display ticket information with ID and it's price
	 */
	public String toString() {
		return ticketID == 0 ? "Invalid Ticket" : "Ticket Number: " + ticketID + ", Price: " + getPrice();
	}
	
}
