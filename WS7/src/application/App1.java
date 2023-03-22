package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.AddressPane;

public class App1 extends Application{
	private AddressPane addrPane;

	
	@Override
	public void start(Stage ps) {
		Pane mainPane = new Pane();
		
		//add comboBox
		ComboBox<String> box = new ComboBox<>();
		box.relocate(10, 10);
		box.setPrefSize(415, 30);
		box.getItems().addAll("Home Address", "Work Address", "Alternative Address");
		box.setValue("Home Address");
		mainPane.getChildren().add(box);
		
		//add address pane
		addrPane = new AddressPane("Contact Address");
		addrPane.setCollapsible(false);
		addrPane.relocate(10, 50);
		mainPane.getChildren().add(addrPane);
		
		Scene scene = new Scene(mainPane, 440, 300);
		ps.setScene(scene);
		ps.setTitle("My Application");
		ps.setResizable(false);
		ps.show();
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
