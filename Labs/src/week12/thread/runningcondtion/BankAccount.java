package week12.thread.runningcondtion;

public class BankAccount implements Runnable{

	final String rs = "Something";
	private double balance;
	private double amnt;
	public void setAmnt(double amnt) {
		this.amnt = amnt;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public void run() {
		withdraw(amnt);
		synchronized (rs) {
			System.out.println("Thread is is locked");
		}
		if(balance < 0) {
			System.out.println("Money overdrawn...");
		}
	}
	private synchronized void withdraw(double amount) {
		if(balance >= amount) {
			System.out.println(Thread.currentThread().getName() + " is going to withdraw..");
			balance -= amount;
			System.out.println(Thread.currentThread().getName() + " has withdran " + amount);
		}
		else {
			System.out.println("Srry, not enough month for you to withdraw" + Thread.currentThread().getName());
		}
	}
}
