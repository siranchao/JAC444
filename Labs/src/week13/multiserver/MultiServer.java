package week13.multiserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {

	public static void main(String[] args) {
		
		try (ServerSocket ss = new ServerSocket(5000);) {
			
			while (true) {

				Socket socket = ss.accept();
				CommunicationThread ct =  new CommunicationThread(socket);
				ct.start();
				//new CommunicationThread(ss.accept()).start();
				System.out.println("Client Connected....");

				
			}
		} catch (IOException e) {
			System.out.println("Server Exception " + e.getMessage());
			e.printStackTrace();
		}
	}
}
