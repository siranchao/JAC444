package ws10.task2;

public class Chopstick {
	
	private int id;
	private boolean inuse;
	
	public Chopstick(int id){
		this.id = id;
		this.inuse = false;
	}
	
	public int getId() {
		return id;
	}
	
	public void pickUp() {
		inuse = true;
	}
	
	public void putDown() {
		inuse = false;
	}
	
	public boolean status() {
		return inuse;
	}
	
}
