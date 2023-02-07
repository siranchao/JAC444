package ws2.task2;

import java.text.DecimalFormat;
/**
 * This class create an object represents a list of items to buy from the market. 
 * the object use GroceryItemOrder type array to store data and use dynamically tracking the actual items in the list
 * @author Siran
 *
 */
public class GroceryList {
	
	/**
	 * the shoppingList store items in array, and tracking valid array elements
	 */
	public GroceryItemOrder[] shoppingList;
	public int itemNum;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	/**
	 * Constructs a new empty grocery list. Length specified by global constant
	 */
	public GroceryList() {
		shoppingList = new GroceryItemOrder[Test.maxItems];
		itemNum = 0;
	}
	
	/**
	 * this method adds a given item to this list if the list is not full
	 * @param item new item to be added
	 */
	public void add(GroceryItemOrder item) {
		if(itemNum < Test.maxItems) {
			shoppingList[itemNum] = new GroceryItemOrder(item.name, item.qty, item.price);
			itemNum++;
			System.out.println("New Item added: " + item.name + " --- Qty: " + item.qty);
		}
		else {
			System.out.println("Cannot add new item, the Grocery List is full");
		}
	}
	
	/**
	 * this method calculate total sum cost of all grocery item orders in this list
	 * @return the total sum of all list element
	 */
	public double getTotalCost() {
		double total = 0.0;
		
		for(int i = 0; i < itemNum; i++) {
			total += shoppingList[i].getCost();
		}
		
		return total;
	}
	
	
	/**
	 * this method will display every valid elements inside the shoppinglist and generate a sub total
	 */
	public void show() {
		System.out.println("--- Shopping List Summary ---");
		System.out.println("Name\t\t" + "Qty\t\t" + "Price\t\t" + "Cost");
		
		double subtotal = 0.0;
		for(int i = 0; i < itemNum; i++) {
			System.out.println(shoppingList[i].name + "\t\t" + shoppingList[i].qty + "\t\t$" + shoppingList[i].price + "\t\t$" + df.format(shoppingList[i].getCost()));
			subtotal += shoppingList[i].getCost();
		}
		
		System.out.println("Subtotal:\t$" + df.format(subtotal));
		
		
	}

}
