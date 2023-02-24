package week7.filehandling;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

	public static void main(String[] args)throws Exception {
		//System.out for outputing data to the screen
		//System.in for inputting data from user
		System.err.print("This is an error message");
		
		try{
			FileOutputStream fout = new FileOutputStream("myData.dat");
			FileInputStream fin = new FileInputStream("myData.dat");
			
			fout.write('H');
			fout.write(69);
			fout.write(76);
			fout.write('L');
			fout.write('O');
			fout.close();
			
			int num;
			while((num=fin.read())>0) {
				System.out.print((char)num);
			}
			fin.close();
		}catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		
		Account acc = new Account(12345, "Frank", "Ma", 23.65);
		//try-with-resource
		try(DataOutputStream dout = new DataOutputStream(new FileOutputStream("myFile.dat"));
				DataInputStream din = new DataInputStream(new FileInputStream("myFile.dat"))){
			dout.writeInt(acc.getAccNum());
			//dout.writeUTF(acc.getAccName());
			dout.writeDouble(acc.getAccBala());
			
			System.out.println("Account number is: " + din.readInt());
			//System.out.println("Account name is: " + din.readUTF());
			System.out.println("Account balance is: " + din.readDouble());
			
		}
	}
}
