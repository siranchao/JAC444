package ws4.caseStudy;

/**
 * This class extends abstract Employee class which represent a concrete class of a particular employment type
 * Commission employees are paid a percentage of their sales
 * @author Siran
 *
 */
public class CommissionEmployee extends Employee {
	private double grossSales;
	private double commissionRate;
	
	/**
	 * Define a constructor with parameters
	 * this constructor validate grossSales and commission rate will throw an Exception when arguments are invalid
	 * @param firstName first name
	 * @param lastName last name
	 * @param ssn social security number
	 * @param grossSales sales amount
	 * @param commissionRate rate
	 */
	public CommissionEmployee(String firstName, String lastName, String ssn, double grossSales, double commissionRate) {
		super(firstName, lastName, ssn);
		if(grossSales <= 0.0) {
			throw new IllegalArgumentException("Invalid arguments when calling constructor: GrossSales must greater than 0.0");
		}
		if(commissionRate < 0.0 || commissionRate > 1.0) {
			throw new IllegalArgumentException("Invalid arguments when calling constructor: Commission Rate must between 0.0 to 1.0");
		}
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}
	
	/**
	 * Getter method
	 * @return Gross sales
	 */
	public double getGrossSales() {
		return grossSales;
	}

	/**
	 * Getter method
	 * @return Commission Rate
	 */
	public double getCommissionRate() {
		return commissionRate;
	}
	
	@Override
	public String toString() {
		String msg = "- Employment Type: Commission" + "\n- Commission Rate: " + getCommissionRate() + "\n- Sales Amount: " + getGrossSales();
		String footer = "\n--------------------------------------------";
		return super.toString() + msg + footer;
	}
	
	@Override
	/**
	 * this method implementS abstract method from Payable interface
	 */
	public double getPaymentAmount() {
		return getGrossSales() * getCommissionRate();
	}
	
	@Override
	/**
	 * this method implementS abstract method from Payable interface
	 */
	public void displayAmount() {
		System.out.println("Payment Amount: " + getPaymentAmount() + "\n");
	}
	
}
