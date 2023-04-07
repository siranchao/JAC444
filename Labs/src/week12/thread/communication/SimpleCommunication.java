package week12.thread.communication;

public class SimpleCommunication {

	private static String message;
	
	public static void main(String[] args) {
		
		Object lock  = new Object();
		
		Thread t1 = new Thread (()->{
			synchronized(lock) {
				while(message == null) {
					try {
						lock.wait();
					}catch(InterruptedException e) {}
				}
			}
			System.out.println(message);
		});
		
		Thread t2 = new Thread(()->{
			synchronized(lock) {
				message = "Message is ready to be printed";
				lock.notify();
			}
		});
		t1.start();
		t2.start();
	}
}
