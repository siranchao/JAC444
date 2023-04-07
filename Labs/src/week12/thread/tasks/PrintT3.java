package week12.thread.tasks;

public class PrintT3 implements Runnable{

	private int num;
	public PrintT3(int i) {
		num = i;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		for(int j=0; j<num; j++)
			System.out.print(" " + j);
		System.out.println();
	}
	
}
