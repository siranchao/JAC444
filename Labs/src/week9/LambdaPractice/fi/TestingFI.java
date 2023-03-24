package week9.LambdaPractice.fi;

public class TestingFI{// implements FunctionalInterfaceExample{

	public static void main(String[] args) {
		
		//() -> {return "Hello back from the me"};
		
		/*TestingFI obj = new TestingFI();
		System.out.println(obj.Hello());*/
		
		//FunctionalInterfaceExample fi = () ->  "Hello back from the me";
		//System.out.println(fi.Hello());
		
		FunctionalInterfaceExample a = ()-> { return (1 + 2);};
	}

/*	@Override
	public String Hello() {
		
		return "Hello back from me";
	}*/
}
