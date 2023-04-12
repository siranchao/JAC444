package ws10.task2;

public class Person implements Runnable{

	private int id;

	public Person(int id) {
		this.id = id;
		System.out.println("Philosopher #" + (id + 1) + " has joined the table");
	}

	
	@Override
	public void run() {
		
		//find my chopsticks
		int left = id;
		int right = (id == 4 ? 0 : id + 1);
		
		System.out.println("Philosopher #" + (id + 1) + " trying to eat");
		
		//always pickup left chopstick first
		synchronized(Table.CHOPSTICKS[left]) {
			System.out.println("Philosopher #" + (id + 1) + " pick up the left");
			
			//wait for right chop to be available
			synchronized (Table.CHOPSTICKS[right]) {
	            while(!Thread.holdsLock(Table.CHOPSTICKS[right])) {
	            	try {
	            		Table.CHOPSTICKS[left].wait();
	            		Thread.sleep(1000);
	            	}
	            	catch(InterruptedException e) {}
	            }
	            
//	            else {
//	            	//pick up right chopstick 
//					System.out.println("Philosopher #" + (id + 1) + " picked up both chopsticks and start eating...");
//	                try {
//						Thread.sleep(2000);
//					} 
//	                catch (InterruptedException e) {}
//	            }
	        }

//			synchronized(Table.CHOPSTICKS[right]) {
//				
//				System.out.println("Philosopher #" + (id + 1) + " picked up both chopsticks and start eating...");
//                Thread.sleep(2000);
//			}
			
			//put down both
			Table.CHOPSTICKS[left].notifyAll();
			Table.CHOPSTICKS[right].notifyAll();
			
			System.out.println("Philosopher #" + (id + 1) + " put down both chopsticks and finish eating\n");
		}
	}
	
	private boolean checkRight(int index) {
        synchronized (Table.CHOPSTICKS[index]) {
            return !Thread.holdsLock(Table.CHOPSTICKS[index]);
        }
    }
	
	
	
}
