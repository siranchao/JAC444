package week13.multiserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CommunicationThread extends Thread {

	private Socket socket;

	public CommunicationThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter output = new PrintWriter(socket.getOutputStream(), true);) {

			while (true) {
				String incomingData = input.readLine();
				// System.out.println(incomingData);
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
