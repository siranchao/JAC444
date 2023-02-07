package ws2.task1;

import java.text.DecimalFormat;

/**
 * This class will create a Dashboard object, convert raw data into 2D array by person/product dimensions and illustrate the 2D array into table view
 * @author Siran
 *
 */
public class Dashboard {
	
	/**
	 * declare 2D array by person/product dimensions, and format decimal df
	 */
	double[][] table;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	
	/**
	 * this constructor will define the structure of the 2D array based on static constant from Test(people and product)
	 */
	public Dashboard() {
		table = new double[Test.numOfSales][Test.productList.length];
	}
	
	
	/**
	 * this method receives raw data from SlipGenerator, convert 2D array of SaleSlip type into 2D array with double type and different structure
	 * @param data raw data with type of SaleSlip[][] 
	 */
	public void convert(SaleSlip[][] data) {
	
		for(int i = 0; i < data.length; i++) {
			
			for(int j = 0; j < data[i].length; j++) {
				//check if the slip is valid
				if(data[i][j] != null) {
					int salesID = data[i][j].getPerson();
					int productID = data[i][j].getProduct();
					double amount = data[i][j].getValue();		
				
					table[salesID-1][productID-1] += amount;				
				}
			}
		}
		System.out.println("--- Data convert completed ---");
		
	}
	
	/**
	 * this method simply display the 2D array with person/product dimensions, and use 2 decimal format
	 */
	public void display() {
		//print header
		System.out.println("--- Display Sales Overview ---");
		System.out.print("Person/Prod" + "\t\t");
		for(int i = 0; i < Test.productList.length; i++) {
			System.out.print("Prod-" + (Test.productList[i]) + "\t\t");
		}
		System.out.print("Total" + "\t\n");

		
		//print rows
		for(int i = 0; i < table.length; i++) {
			double totalByPerson = 0.0;
			System.out.print("Sale Person " + (i+1) + "\t\t");	

			for(int j = 0; j < table[i].length; j++) {
				System.out.print(df.format(table[i][j]) + "\t\t");	
				totalByPerson += table[i][j];
			}
			System.out.print(df.format(totalByPerson) + "\t\n");	
		}
		
		
		//print sum row
		System.out.print("Total" + "\t\t\t");	
		for(int j = 0; j < Test.productList.length; j++) {
			double totalByProd = 0.0;
			for(int i = 0; i < table.length; i++) {
				totalByProd += table[i][j];
			}
			System.out.print(df.format(totalByProd) + "\t\t");
		}
		System.out.println("\n");	
		
	}

	
}
