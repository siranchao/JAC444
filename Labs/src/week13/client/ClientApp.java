package week13.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {

	public static void main(String[] args) {
		//127.0.0.1
		//Platform.runlater
		try(Socket socket = new Socket("localhost", 5000)){
			//DatagramSocket
			
			BufferedReader inS = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter outS = new PrintWriter(socket.getOutputStream(), true);
			
			Scanner scan = new Scanner(System.in);
			String userInput;
			String responseFromServer;
			
			do {
				System.out.print("Enter the string : ");
				userInput = scan.nextLine();
				outS.println(userInput);
				if(!userInput.equals("exit")) {
					responseFromServer = inS.readLine();
					System.out.print(responseFromServer);
				}
				System.out.println();
			}while(!userInput.equals("exit"));
		}catch(IOException e) {
			System.out.println("Client side exception : " + e.getMessage());
			e.printStackTrace();
		}
	}
}
