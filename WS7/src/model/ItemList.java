package model;

import java.util.ArrayList;


/**
 * this class represent a dynamic ArrayList holding AddressItem objects
 * able to access and modify items inside it
 * @author Siran
 *
 */
public class ItemList {
	
	private ArrayList<AddressItem> itemList;
	
	/**
	 * this constructor will create a empty arryList
	 */
	public ItemList() {
		itemList = new ArrayList<>();
	}
	
	
	/**
	 * this method return the size of the list
	 * @return size number
	 */
	public int size() {
		return itemList.size();
	}
	
	
	/**
	 * this method will add a new address object into the list
	 * @param item new address
	 */
	public void add(AddressItem item) {
		itemList.add(item);
	}
	
	
	/**
	 * this method will remove a item on the specific index
	 * @param index
	 */
	public void remove(int index) {
		itemList.remove(index);
	}
	
	
	/**
	 * this method iterate the arrayList and return a normal array with only name inside
	 * @return string type array
	 */
	public String[] getStrArray() {
		String[] strArray = new String[itemList.size()];
		
		for(int i = 0; i < itemList.size(); i++) {
			strArray[i] = itemList.get(i).toString();
		}
		return strArray;
	}

}
