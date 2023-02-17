package ws4.caseStudy;


/**
 * This class extends abstract Employee class which represent a concrete class of a particular employment type
 * Hourly employees are paid by the hour and receive overtime pay
 * @author Siran
 *
 */
public class HourlyEmployee extends Employee {
	private double wage;
	private double hours;
	
	/**
	 * Define a constructor with parameters
	 * this constructor validate wage and working hours, will throw an Exception when arguments are invalid
	 * @param firstName first name
	 * @param lastName last name
	 * @param ssn social security number
	 * @param wage hourly wage
	 * @param hours working hours
	 */
	public HourlyEmployee(String firstName, String lastName, String ssn, double wage, double hours) {
		super(firstName, lastName, ssn);
		if(wage <= 0.0) {
			throw new IllegalArgumentException("Invalid arguments when calling constructor: wage must greater than 0.0");
		}
		if(hours < 0.0 || hours > 168.0) {
			throw new IllegalArgumentException("Invalid arguments when calling constructor: working hours must between 0 to 168");
		}
		this.wage = wage;
		this.hours = hours;
	}
	
	/**
	 * Getter method
	 * @return hourly wage
	 */
	public double getWage() {
		return wage;
	}
	
	/**
	 * Getter method
	 * @return working hours
	 */
	public double getHours() {
		return hours;
	}
	
	@Override
	public String toString() {
		String msg = "\nEmployment Type: Hourly";
		return super.toString() + msg;
	}
	
	@Override
	/**
	 * this method implementS abstract method from Payable interface
	 */
	public double getPaymentAmount() {
		double amount = getHours() <= 40.0 ? getWage() * getHours() 
				: 
			(getWage() * 40.0) + (getWage() * (getHours() - 40.0) * 1.5);
		
		return amount;
	}
	
}
