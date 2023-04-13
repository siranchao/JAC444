package ws10.task2;

public class Chopstick {
	
	private boolean inuse;
	
	public Chopstick(){
		this.inuse = false;
	}
	
	public synchronized void pickUp() {
		inuse = true;
	}
	
	public synchronized void putDown() {
		inuse = false;
	}
	
	public boolean inuse() {
		return inuse;
	}
	
}
