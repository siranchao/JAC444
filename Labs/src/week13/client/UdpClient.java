package week13.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {

	public static void main(String[] args) throws IOException {
		InetAddress address = InetAddress.getLocalHost();
		
		DatagramSocket ds = new DatagramSocket();
		
		Scanner scan = new Scanner(System.in);
		String userInput;
		
		do {
			System.out.print("Enter the string: ");
			 userInput = scan.nextLine();
			 
			 byte[] buffer = userInput.getBytes();
			 
			 DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
			 ds.send(packet);
		}while(!userInput.equals("exit"));
		//SocketTimeoutException
		
	}
}
