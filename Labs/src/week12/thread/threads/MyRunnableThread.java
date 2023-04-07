package week12.thread.threads;

//OO-Design for Loosely coupled design
public class MyRunnableThread{
	public static void main(String[] args) {
		Task t = new Task();
		Thread t1 = new Thread(t);
		t1.start();
		t1.run();//is not going to start your thread....this is calling a normal function inside main thread
	}
}

 class Task implements Runnable{

	@Override
	public void run() {
		System.out.println("Inside the run function....");
		
		
	}
}
