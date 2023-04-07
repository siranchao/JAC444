package week12.thread.threads;

//OO-Design is Tightly Coupled Design Code
public class MyThread extends Thread{

	public static void main(String[] args){//Thread-0 {
		Thread t1 = new MyThread();
		t1.start();
		
		System.out.println("inside main....");
		simple();
	}
	
	@Override
	public void run() {
		System.out.println("Inside the run function...");
	}
	
	private static void simple() {
		System.out.println("Inside normal function");
	}
}
