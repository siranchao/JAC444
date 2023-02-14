package ws3.task1;

/**
 * This class represent the Advanced ticket which inherited from Ticket class
 * @author Siran
 *
 */
public class AdvancedTicket extends Ticket{
	/**
	 * declare field of price for AdvancedTicket
	 */
	private double price;
	
	/**
	 * Constructor without params will implicitly call super() and set price to 0.0
	 */
	public AdvancedTicket() {
		price = 0.0;
		System.out.println("Empty advanced ticket created");
	}
	
	/**
	 * Constructor with param will explicitly create super class with ID and days
	 * price will be set based on advanced days
	 * @param ticketID  ticket id
	 * @param days advanced days
	 */
	public AdvancedTicket(int ticketID, int days) {
		super(ticketID);
		price = days >= 10 ? Test.advance1 : Test.advance2;
	}
	
	@Override
	public double getPrice() {
		return price;
	}
	
	/**
	 * this method will change the price field based on parameter
	 * @param price new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	
}
