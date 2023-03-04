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

		//handle I/O
		try(BufferedReader br = new BufferedReader(new FileReader(inputPath));
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {

			//read line-by-line
			System.out.print("\n");
			String currentLine;
			while((currentLine = br.readLine()) != null) {
				
				//process current line
				if(currentLine.isEmpty()) {
					bw.write(currentLine);
				}
				else {
					String newLine = Util.handleLine(currentLine, scan);
					bw.write(newLine);
				}
				bw.newLine();
			}
			bw.flush();
			
			System.out.println("Your mad-lib has been created!\n");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	
		
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
		
		try(BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
			String currentLine;
			System.out.print("\n");
			while((currentLine = br.readLine()) != null) {
				System.out.println(currentLine);
			}
			System.out.print("\n");
		}
		catch(IOException e) {
			e.printStackTrace();
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
					System.out.println("\n**** Create a mad-lib ****");
					createMadLib(scan);
					break;
				case 'v':
				case 'V':
					System.out.println("\n**** View a mad-lib ****");
					viewMadLib(scan);
					break;
				case 'q':
				case 'Q':
					run = false;
					System.out.println("\n======== Program Ends ========");
					break;
			}
			
		}
		
	
		
}



}