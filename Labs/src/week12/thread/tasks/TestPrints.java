package week12.thread.tasks;

public class TestPrints {

	public static void main(String[] args) throws InterruptedException {
		Runnable pc = new PrintT1('a',20);
		//Runnable ps = new PrintT2("Hello", 20);
		//Runnable pn = new PrintT3(20);
		
		Thread t1 = new Thread(pc);
		Thread t2 = new Thread(new PrintT2("Hello", 20));
		Thread t3 = new Thread(new PrintT3(20));
		
		System.out.println(Thread.currentThread());
		//main,5,main
		
		t1.setName("Character Thread");
		t2.setName("String Thread");
		//MIN (1), Mid (5), Max(10)
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		
		//t1.join();
		
		t2.start();
		t3.start();
		
		
		
	}
}
