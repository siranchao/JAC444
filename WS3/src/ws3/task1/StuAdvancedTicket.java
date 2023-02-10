package ws3.task1;

/**
 * This class represent the Student Advanced ticket which inherited from Advanced ticket
 * @author Siran
 *
 */
public class StuAdvancedTicket extends AdvancedTicket{
	
	/**
	 * Constructor without params will implicitly call super() and set price to 0.0
	 */
	public StuAdvancedTicket () {
		System.out.println("Empty student advanced ticket created");
	}

	/**
	 * Constructor with param will explicitly create AdvancedTicket class with ID and days
	 * and set new student price based on advanced days
	 * @param ticketID  ticket id
	 * @param days advanced days
	 */
	public StuAdvancedTicket (int ticketID, int days) {
		super(ticketID, days);
		double stuPrice = (days >= 10 ? Test.advance1 : Test.advance2) / 2;
		setPrice(stuPrice);
		
	}
	
	@Override
	/**
	 * This method override toString() and display ticket information plus "(ID required)"
	 */
	public String toString() {
		return ticketID == 0 ? "Invalid Ticket" : "Student Advanced Ticket | Number: " + ticketID + ", Price: " + getPrice() + " (ID required)";
	}
	
}
 