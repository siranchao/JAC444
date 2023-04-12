package ws10.task2;

import java.util.ArrayList;
import java.util.List;

public class Table {
	
	public static final int NUM_PPL = 5;
	public static final Chopstick[] CHOPSTICKS = new Chopstick[NUM_PPL];
	
	
	public static void main(String[] args) throws InterruptedException {
		
		//create 5 Chopsticks
		for(int i = 0; i < 5; i++) {
			CHOPSTICKS[i] = new Chopstick(i);
		}
		
		//init and run 5 threads
		Thread[] tasks = new Thread[NUM_PPL];
		for(int i = 0; i < 5; i++) {
			tasks[i] = new Thread(new Person(i));
		}
		System.out.println("\n");
		
		
		for(int i = 0; i < 5; i++) {
			tasks[i].start();
		}
		
	}

}
