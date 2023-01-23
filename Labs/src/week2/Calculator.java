package week2;

/**
 * Write a program that reads in the radius and length of a cylinder and computes the area and volume using the following formulas:
	area = radius * radius * PI
	volume = area * length
 * @author Siran
 *
 */

import java.util.Scanner;

public class Calculator {
	
	public static final double PI = 3.1415926;
	
	public static void main(String[] args) {
		System.out.print("Enter the radius and length of a cylinder: ");
		
		Scanner scan = new Scanner(System.in);
		
		double r = scan.nextDouble();
		String line = scan.next();
		double length = Double.valueOf(line);
		
		System.out.println("The area is: " + r*r*PI);
		System.out.println("The vol is: " + r*r*PI*length);
		
		scan.close();
		
	}

}
