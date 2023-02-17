package ws4.caseStudy;


/**
 * This class extends CommissionEmployee class which represent a more specific type of CommissionEmployee 
 * Base-salaried commission employees receive a base salary plus a percentage of their sales
 * @author Siran
 *
 */
public class BasePlusCommissionEmployee extends CommissionEmployee {
	private double baseSalary;
	
	/**
	 * Define a constructor with parameters
	 * this constructor validate base salary will throw an Exception when arguments are invalid
	 * @param firstName first name
	 * @param lastName last name
	 * @param ssn social security number
	 * @param grossSales sales amount
	 * @param commissionRate rate
	 * @param baseSalary base salary
	 */
	public BasePlusCommissionEmployee(String firstName, String lastName, String ssn, double grossSales, double commissionRate, double baseSalary) {
		super(firstName, lastName, ssn, grossSales, commissionRate);
		if(baseSalary <= 0.0) {
			throw new IllegalArgumentException("Invalid arguments when calling constructor: Base salary must greater than 0.0");
		}
		this.baseSalary = baseSalary;
	}
	
	
	/**
	 * Getter method
	 * @return base salary
	 */
	public double getBaseSalary() {
		return baseSalary;
	}
	
	/**
	 * Setter method
	 * @param increase percentage
	 */
	public void setBaseSalary(double increase) {
		baseSalary *= (increase + 1.0);
	}
	
	
	@Override
	public String toString() {
		String msg = "\n- Employment Type: Commission & Base" + "\n- With Base Salary: " + getBaseSalary();
		String footer = "\n--------------------------------------------";
		return super.toString() + msg + footer;
	}
	
	@Override
	public double getPaymentAmount() {
		return getBaseSalary() * 2 + super.getPaymentAmount();
	}
	
	@Override
	/**
	 * this method implementS abstract method from Payable interface
	 */
	public void displayAmount() {
		System.out.println("Payment Amount: " + getPaymentAmount() + "\n");
	}
	
}
