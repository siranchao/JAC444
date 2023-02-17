package ws4.caseStudy;

import java.util.Scanner;

public class Test {
	
	public static final int maxItems = 30;
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Payroll system = new Payroll();
		
		system.menu(scan);
	
		scan.close();
		
	}

	
	
}
