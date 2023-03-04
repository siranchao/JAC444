package ws5.madlibs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 * This class represent a MadLib game, and provide various of methods to host the game and operate game features
 * @author Siran
 *
 */
public class MadLibs {

	
	/**
	 * this method will open and read an file as template and
	 * scan multiple user's inputs to create a text file of madLib using I/O 
	 * @param scan Scanner obj
	 */
	public void createMadLib(Scanner scan) {
		String inputPath, outputPath;
		System.out.print("Input file name: ");
		inputPath = scan.nextLine();
		File inputFile = new File(inputPath);
		
		while(!inputFile.exists()) {
			System.out.print("File not found. Try again: ");
			inputPath = scan.nextLine();
			inputFile = new File(inputPath);
		}
		
		System.out.print("Output file name: ");
		outputPath = scan.nextLine();

		//1.read line by line - FileReader	
		//2.scan placeholder
		//3.call prompt-with placeholder name - use method()
		//4.replace string by user input - return new string
		//5.write the string to output file
		
		try(BufferedReader br = new BufferedReader(new FileReader(inputPath));
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {

			//read line-by-line
			String currentLine;
			while((currentLine = br.readLine()) != null) {
				//process current line
				
			}
			
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	
		
	}
	
	
	/**
	 * this method receives a String, and looking for placeholder
	 * if any, will prompt for user input and create a new string replace placeholder with input tokens
	 * @param line string to be processed 
	 * @return new string
	 */
	public String handleLine(String line, Scanner scan) {
		
		StringBuilder newLine = new StringBuilder();
		String[] words = line.split(" ");
		
		for(String word : words) {	
			
			if(word.indexOf(0) == '<') {
				String placehoder = word.substring(1, word.length() - 1);
				System.out.print("Please type a " + placehoder + ": ");
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
	 * this method will open file based on user's inputs 
	 * and read the content of the file using I/O 
	 * @param scan Scanner obj
	 */
	public void viewMadLib(Scanner scan) {
		String inputPath;
		System.out.print("Input file name: ");
		inputPath = scan.nextLine();
		File inputFile = new File(inputPath);
		
		while(!inputFile.exists()) {
			System.out.print("File not found. Try again: ");
			inputPath = scan.nextLine();
			inputFile = new File(inputPath);
		}
		
		
	}
	
	
	/**
	 * this method act as the menu of the game, control the logic of operation based on user's selection
	 * @param scan Scanner obj
	 */
	public void menu(Scanner scan) {
		char select;
		boolean run = true;
		
		System.out.println("======== Welcome to the game of Mad Libs ========");
		System.out.println("I will ask you to provide various words\nand phrases to fill in a story.\nThe result will be written to an output file\n");
		
		while(run) {	
			System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit: ");
			
			select = scan.nextLine().charAt(0);
			
			switch(select) {
				case 'c':
				case 'C':
					System.out.println("**** Create a mad-lib ****");
					createMadLib(scan);
					break;
				case 'v':
				case 'V':
					System.out.println("**** View a mad-lib ****");
					viewMadLib(scan);
					break;
				case 'q':
				case 'Q':
					run = false;
					System.out.println("======== Program Ends ========");
					break;
			}
			
		}
		
	
	
	
}



}