package Lab_code;

public class Circle {
	
	double radius = 0.0;
	
	
	//explicitly define a constructor
	public Circle(double radius) {
		this.radius = radius;
	}
	
	
	public static double giveNum() {
		//use class wrapper to case data type
		return Double.valueOf("2.2");
	}
	
	@Override
	public String toString() {
		return "The value of the radius is: " + radius;
	}
	
	public static void main(String[] args) {
		Circle cir = new Circle(5.6);
		Circle cir2 = new Circle(1.0);
		
		//System.out.println(cir);
		//System.out.println(giveNum());
		
		cir = cir2;
		System.out.println(cir);
	}

}
