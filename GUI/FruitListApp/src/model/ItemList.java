package model;

public class ItemList {

	public final int MAX_SIZE = 100;
	
	private String[] items;
	private int size;
	
	public ItemList() {
		items = new String[MAX_SIZE];
		size = 0;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public String[] getItem() {return items;}
	
	public void add(String item) {
		if(size<MAX_SIZE) {
			items[size++] = item;
		}
	}
	
	public void remove(int index) {
		if((index>=0) && (index < size)) {
			for(int i=index; i<size; i++)
				items[i] = items[i+1];
			size--;
		}
	}
}
