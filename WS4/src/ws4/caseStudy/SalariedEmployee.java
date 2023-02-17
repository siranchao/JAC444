package ws4.caseStudy;


/**
 * This class extends abstract Employee class which represent a concrete class of a particular employment type
 * Salaried employees are paid a fixed weekly salary regardless of the number of hours worked
 * @author Siran
 *
 */
public class SalariedEmployee extends Employee{
	private double weeklySalary;
	
	/**
	 * Define a constructor with parameters
	 * this constructor validate weeklySalary, will throw an Exception when argument is invalid
	 * @param firstName
	 * @param lastName
	 * @param ssn
	 * @param weeklySalary
	 */
	public SalariedEmployee(String firstName, String lastName, String ssn, double weeklySalary) {
		super(firstName, lastName, ssn);
		if(weeklySalary <= 0.0) {
			throw new IllegalArgumentException("Invalid arguments when calling constructor: weekly salary must greater than 0.0");
		}
		this.weeklySalary = weeklySalary;
	}
	
	/**
	 * Getter method
	 * @return weekly salary
	 */
	public double getWeeklySalary() {
		return weeklySalary;
	}
	
	@Override
	public String toString() {
		String msg = "\nEmployment Type: Fixed Salary" + "\nWeekly Salary: " + getWeeklySalary();
		return super.toString() + msg;
	}
	
	
	@Override
	/**
	 * this method implementS abstract method from Payable interface
	 */
	public double getPaymentAmount() {
		return getWeeklySalary() * 4;
	}
	
	
}
