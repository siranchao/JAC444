package week13.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

	public static void main(String[] args) {
		
		try (ServerSocket ss = new ServerSocket(5000);) {
			
			while (true) {
				Socket socket = ss.accept();
				System.out.println("Client Connected....");

				BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

				String incomingData = input.readLine();
				System.out.println(incomingData);
				if (incomingData.equals("exit")) {
					break;
				}
				output.println("Ping coming back from the server data is received: " + incomingData);
			}
		} catch (IOException e) {
			System.out.println("Server Exception " + e.getMessage());
			e.printStackTrace();
		}
	}
}
