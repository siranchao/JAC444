package ws2.task2;

/**
 * The class create an object represent the item to be purchased with name/price/quantity
 * @author Siran
 *
 */
public class GroceryItemOrder {

	/**
	 * properties for each item order
	 */
	public String name;
	public int qty;
	public double price;
	
	/**
	 * this constructor without parameter create a empty object
	 */
	public GroceryItemOrder() {
		this.name = "";
		this.qty = 0;
		this.price = 0.0;
	}

	/**
	 * this constructor create a valid object with parameter
	 * @param name item name
	 * @param qty quantity
	 * @param price price per unit
	 */
	public GroceryItemOrder(String name, int qty, double price) {
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	
	/**
	 * this method returns the total cost of the item in its given quantity
	 * @return total cost
	 */
	public double getCost() {
		return this.price*this.qty;
	}
	
	/**
	 * this method sets this grocery item’s quantity to be the given value
	 * @param qty new quantity
	 */
	public void setQuantity(int qty) {
		this.qty = qty;
	}
	
}
