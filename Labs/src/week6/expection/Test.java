package week6.expection;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {

	private double insertRate;
	private int numOfMonths;
	private double getHousePrice;
	
	public double computeMortgagePayments() {
		double monthRate = this.insertRate / 12;
		System.out.println("monthRate = " + monthRate);
		
		double amortizeRate = (1-Math.pow(monthRate, numOfMonths -1));
		System.out.println(amortizeRate);
		return getHousePrice * monthRate/amortizeRate;
	}
	
	public static void openFile(String fileName)throws FileNotFoundException, ClassNotFoundException, IOException  {
		
	}
	
	public static void main(String[] args) {
		
			try {
				openFile("abc.txt");
			} catch (ClassNotFoundException | IOException e) {
				
				e.printStackTrace();
			}
			finally {
				
			}
		
	}
	
}
