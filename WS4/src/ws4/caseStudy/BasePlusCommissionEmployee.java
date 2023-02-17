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
	 * @param firstName
	 * @param lastName
	 * @param ssn
	 * @param grossSales
	 * @param commissionRate
	 * @param baseSalary
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
	
	
	@Override
	public String toString() {
		String msg = "\nEmployment Type: Base and Commission" + "\nBase Salary: " + getBaseSalary();
		return super.toString() + msg;
	}
	
	@Override
	public double getPaymentAmount() {
		return getBaseSalary() * 1.1 + super.getPaymentAmount();
	}
	
}
