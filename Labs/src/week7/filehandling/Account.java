package week7.filehandling;

import java.io.Serializable;

public class Account implements Serializable{

	private int accNum;
	private String fName;
	private String lName;
	private double accBala;
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public int getAccNum() {
		return accNum;
	}
	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}
	
	public double getAccBala() {
		return accBala;
	}
	public void setAccBala(double accBala) {
		this.accBala = accBala;
	}
	
	public Account(String name) {
		this.fName = name;
	}
	public Account(int accNum, String fName, String lName, double accBala) {
		this.accNum = accNum;
		this.fName = fName;
		this.lName = lName;
		this.accBala = accBala;
	}
	
	public void deposit(int amount) {
		this.accBala += amount;
	}
	
	public void withdraw(int amount) {
		this.accBala -= amount;
	}
}
