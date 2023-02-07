package ws2.task1;

import java.util.Random;
/**
 * This class will randomly generate Slip data with given days and number of salesman
 * all data will be stored in a 2D array with type SaleSlip[][]
 * @author Siran
 *
 */
public class SlipGenerator {
	
	/**
	 * pool store all slip data in one 2D array
	 */
	public SaleSlip[][] pool;
	
	
	/**
	 * constructor without params define size of the data pool with days
	 */
	public SlipGenerator() {
		pool = new SaleSlip[Test.days][Test.numOfSales*Test.productList.length];
		System.out.println("--- Data generator initiated ---");
	}

	
	/**
	 * this method randomly generate an array of Slip to record a salesman's daily performance
	 * the method randomly decide how many and which product the salesman sold and generate an array without duplicate product
	 * random sales amount per slip $10.0 - $100.00
	 * @param salesID sales number
	 * @return array of Slip sold per day
	 */
	private SaleSlip[] dailySlip(int salesID) {
		int[] productList = (int[])Test.productList.clone();
		
		//how many slips made today
		int num = (int)(Math.random() * (productList.length + 1));
		
		//which products sold today
		int[] products = new int[num];
		Random rand = new Random();
		
		for(int i = 0; i < num; i++ ) {
			int randomIndex = rand.nextInt(productList.length - i);
			products[i] = productList[randomIndex];
			productList[randomIndex] = productList[productList.length - i - 1];
		}
		
		//generate daily slip array
		SaleSlip[] dailySlip = new SaleSlip[num];
		for(int i = 0; i < num; i++) {
			//random sales amount $10.0 - $100.00
			double randValue = 10.0 + (Math.random() * (100.0 - 10.0));
			double roundValue = Math.round(randValue * 100.0) / 100.0;
			dailySlip[i] = new SaleSlip(salesID, products[i], roundValue);
		}
		
		return dailySlip;
	}
	
	/**
	 * this method will populate data for the DD array member within the class
	 * the method iterates certain days(rows) and each day: copy results from all 4 salesman into one array(columns)
	 */
	public void generateData() {
		for(int i = 0; i < pool.length; i++) {

			for(int j = 1, k = 0; j <= Test.numOfSales; j++) {
				SaleSlip[] result = dailySlip(j);
				System.arraycopy(result, 0, pool[i], k, result.length);
				k += result.length;
			}
		}
		System.out.println("--- Mock Data Generated ---");
	}
	
	

}
