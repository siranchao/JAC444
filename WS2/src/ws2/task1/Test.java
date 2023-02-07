/**********************************************
Workshop 2
Course: JAC444
Last Name: CAO
First Name: Siran
ID: 159235209
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 02/27/2023
**********************************************/


package ws2.task1;

/**
 * This class defines key constants of the program and test the functionalities in its main() method
 * @author Siran
 *
 */
public class Test {
	/**
	 * defined number of salesman
	 * defined days required by data generator
	 * defined product list
	 */
	public static final int numOfSales = 6;
	public static final int days = 30;
	public static final int[] productList = {1, 2, 3, 4, 5, 6, 7};
	
	

	/**
	 * to test the program, instantiate SlipGenerator; and create mockdata by calling method generateData();
	 * instantiate Dashboard, and convert last month Slip data into summary 2D array by calling convert(SaleSlip[][] rawData);
	 * and print the table by calling display()
	 * @param args
	 */
	public static void main(String[] args) {
		
		SlipGenerator mockData = new SlipGenerator();
		mockData.generateData();
		
		Dashboard dashboard = new Dashboard();
		dashboard.convert(mockData.pool);
		
		dashboard.display();
		
	}

}
