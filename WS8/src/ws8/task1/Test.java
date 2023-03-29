package ws8.task1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	private double[] arr;
	
	public Test() {
		arr = new double[5];
	}
	
	
	public void scan(Scanner scanner) {
		boolean flag = false;
		while(!flag) {
			try {
				for (int i = 0; i < arr.length; i++) {
		            System.out.print("Enter a double value for index " + i + ": ");
		            arr[i] = scanner.nextDouble();
		        }
				flag = true;
			}
			catch(InputMismatchException e) {
				e.printStackTrace();
				System.out.println("Invalid input, please enter double number only");
				scanner.nextLine();
			}
		}

        System.out.println("Array filled with user input values:");
        for (double element : arr) {
            System.out.println(element);
        }
	}

	
	public void menu(Scanner scanner) {
		int selection = -1;

		while(selection != 0) {	
			try {
	            System.out.println("1. find the maximum value in the array");
	            System.out.println("2. find the minimum value in the array");
	            System.out.println("3. find the sum of the values in the array");
	            System.out.println("4. find the average of the values in the array.");
	            System.out.println("5. counts the number of times a value occurs in the array");
	            System.out.println("0. exit program");
	            System.out.print("Select Your Action: ");
	            selection = scanner.nextInt();
	            
	            switch(selection) {
	            case 1:
	            	 System.out.println("Max value is: " + Util.findMax.applyDouble(arr) + "\n");
	            	break;
	            case 2:
	            	 System.out.println("Min value is: " + Util.findMin.applyDouble(arr) + "\n");
	            	break;
	            case 3:
	            	 System.out.println("Sum value is: " + Util.findSum.applyDouble(arr) + "\n");
	            	break;
	            case 4:
	            	 System.out.println("Avgerage value is: " + Util.findAvg.applyDouble(arr) + "\n");
	            	break;
	            case 5:
	            	int val = (int)askCounter(scanner);
	            	System.out.println("The number occurs " + val + " times in the array" + "\n");
	            	break;
	            case 0:
	            	selection = 0;
	            	System.out.println("Program ends");
	            	break;
	            default:
	            	System.out.println("Invalid number, please try again");
	            	break;
	            }

			}
			catch(InputMismatchException e) {
				e.printStackTrace();
				System.out.println("Invalid input, please enter valid number");
				scanner.nextLine();
			}
        }  
	}
	
	
	public double askCounter(Scanner scanner) {
		double value = 0;
		try {
			System.out.print("Enter the number you looking for: ");
			value = scanner.nextDouble();
		}
		catch(InputMismatchException e) {
			e.printStackTrace();
			System.out.println("Invalid number, please try again");
		}

		return Util.counter(value).applyDouble(arr);
	}
	
	
	
	
	public static void main(String[] args) {
		Test test = new Test();
		Scanner scanner = new Scanner(System.in);
		
		test.scan(scanner);
		test.menu(scanner);
		 
		
	}
	
}
