package week5.anotherinheritance;

public class Rectangle extends GObject{
	private double width;
	private double height;
	public Rectangle() {}
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", getColor()=" + getColor() + ", isFilled()="
				+ isFilled() + ", getDateCreated()=" + getDateCreated() + "]";
	}
	@Override
	public double getArea() {
		return width * height;
	}
	
	
}
