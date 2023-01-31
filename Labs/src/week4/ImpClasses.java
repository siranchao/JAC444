package week4;

import java.util.*;
public class ImpClasses {
	public static void main(String[] args) {
		
		int i = 10;
		int j = 20;
		
		System.out.println(Math.max(i, j));
		
		System.out.println(Math.addExact(i, j));

		System.out.println(Math.log(2.7));
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the points values of the x and y");
		double x1 = scan.nextDouble();
		double y1 = scan.nextDouble();
		double x2 = scan.nextDouble();
		double y2 = scan.nextDouble();
		double x3 = scan.nextDouble();
		double y3 = scan.nextDouble();
		
		//sqrt(side1 * side 2 * side3)
		double a = Math.sqrt((x2-x3)*(x2-x3) + (y2-y3)*(y2-y3));
		
		//double A = Math.toDegrees(Math.acos());
		
	}	
}
