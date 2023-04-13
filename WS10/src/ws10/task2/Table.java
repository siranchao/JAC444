/**********************************************
Workshop 10
Course: JAC444
Last Name: CAO
First Name: Siran
ID: 159235209
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 04/13/2023
**********************************************/

package ws10.task2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Table {
	
	public static final int NUM_PPL = 5;
	public static final Lock[] CHOPSTICKS = new ReentrantLock[NUM_PPL];
	public static final Chopstick[] Chopsticks = new Chopstick[NUM_PPL];
	
	
	public static void main(String[] args) throws InterruptedException {
		
		//create 5 Chopsticks
		for(int i = 0; i < 5; i++) {
			CHOPSTICKS[i] = new ReentrantLock();
			Chopsticks[i] = new Chopstick();
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
		
		//wait all thread to join
		for(int i = 0; i < 5; i++) {
			tasks[i].join();
		}
		System.out.println("===== All Philosophers finish his meal =====");
	}

}
