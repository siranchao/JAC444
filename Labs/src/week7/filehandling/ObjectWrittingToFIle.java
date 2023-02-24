package week7.filehandling;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ObjectWrittingToFIle {
	private static ObjectOutputStream outOb;
	private static ObjectInputStream inOb;
	static File f = new File("account.ser");
	
public static void main(String[] args) {
	openFile();
	//addRecord();
	readRecord();//ios::bin
	//RandomAccessFile
}
public static  void openFile() {
	try{
		outOb = new ObjectOutputStream(new FileOutputStream(f));
		
		inOb = new ObjectInputStream(new FileInputStream(f));
	}catch(IOException e) {
		System.err.println("Error in opening the file. " +f.getName());
	}
}

public static void addRecord() {
	Scanner in = new Scanner(System.in);
	System.out.printf("%s%n%s%n -? ","Enter account number, first name, last name"
			+ ",balance.","Enter end-of-file inidcator to end input (press ctrl+Z)");
	while(in.hasNext()) {
		try {
			Account record = new Account(in.nextInt(),
										in.next(),
										in.next(),
										in.nextDouble());
			outOb.writeObject(record);
		}catch(IOException ex) {
			ex.printStackTrace();
			System.err.println("Error wirtting the file.");
			break;
		}System.out.println(" ? -");
	}
}

public static void readRecord() {
	System.out.printf("%-12s%-12s%-12s%10s%n", "Account Number", "First Name","Last Name", "Balance");
	
	try{
		while(true) {
	
		Account record = (Account)inOb.readObject();
		System.out.printf("%-10d%-12s%-12s%10.0f%n",record.getAccNum(),
				record.getfName(),record.getlName(),record.getAccBala());
		}
	}catch(EOFException e) {
		System.out.print("The end of file reached");
		//break;
	}catch (IOException e) {
		System.err.print("Cannot read the file" + f.getName()) ;
	}catch (ClassNotFoundException e) {
		System.err.print("Cannot read the file" + f.getName()) ;
	}
}
}
