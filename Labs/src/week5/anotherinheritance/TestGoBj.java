package week5.anotherinheritance;

public class TestGoBj {

	public TestGoBj() {
		super();
		super.equals(getClass());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GObject go = new Circle();
		
		Circle c = new Circle(1.2,"Red",true);//raw type object
		System.out.println(c);
		Circle cc = new CircleChild();

		//GObject[] objArr = new GObject[4];
		
		displayObject(new Circle());
		displayObject(new Rectangle());
		
		System.out.println(cc.getArea());
		
		
	}

	private static void displayObject(GObject gObject) {
		
		System.out.println("Created on " + gObject.getDateCreated());
		if(gObject instanceof Rectangle)
			System.out.println("g"+((Rectangle) gObject).getWidth());
		else
			System.out.println("First time it was circle here");
		
	}

}
