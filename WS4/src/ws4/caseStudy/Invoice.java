package ws4.caseStudy;


/**
 * Invoice class is a basic class implements Payable interface and describe an invoice object
 * @author Siran
 *
 */
public class Invoice implements Payable {
	private String partNumber;
	private String partDesc;
	private int qty;
	private double itemPrice;

	/**
	 * Define no-arg constructor and set initial values
	 */
	public Invoice() {
		partNumber = "";
		partDesc = "";
		qty = 0;
		itemPrice = 0.0;
	}
	
	/**
	 * Define a constructor with parameters and set initial values
	 * @param partNumber invoice number
	 * @param partDesc description
	 * @param qty quantity
	 * @param itemPrice price per item
	 */
	public Invoice(String partNumber, String partDesc, int qty, double itemPrice) {
		if(qty <= 0 || itemPrice < 0.0) {
			throw new IllegalArgumentException("Invalid arguments when calling constructor: Quantity and price must greater than 0.0");
		}
		this.partNumber = partNumber;
		this.partDesc = partDesc;
		this.qty = qty;
		this.itemPrice = itemPrice;
	}
	
	@Override
	/**
	 * this method implementS abstract method from Payable interface
	 */
	public double getPaymentAmount() {
		return getQty() * getItemPrice();
	}
	
	@Override
	/**
	 * this method implementS abstract method from Payable interface
	 */
	public void displayAmount() {
		System.out.println("Payment Amount: " + getPaymentAmount() + "\n");
	}
	
	@Override
	public String toString() {
		String header = "\n---------------------------\n";
		String msg = "- Invoice Number: " + getPartNumber() + "\n- Description: " + getPartDesc() + "\n- Quantity: " + getQty() + "\n- Item Price: " + getItemPrice();
		String footer = "\n---------------------------";
		return header + msg + footer;
	}
	
	/**
	 * Getter method
	 * @return part number
	 */
	public String getPartNumber() {
		return partNumber;
	}
	
	/**
	 * Getter method
	 * @return  part description
	 */
	public String getPartDesc() {
		return partDesc;
	}
	
	/**
	 * Getter method
	 * @return quantity
	 */
	public int getQty() {
		return qty;
	}
	
	/**
	 * Getter method
	 * @return price per item
	 */
	public double getItemPrice() {
		return itemPrice;
	}
		
}

