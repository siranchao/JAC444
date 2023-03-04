package ws5.madlibs;

import java.util.Scanner;
public class Test {
	
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		MadLibs game = new MadLibs();
		
		game.menu(scan);
		
		scan.close();
		
	}

}
