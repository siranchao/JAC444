package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
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
	private List<ChatThread> taskList = new ArrayList<>();
	private int taskNum = 0;
	
	private LinkedList<String> log = new LinkedList<>();
	private LinkedList<String> chat = new LinkedList<>();
	private Label logLabel = new Label("Current running threads: " + taskNum);
	private Label chatLabel = new Label("People in room: " + taskNum);
	private TextArea logBox = new TextArea("Server Log: " + "\n");
	private TextArea chatBox = new TextArea("Chat Messages: " + "\n");
	
	
	private Thread serverThread = new Thread(() -> {
		
		try(ServerSocket ss = new ServerSocket(PORT)) {
			System.out.println("Multi-thread Server Launched...");
			while(true) {
				Socket socket = ss.accept();
				taskNum++;
				taskList.add(new ChatThread(socket, taskNum));
				taskList.get(taskNum-1).start();
				log.add("Client #" + taskNum + " Connected...");
				updateUI();
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
        	log.add("Server starts, listening on PORT: " + PORT);
        	updateUI();
        	runBtn.setDisable(true);
        });
        
        Button exitBtn = new Button("Terminate Server");
        exitBtn.setPrefWidth(120);
        GridPane.setMargin(exitBtn, new Insets(0, 0, 0, 150));
        gridPane.add(exitBtn, 0, 2);
        exitBtn.setOnAction(event -> {
    		log.add("Server Terminated...");
    		updateUI();
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
            GridPane.setConstraints(chatLabel, 0, 0);
            GridPane.setConstraints(chatBox, 0, 1);
            gridPane.getChildren().addAll(chatLabel, chatBox);
        }
        return gridPane;
    }
	
	
    private void updateUI() {
    	logLabel.setText("Current running threads: " + taskNum);
    	chatLabel.setText("Number of people: " + taskNum);

    	if(!log.isEmpty())
    		logBox.appendText(log.getLast() + "\n");
    	
    	if(!chat.isEmpty()) 
    		chatBox.appendText(chat.getLast() + "\n");	
    }

    
    public static void main(String[] args) {
        launch(args);
    }
	

}
