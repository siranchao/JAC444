package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatThread extends Thread{

	private Socket socket;
	private int threadId;
	//private boolean running;
	
	public ChatThread(Socket s, int id) {
		this.socket = s;
		this.threadId = id;
		//this.running = true;
	}

	
	@Override
	public void run() {
		try(BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);) {
			
			while(true) {
				String incomingData = input.readLine();
				
				if (incomingData.equals("exit")) {
					System.out.println("Thread ID: " + threadId + " Server Terminated");
					break;
				}
				
				output.println("Ping coming back from the server data is received: " + incomingData);
			}
			
			
			
		}
		catch(IOException e) {
			System.out.println("Thread ID: " + threadId + " Server Exception " + e.getMessage());
			e.printStackTrace();
		}
		
	}
}
