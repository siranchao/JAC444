package week7.filehandling;
//jakarta
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadingWrittingImage {

	public static void main(String[] args)throws Exception {
		String fileIn = "test-in.jpg";
		String fileOut = "test-out.jpg";
		
		long startTime, endTime;
		File file = new File(fileIn);
		System.out.println("The size of the file is " + file.length());
		
		try(FileInputStream fin = new FileInputStream(file);
				FileOutputStream fout = new FileOutputStream(fileOut)){
			startTime = System.nanoTime();
			int eof;
			while((eof=fin.read())!=-1){
				fout.write(eof);
			}
			endTime = System.nanoTime() - startTime;
			System.out.println("The total time to read and write the image is " +  (endTime/10000000.00)+" msec");
		}
		
		try(BufferedInputStream bfin = (new BufferedInputStream(new FileInputStream(file)));
				BufferedOutputStream bfout = new BufferedOutputStream(new FileOutputStream(fileOut))){
			startTime = System.nanoTime();
			int eof;
			while((eof=bfin.read())!=-1){
				bfout.write(eof);
			}
			endTime = System.nanoTime() - startTime;
			System.out.println("The total time to read and write the image is " +  (endTime/10000000.00)+" msec");
		}
	}
}
