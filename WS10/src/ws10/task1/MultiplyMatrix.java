package ws10.task1;

import java.text.DecimalFormat;
import java.util.Random;

public class MultiplyMatrix {
	public static int row = 2000;
	public static int col = 2000;
	public static int threads = 4;
	
	public static long startTime, elapsedTime;
	
	public static double[][] matrix_A = new double[row][col];
	public static double[][] matrix_B = new double[row][col];
	public static double[][] matrix_C = new double[row][col];
	
	private static DecimalFormat df = new DecimalFormat("0.00");
	

	/**
	 * this method will populate two 2D array with random values
	 */
	public static void initMatrix() {
		Random rand = new Random();
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				matrix_A[i][j] = rand.nextDouble() * 10;
				matrix_B[i][j] = rand.nextDouble() * 10;
			}
		}
		System.out.println("===== Matrix_A and Matrix_B numbers generated! =====");
	}
	
	
	/**
	 * this method display the 2D matrix into the console
	 * @param a matrix array
	 * @param name matrix name
	 */
	public static void displayMatrix(double[][] a, String name) {
		System.out.println("Matrix_" + name);
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(j < 5) 
					System.out.print(df.format(a[i][j]) + "\t");
				if(j >= 5 && j < (col-5)) {
					j += (col-10);
					System.out.print("..." + "\t");
				}
				if(j >= (col-5))
					System.out.print(df.format(a[i][j]) + "\t");
			}
			
			if(i < 4)
				System.out.println();
			if(i >= 4 && i < (row-5)) {
				i += (row-10);
				System.out.print("\n...\n...\n");
			}		
			if(i >= (row-5))
				System.out.println();
		}
		System.out.println();
	}
	
	
	
	/**
	 * this method use multi-threading to multiple two static matrix defined in class
	 * @return an new 2D array matrix
	 * @throws InterruptedException
	 */
	public static double[][] parallelMultiply() throws InterruptedException{
		//assign threads and execute
		Thread[] taskList = new Thread[threads];
		int taskSize = row / threads;
		
		for(int i = 0; i < threads; i++) {
			int startRow = i * taskSize;
			int endRow = (i + 1) * taskSize;
			taskList[i] = new Thread(new MultiplicationTask(startRow, endRow));
		}
			
		for(int i = 0; i < threads; i++) {
			taskList[i].start();
		}
		
		//wait for threads finish working
		for(int i = 0; i < threads; i++) {
			taskList[i].join();
		}

		
		//copy and return results
		double[][]val = new double[row][col];	
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				val[i][j] = matrix_C[i][j];
			}
		}
		return val;
	}
	
	
	
	/**
	 * this method create Runnable object and call run() to act as single thread to perform same multiple matrix action
	 * @return an new 2D array matrix
	 */
	public static double[][] sequentialMultiply(){
		MultiplicationTask singleTask = new MultiplicationTask(0, row);
		singleTask.run();
		
		//copy and return results
		double[][]val = new double[row][col];	
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				val[i][j] = matrix_C[i][j];
			}
		}
		return val;
	}
	

	
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		initMatrix();
		displayMatrix(matrix_A, "A");
		displayMatrix(matrix_B, "B");
		
		
//		System.out.println("===== Start testing sequential multiply matrix =====");
//		startTime = System.nanoTime();
//		sequentialMultiply();
//		elapsedTime = System.nanoTime() - startTime;
//		System.out.println("===== Execution complete =====");
//		System.out.println("Elapsed Time is: " + (elapsedTime/1000000.0) + "  msec");
//		displayMatrix(matrix_C, "results");
		
		System.out.println("\n\n");
		System.out.println("===== Start testing parallel multiply matrix(total threads: " + threads + ") =====");
		startTime = System.nanoTime();
		parallelMultiply();
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("===== Execution complete =====");
		System.out.println("Elapsed Time is: " + (elapsedTime/1000000.0) + "  msec");
		displayMatrix(matrix_C, "results");
		
		
		
	}
	
	
	

}
