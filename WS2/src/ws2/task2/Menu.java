package ws2.task2;

import java.util.Arrays;

/**
 * This class represent a menu with products, with behavior of display menu and select items on it
 * @author Siran
 *
 */
public class Menu {
	/**
	 * two parallel arrays list item name and price
	 */
	private String[] itemList;
	private double[] priceList;
	
	/**
	 * this constructor without params creates empty object with empty array
	 */
	public Menu() {
		itemList = new String[Test.maxItems];
		priceList = new double[Test.maxItems];
		System.out.println("--- Empty Menu Created ---");
	}
	
	/**
	 * this constructor with params creates menu object with given products and prices
	 * @param itemList the product list
	 * @param priceList the matched prices
	 */
	public Menu(String[] itemList, double[] priceList) {
		this.itemList = Arrays.copyOf(itemList, Test.maxItems);
		this.priceList = Arrays.copyOf(priceList, Test.maxItems);
		System.out.println("--- New Menu Created ---");
	}
	
	/**
	 * this method simply display all the items on the menu
	 */
	public void display() {
		System.out.println("--- Please select item from the menu ---");
		System.out.println("#\t"+"Item Name" + "\t\t\t" + "Unit Price");
		
		for(int i = 0; i < Test.maxItems; i++) {
			System.out.println((i+1) + "\t" + itemList[i] + "\t\t\t\t" + priceList[i]);
		}	
	}
	
	/**
	 * this method receives several params from user's inputs, and create a new GroceryItemOrder
	 * @param index item number
	 * @param qty quantity
	 * @return a new itemOrder
	 */
	public GroceryItemOrder order(int index, int qty) {
		GroceryItemOrder newOrder = new GroceryItemOrder(itemList[index-1], qty, priceList[index-1]);
		return newOrder;	
	}
	
	
}
