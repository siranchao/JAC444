package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.application.Platform;

public class ChatThread extends Thread{

	private Socket socket;
	private int threadId;
	
	public ChatThread(Socket s, int id) {
		this.socket = s;
		this.threadId = id;
	}

	
	@Override
	public void run() {
		
		try(BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);) {
			
			while(true) {
				String incomingData = input.readLine();
				
				Platform.runLater(()->{
					MultiServer.getChat().appendText(incomingData);
				});
				
				if (incomingData.equals("exit")) {
					Platform.runLater(()->{				
						MultiServer.getLog().appendText("Thread ID: " + threadId + " Server Terminated");
						MultiServer.removeTask();
						MultiServer.getLabel().setText("Current running threads: " + MultiServer.getTaskNum());
					});

					break;
				}
				
				output.println("Ping coming back from the server data is received: " + incomingData);
			}
		}
		catch(IOException e) {
			Platform.runLater(()->{
				MultiServer.getLog().appendText("Thread ID: " + threadId + " Server Exception " + e.getMessage());
			});
			e.printStackTrace();
		}	
	}
	
}
