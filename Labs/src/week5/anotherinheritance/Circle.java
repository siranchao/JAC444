package week5.anotherinheritance;

public class Circle extends GObject{

	private double radius;
	
	public Circle() {}
	public Circle(String color, boolean filled) {
		
		super(color,filled);
		//setColor(color);
		//setFilled(filled);
	}
	public Circle(double radius,String color, boolean filled) {
		setColor(color);
		setFilled(filled);
		this.radius = radius;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	@Override
	public double getArea() {
		return radius * radius * Math.PI;
	}
	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", getColor()=" + getColor() + ", isFilled()=" + isFilled()
				+ ", getDateCreated()=" + getDateCreated() + "]";
	}
	
	
}
