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
				if(input.ready()) {
					String incomingData = input.readLine();
					Platform.runLater(()->{
						MultiServer.updateChat(incomingData);
					});	
					
					if (incomingData.contains("exit")) {
						Platform.runLater(()->{				
							MultiServer.updateLog("Thread ID: " + threadId + " Server Terminated");
							MultiServer.removeTask();
							MultiServer.updateLabel();
						});
						System.out.println("Server thread terminated...");
						break;
					}
				}

				//return chat history
				output.println(MultiServer.getLatestChat());
				
				//Data transmission sync in every .5 second
				Thread.sleep(500);
			}
		}
		catch(IOException e) {
			Platform.runLater(()->{
				MultiServer.updateLog("Thread ID: " + threadId + " Server Exception " + e.getMessage());
			});
			e.printStackTrace();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
}
