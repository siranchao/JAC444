package week12.thread.tasks;

public class PrintT2 implements Runnable
{

	private String sToP;
	private int not;
	
	public PrintT2(String s, int not) {
		this.sToP = s;
		this.not = not;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		for(int i =0; i<not; i++)
			System.out.print(" " + sToP);
		System.out.println();
	}

}
