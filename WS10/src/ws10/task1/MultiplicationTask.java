package ws10.task1;

public class MultiplicationTask implements Runnable{
	private int startRow;
	private int endRow;
	
	public MultiplicationTask(int startRow, int endRow) {
		this.startRow = startRow;
		this.endRow = endRow;
	}
	
	/**
	 * this method calculate multiply two static matrix by given starting/ending row of matrix A and assign results to matrix_C
	 */
	@Override
	public void run() {
		for(int i = startRow; i < endRow; i++) {
			for(int j = 0; j < MultiplyMatrix.col; j++) {
				double sum = 0.0;
				for(int k = 0; k < MultiplyMatrix.col; k++) {
					sum += MultiplyMatrix.matrix_A[i][k] * MultiplyMatrix.matrix_B[k][j];
				}
				
				MultiplyMatrix.matrix_C[i][j] = sum;
			}
		}
		
	}

}
