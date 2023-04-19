package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatApp {

	private final int PORT;
	private String userName;
	
	public ChatApp(String name, int port) {
		this.PORT = port;
		this.userName = name;
	}
	
	public void launch() {
		try(Socket socket = new Socket("localhost", PORT)){
			
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
			
			try (Scanner scan = new Scanner(System.in)) {
				String userInput;
				String responseFromServer;
				
				do {
					System.out.print("Enter the string : ");
					userInput = scan.nextLine();
					output.println(userInput);
					if(!userInput.equals("exit")) {
						responseFromServer = input.readLine();
						System.out.print(responseFromServer);
					}
					System.out.println();
				}while(!userInput.equals("exit"));
			}
			
		}
		catch(IOException | IllegalArgumentException e) {
			System.out.println("Client side exception: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		ChatApp app = new ChatApp("siran", 5000);
		app.launch();
		
	}
	
}
