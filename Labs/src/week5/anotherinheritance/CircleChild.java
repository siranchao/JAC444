package week5.anotherinheritance;


//super() is to call super class constructor
//super is used to call the super class function and has to be used in the child function

public class CircleChild extends Circle{
	
	private double cRadius;
	
	@Override
	public double getArea() {
		return super.getArea();
		//return 5.5;
	}
}
