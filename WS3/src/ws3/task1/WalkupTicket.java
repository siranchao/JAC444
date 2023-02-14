package ws3.task1;

/**
 * This class represent the WalkupTicket which inherited from Ticket class
 * @author Siran
 *
 */
public class WalkupTicket extends Ticket{
	/**
	 * declare field of price for WalkupTicket
	 */
	private double price;
	
	/**
	 * Constructor without params will implicitly call super() and set price to 0.0
	 */
	public WalkupTicket() {
		price = 0.0;
		System.out.println("Empty walkup ticket created");
	}

	/**
	 * Constructor with param will explicitly create super class with ID and set price
	 * @param ticketID  ticket id
	 */
	public WalkupTicket(int ticketID) {
		super(ticketID);
		price = Test.walkup;
	}
	
	
	@Override
	public double getPrice() {
		return price;
	}
	

}
