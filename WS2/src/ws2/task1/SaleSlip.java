package ws2.task1;

/**
 * This class describe the sale slip that been passed everyday by each salesperson
 * contain attributes to record each salesman make total amount for one particular product per day
 * @author Siran
 *
 */
public class SaleSlip {
	
	/**
	 * salesID - salesperson number (1-4)
	 * productID - product for each slip assume (1 - 5)
	 * amount - total sales on the slip
	 */
	private int salesID;
	private int productID;
	private double amount;
	
	/**
	 * constructor with no parameters
	 */
	public SaleSlip () {
		this.salesID = 0;
		this.productID = 0;
		this.amount = 0.0;
	}
	
	/**
	 * constructor with parameters defined
	 * @param sale salesID
	 * @param product productID
	 * @param amount total value
	 */
	public SaleSlip (int sale, int product, double amount) {
		this.salesID = sale;
		this.productID = product;
		this.amount = amount;
	}

	/**
	 * this public method return the value of private attribute: salesID
	 * @return sales number
	 */
	public int getPerson() {
		return this.salesID;
	}
	
	/**
	 * this public method return the value of private attribute: productID
	 * @return product number
	 */
	public int getProduct() {
		return this.productID;
	}
	
	/**
	 * this public method return the value of private attribute: amount
	 * @return total value
	 */
	public double getValue() {
		return this.amount;
	}
	

}
