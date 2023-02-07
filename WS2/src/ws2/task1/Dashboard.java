package ws2.task1;


import java.text.DecimalFormat;

public class Dashboard {
	
	double[][] table;
	public static final int numOfSales = 4;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	
	public Dashboard() {
		table = new double[numOfSales][5];
	}
	
	
	public void convert(SaleSlip[][] data) {
		
//		for(int i = 0; i < data.length; i++) {
//			System.out.println("----- DAY " + (i+1));
//			for(int j = 0; j < data[i].length; j++) {
//				if(data[i][j] != null) {
//					System.out.println("Sales-" + data[i][j].getPerson() + "\t\t" + "Prod-" + data[i][j].getProduct() + "\t\t" + data[i][j].getValue());
//				}
//			}
//		}

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
	
	public void display() {

		System.out.println("--- Display Sales Overview ---");
		System.out.println("Person/Prod" + "\t\t" + "Prod-1" + "\t\t" + "Prod-2" + "\t\t" + "Prod-3" + "\t\t" + "Prod-4" + "\t\t" + "Prod-5" + "\t\t" + "Total");
		
		for(int i = 0; i < table.length; i++) {
			double totalByPerson = 0.0;
			System.out.print("Sale Person " + (i+1) + "\t\t");	

			for(int j = 0; j < table[i].length; j++) {
				System.out.print(df.format(table[i][j]) + "\t\t");	
				totalByPerson += table[i][j];
			}
			System.out.print(df.format(totalByPerson) + "\t\n");	
		}
		
		
		System.out.print("Total" + "\t\t\t");	
		
		for(int j = 0; j < 5; j++) {
			double totalByProd = 0.0;
			for(int i = 0; i < table.length; i++) {
				totalByProd += table[i][j];
			}
			System.out.print(df.format(totalByProd) + "\t\t");
		}
		System.out.println("\n");	
		
	}
	
	

}
