package week13.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {

	public static void main(String[] args) {
		try(DatagramSocket socket = new DatagramSocket(5000);){
			while(true) {
				byte[] buffer = new byte[50];
				
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				
				socket.receive(packet);
				
				//System.out.print("Text Recieved : " + new String(buffer));
				System.out.print("Text Recieved : " + new String(buffer,0,packet.getLength()));
			}
			
		}catch(IOException e) {}
	}
}
