package week5.anotherinheritance;

class Check{
	public Check(String name) {
		System.out.println("Checking your name "  + name);
	}
}
public class CheckClass extends Check{
	public CheckClass(String name) {
		super(name);
		
	}

	public static void main(String[] args) {
		Check c = new Check("Frank");
	}
}
