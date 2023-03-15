package fruitapp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FruitListApp extends Application{
	
	public void start(Stage ps) {
		Pane p = new Pane();
	
		TextField newItemField = new TextField();
		newItemField.relocate(10, 10);
		newItemField.setPrefSize(150, 25);
		
		Button addButton = new Button("Add");
		addButton.relocate(175, 10);
		addButton.setPrefSize(100, 25);
		
		Button removeButton = new Button("Remove");
		removeButton.relocate(175, 45);
		removeButton.setPrefSize(100, 25);
		
		ListView<String> fruitList = new ListView<>();
		String[] fruits = {"Apples", "Oranges", "Bananas", "Durian", "Cherries", "Lemons","Pears","Strawberries","Peaches","Apricots"};
		//List<String> test = Arrays.asList(fruits);
		
		fruitList.setItems(FXCollections.observableArrayList(fruits));
		fruitList.relocate(10, 45);
		fruitList.setPrefSize(150, 150);
		
		p.getChildren().addAll(newItemField, addButton, removeButton, fruitList);
		ps.setResizable(false);
		ps.setTitle("My Fruit List");
		ps.setScene(new Scene(p,285,205));
		ps.show();
		
	}
public static void main(String[] args) {
	launch(args);
}
}
