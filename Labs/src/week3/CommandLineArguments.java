package week3;

public class CommandLineArguments {

	public static void main(String[] args) {
		if(args.length > 0) {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);//44
			
			System.out.println("The addition of values is: " + (a+b));
		}
		else {
			System.out.println("Please enter a proper integer value...");
		}
	}
}
