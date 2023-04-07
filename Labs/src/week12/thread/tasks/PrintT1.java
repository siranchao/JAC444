package week12.thread.tasks;

public class PrintT1 implements Runnable
{

	private char charToP;
	private int not;
	
	public PrintT1(char c, int not) {
		this.charToP = c;
		this.not = not;
	}
	
	@Override
	public void run() {
		for(int i =0; i<not; i++) {
			System.out.println(Thread.currentThread().getName());
			if(i==10) {
				Thread.currentThread();
				Thread.currentThread().yield();
			}
			System.out.print(" "+ charToP);
		}
		System.out.println();
	}

}
