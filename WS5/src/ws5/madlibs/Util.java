package ws5.madlibs;

import java.util.Scanner;

/**
 * This class is a helper class provide static methods to help the program handle String with placeholder
 * and other utility functions
 * @author Siran
 *
 */
public class Util {

	/**
	 * this static method receives a String, and looking for placeholder
	 * if any, will prompt for user input and create a new string replace placeholder with input tokens
	 * @param line string to be processed 
	 * @return new string
	 */
	public static String handleLine(String line, Scanner scan) {
		
		StringBuilder newLine = new StringBuilder();
		String[] words = line.split(" ");
		

		
		for(String word : words) {	
			
			if(word.charAt(0) == '<') {
				String placeholder = word.substring(1, word.length() - 1);
				
				if(checkVowel(placeholder)) {
					System.out.print("Please type an " + removeHyphen(placeholder) + ": ");
				}
				else {
					System.out.print("Please type a " + removeHyphen(placeholder) + ": ");
				}
				
				String token = scan.nextLine();
				newLine.append(token + " ");
			}
			else {
				newLine.append(word + " ");
			}
			
		}
		return newLine.toString();
	}
	
	
	/**
	 * this helper method receives a String and check if it contains hyphens
	 * if so, replace all hyphens with spaces
	 * @param placeholder String token
	 * @return modified token
	 */
	public static String removeHyphen(String placeholder) {
		
		String newPlaceholder = (placeholder.indexOf('-') == -1) ? placeholder : placeholder.replace('-', ' ');		
		return newPlaceholder;
	}
	
	
	/**
	 * this helper method receives a String placeholder and check if the string begin with a vowel
	 * @param placeholder String token
	 * @return check result
	 */
	public static boolean checkVowel(String placeholder) {
		
		String vowels = "a e i o u A E I O U";
		char init = placeholder.charAt(0);
		return (vowels.indexOf(init) != -1);
	}
	
	
}
