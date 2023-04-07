package week12.thread.runningcondtion;

public class TestRace {

	public static void main(String[] args) throws InterruptedException {
		BankAccount task = new BankAccount();
		task.setBalance(1000);
		task.setAmnt(950);
		
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		
		t1.setName("Frank");
		t2.setName("Jonathan");
		
		t1.start();
		//t1.join();
		t2.start();
	}
}
