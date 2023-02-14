package week5.anotherinheritance;

public abstract class GObject {

	private String color;
	private boolean filled;
	private java.util.Date dateCreated;
	
	public GObject() {
		dateCreated = new java.util.Date();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public java.util.Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(java.util.Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "GObject [color=" + color + ", filled=" + filled + ", dateCreated=" + dateCreated + "]";
	}

	public GObject(String color, boolean filled) {
		
		this.color = color;
		this.filled = filled;
		
	}
	
	public abstract double getArea();
	
}
