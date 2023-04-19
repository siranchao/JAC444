package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
	
	
	private Thread serverThread = new Thread(() -> {
		
		try(ServerSocket ss = new ServerSocket(PORT)) {
			System.out.println("Multi-thread Server Launched...");
			while(true) {
				Socket socket = ss.accept();
				taskNum++;
				ChatThread task = new ChatThread(socket, taskNum);
				task.setDaemon(true);
				task.start();
				
				Platform.runLater(()->{
					logBox.appendText("Client #" + taskNum + " Connected...");
					logLabel.setText("Current running threads: " + taskNum);
				});
			}
			
		}
		catch(IOException | IllegalArgumentException e) {
			System.out.println("Server Exception: " + e.getMessage());
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
        	serverThread.start();
        	logBox.appendText("Server starts, listening on PORT: " + PORT);
        	runBtn.setDisable(true);
        });
        
        Button exitBtn = new Button("Terminate Server");
        exitBtn.setPrefWidth(120);
        GridPane.setMargin(exitBtn, new Insets(0, 0, 0, 150));
        gridPane.add(exitBtn, 0, 2);
        exitBtn.setOnAction(event -> {
    		logBox.appendText("Server Terminated...");
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
    
    @SuppressWarnings("exports")
	public static Label getLabel() {
    	return logLabel;
    }
    
    @SuppressWarnings("exports")
	public static TextArea getLog() {
    	return logBox;
    }

	@SuppressWarnings("exports")
	public static TextArea getChat() {
    	return chatBox;
    }
    
    
    public static void main(String[] args) {

    	launch(args);
    }
	



}
