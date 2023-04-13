package ws10.task2;

public class Person implements Runnable{

	private int id;

	public Person(int id) {
		this.id = id;
		System.out.println("Philosopher #" + (id + 1) + " has joined the table");
	}

	
	/**
	 * This method use nested condition approach
	 */
	@Override
	public void run() {
		//find my chopsticks
		int left = id;
		int right = (id == 4 ? 0 : id + 1);
		
		boolean run = true;
		while(run) {
			//try to pickup left chopstick first
			if(!Table.Chopsticks[left].inuse()) {
				Table.Chopsticks[left].pickUp();
				System.out.println("Philosopher #" + (id + 1) + " pick up");
		        try {
		            Thread.sleep(1000);
		        } catch (InterruptedException e) {}
				
				//try to pickup right
				//important: when waiting for right must put down left
				if(!Table.Chopsticks[right].inuse()) {
					Table.Chopsticks[right].pickUp();
					System.out.println("Philosopher #" + (id + 1) + " pick up");
					System.out.println("Philosopher #" + (id + 1) + " now have two chopsticks ---> start eating...\n");

			        try {
			            Thread.sleep(2000);
			        } catch (InterruptedException e) {}
			        
			        Table.Chopsticks[right].putDown();
			        Table.Chopsticks[left].putDown();
			        run = false;
				}
				else {
					Table.Chopsticks[left].putDown();
					System.out.println("Philosopher #" + (id + 1) + " put down");
				}
			}
			//wait for next round
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {}
		}
		
		System.out.println("Philosopher #" + (id + 1) + " put down both chopsticks ---> finish eating\n");
	}
	
	
	
	/**
	 * This method use reentrant lock approach, use ReentrantLock object to replace custom class Chopstick
	 */
//	@Override
//	public void run() {
//		//find my chopsticks
//		int left = id;
//		int right = (id == 4 ? 0 : id + 1);
//	
//		boolean run = true;
//		while(run) {
//			
//			//pick up left			
//			if(Table.CHOPSTICKS[left].tryLock()) {
//				System.out.println("Philosopher #" + (id + 1) + " pick up");
//				
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {}
//				
//				//pick up right
//				
//				if(Table.CHOPSTICKS[right].tryLock()) {
//					System.out.println("Philosopher #" + (id + 1) + " pick up");
//					System.out.println("Philosopher #" + (id + 1) + " now have two chopsticks ---> start eating...\n");
//
//				    try {
//				        Thread.sleep(2000);
//				    } catch (InterruptedException e) {}
//				    
//				    
//					Table.CHOPSTICKS[left].unlock();
//					Table.CHOPSTICKS[right].unlock();
//					System.out.println("Philosopher #" + (id + 1) + " put down both chopsticks ---> finish eating\n");
//					run = false;
//					
//				} else {
//					//put down left if acquire right failed
//					Table.CHOPSTICKS[left].unlock();
//					System.out.println("Philosopher #" + (id + 1) + " put down");
//				}
//			}
//			
//			//wait for next round
//	        try {
//	            Thread.sleep(1000);
//	        } catch (InterruptedException e) {}
//		}
//	}
	
	
	
}
