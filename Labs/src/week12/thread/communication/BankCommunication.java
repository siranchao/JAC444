package week12.thread.communication;

public class BankCommunication {

	public static void main(String[] args) {
		Task t = new Task();
		
		new Thread() {
			public void run() {
				t.withdraw(1500);
			}
		}.start();
		
		new Thread() {
			public void run() {
				t.deposit(1000);
			}
		}.start();
	}
}

class Task{
	double amount = 1000;
	synchronized void withdraw(double amount) {
		System.out.println("Going to withDraw...");
		if(this.amount < amount ) {
			System.out.println("Less balance:  wait for the deposit to finish ");
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		
		this.amount -= amount;
		System.out.println("withdrawl is completed, and the new balance is " + this.amount);
	}
	
	synchronized void deposit(double amount) {
		System.out.println("going to deposit....");
		this.amount += amount;
		System.out.println("the deposit is complete, the current balance is now " + this.amount);
		notify();
	}
}
