package ws4.caseStudy;

/**
 * The Employee class is an abstract class which implements Payable interface without define its abstract method
 * the class represent the super class for all kinds of employees and it cannot be instantiated 
 * @author Siran
 *
 */
public abstract class Employee implements Payable{
	private String firstName;
	private String lastName;
	private String ssn;
	
	/**
	 * Define no-arg constructor and set initial values
	 */
	public Employee() {
		firstName = "";
		lastName = "";
		ssn = "";
	}
	
	/**
	 * Define a constructor with parameters and set initial values
	 * @param firstName first name
	 * @param lastName last name
	 * @param ssn social security number
	 */
	public Employee(String firstName, String lastName, String ssn) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
	}
	
	
	@Override
	public String toString() {
		String msg = "Employee Name: " + getFirstName() + " " + getLastName() + "\nSocial Security Number: " + getSSN();
		return msg;
	}
	
	
	/**
	 * Getter method
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Getter method
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Getter method
	 * @return social security number
	 */
	public String getSSN() {
		return ssn;
	}
	
	
}
