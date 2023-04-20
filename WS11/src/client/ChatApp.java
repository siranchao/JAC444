package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ChatApp extends Application {

	private final int PORT = 5000;
	private String userName = "";
	private TextArea messageArea;
	private TextArea messageField;
	
	private String message;
	private String lastMessage;
	private boolean send = false;
	private boolean exit = false;
	
	/**
	 * this variable is defined as a Thread, running for the client
	 */
	private Thread chlientThread = new Thread(() -> {
		
		try(Socket socket = new Socket("localhost", PORT)){
			
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
	
			//keep thread doing nothing until send or exit flag is on
			while(true) {
				if(send) {
					output.println(userName + ": " + message);
					send = false;
				}
				
				if(exit) {
					output.println(userName + ": exit the room");
					System.out.println("Client thread terminated...");
					break;
				}
				
				//receive server response
				if(input.ready()) {
					String responseFromServer = input.readLine();
					if(!responseFromServer.equals(lastMessage)) {
						lastMessage = responseFromServer;
						Platform.runLater(()->{
							messageArea.appendText(lastMessage + "\n");
						});	
					}
				}
				//Data transmission sync in every .5 second
				Thread.sleep(500);
			}
			
		}
		catch(IOException | IllegalArgumentException e) {
			System.out.println("Client side exception: " + e.getMessage());
			e.printStackTrace();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
	});

	
	@Override
	public void start(Stage ps) throws Exception {
		
		//Name section
        Label nameLabel = new Label("Please enter your name:");
        TextField nameField = new TextField();
        Button nameButton = new Button("OK");
        HBox nameBox = new HBox(20, nameLabel, nameField, nameButton);
        nameBox.setAlignment(Pos.CENTER_LEFT);
        nameBox.setPadding(new Insets(10));
        BorderPane.setMargin(nameBox, new Insets(10));

        //Chat message section
        Label chatLabel = new Label("Chat Messages:");
        messageArea = new TextArea();
        messageArea.setEditable(false);
        messageArea.setFont(Font.font("Verdana", 12));
        VBox messageBox = new VBox(20, chatLabel, messageArea);
        messageBox.setPadding(new Insets(10));
        BorderPane.setMargin(messageBox, new Insets(10));

        //Send message section
        messageField = new TextArea();
        messageField.setPrefWidth(400);
        messageField.setPrefRowCount(2);
        Button sendButton = new Button("Send");
        sendButton.setDisable(true);
        sendButton.setPrefWidth(80);
        Button exitButton = new Button("Exit");
        exitButton.setDisable(true);
        exitButton.setPrefWidth(80);
        
        HBox sendBox = new HBox(20, messageField, sendButton, exitButton);
        sendBox.setAlignment(Pos.CENTER_LEFT);
        sendBox.setPadding(new Insets(10));
        BorderPane.setMargin(sendBox, new Insets(10));
        
        
        
        BorderPane root = new BorderPane(messageBox, nameBox, null, sendBox, null);
        Scene scene = new Scene(root, 600, 400);
        ps.setScene(scene);
        ps.setTitle("Chat App");

        nameButton.setOnAction(event -> {
            String name = nameField.getText();
            if (name.isEmpty()) {
                return;
            }
            userName = name;
            ps.setTitle(userName);
            nameLabel.setText("Welcome, " + name + "!");
            nameField.setDisable(true);
            nameButton.setDisable(true);
            sendButton.setDisable(false);
            exitButton.setDisable(false);
            messageField.requestFocus();
            
            chlientThread.setDaemon(true);
            chlientThread.start();
        });

        sendButton.setOnAction(event -> {
            String msg = messageField.getText();
            if (!msg.isEmpty()) {
            	message = msg;
                messageField.clear();
                send = true;
            }
        });
        
        exitButton.setOnAction(event -> {
        	exit = true;
            sendButton.setDisable(true);
            exitButton.setDisable(true);
        });

        ps.show();
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}



	
}
