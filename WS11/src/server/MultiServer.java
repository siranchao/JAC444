/**********************************************
Workshop 11
Course: JAC444
Last Name: CAO
First Name: Siran
ID: 159235209
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 04/19/2023
**********************************************/

package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class MultiServer extends Application{
	
	private static final int PORT = 5000;
	private static int taskNum = 0;
	private static Label logLabel = new Label("Current running threads: " + taskNum);
	private static TextArea logBox = new TextArea("Server Log: " + "\n");
	private static TextArea chatBox = new TextArea("Chat Messages: " + "\n");
	private static List<String> log = new ArrayList<>();
	private static List<String> chat = new ArrayList<>();
	
	/**
	 * this variable is defined as a Thread, running for the multi-thread server
	 */
	private Thread serverThread = new Thread(() -> {
		
		try(ServerSocket ss = new ServerSocket(PORT)) {
			while(true) {
				Socket socket = ss.accept();
				taskNum++;
				ChatThread task = new ChatThread(socket, taskNum);
				task.setDaemon(true);
				task.start();
				
				Platform.runLater(()->{
					updateLog("Client #" + taskNum + " Connected...");
					updateLabel();
				});
			}
			
		}
		catch(IOException | IllegalArgumentException e) {
			updateLog("Server Exception: " + e.getMessage());
			e.printStackTrace();
		}	
	});
	

	
	@Override
	public void start(Stage ps) throws Exception {
		GridPane gridPane = new GridPane();
        gridPane.setHgap(10); // horizontal gap between columns
        gridPane.setVgap(10); // vertical gap between rows
        gridPane.setPadding(new Insets(10)); // margin around the grid

        // add first TitledPane to the top row
        TitledPane titledPane1 = new TitledPane();
        titledPane1.setText("Server Log");
        titledPane1.setContent(createTextArea("log"));
        GridPane.setConstraints(titledPane1, 0, 0);
        GridPane.setFillWidth(titledPane1, true); // allow TitledPane to expand horizontally
        GridPane.setHgrow(titledPane1, Priority.ALWAYS);

        // add second TitledPane to the bottom row
        TitledPane titledPane2 = new TitledPane();
        titledPane2.setText("Chat Room");
        titledPane2.setContent(createTextArea("chat"));
        GridPane.setConstraints(titledPane2, 0, 1);
        GridPane.setFillWidth(titledPane2, true); // allow TitledPane to expand horizontally
        GridPane.setHgrow(titledPane2, Priority.ALWAYS);
        
        //set button event actions
        Button runBtn = new Button("Start Server");
        runBtn.setPrefWidth(120);
        gridPane.add(runBtn, 0, 2);
        runBtn.setOnAction(event -> {
        	serverThread.setDaemon(true);
        	serverThread.start();
        	updateLog("Multi-Server starts, listening on PORT: " + PORT);
        	runBtn.setDisable(true);
        });
        
        Button exitBtn = new Button("Terminate Server");
        exitBtn.setPrefWidth(120);
        GridPane.setMargin(exitBtn, new Insets(0, 0, 0, 150));
        gridPane.add(exitBtn, 0, 2);
        exitBtn.setOnAction(event -> {
        	updateLog("Server Terminated...");
    		exitBtn.setDisable(true);
    		Platform.exit();
        });
  
        // add TitledPanes to the grid
        gridPane.getChildren().addAll(titledPane1, titledPane2);

        Scene scene = new Scene(gridPane, 500, 450);
        ps.setScene(scene);
        ps.setTitle("Multi-Server Panel");
        ps.show();	
	}
	
	
	/**
	 * this method create and return the section of TextArea
	 * @param section
	 * @return
	 */
    private GridPane createTextArea(String section) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10); // horizontal gap between columns
        gridPane.setVgap(10); // vertical gap between rows
        gridPane.setPadding(new Insets(10)); // margin around the grid

        if(section.equals("log")) {
        	logBox.setEditable(false);
            GridPane.setConstraints(logLabel, 0, 0);
            GridPane.setConstraints(logBox, 0, 1);
            gridPane.getChildren().addAll(logLabel, logBox);
        }
        
        if(section.equals("chat")) {
        	chatBox.setEditable(false);
            GridPane.setConstraints(chatBox, 0, 1);
            gridPane.getChildren().addAll(chatBox);
        }
        return gridPane;
    }
	
	
    public static int getTaskNum() {
    	return taskNum;
    }
    
    public static void addTask() {
    	taskNum++;
    }
    
    public static void removeTask() {
    	taskNum--;
    }
    	
	public static void updateLabel() {
		logLabel.setText("Current running threads: " + taskNum);
	}
    
	public static void updateLog(String msg) {
		log.add(msg);
		logBox.appendText(msg + "\n");
	}
	
	public static void updateChat(String msg) {
		chat.add(msg);
		chatBox.appendText(msg + "\n");
	}
	
	
	/**
	 * this method return the latest message in the list
	 * @return
	 */
	public static String getLatestChat() {
		return chat.isEmpty() ? "" : chat.get(chat.size() - 1);
	}

	
    public static void main(String[] args) {
    	launch(args);
    }
	



}
