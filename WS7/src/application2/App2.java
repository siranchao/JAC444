package application2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.ItemList;
import view.AddressPane;
import view.NameList;


public class App2 extends Application{
	
	private ItemList model;
	private NameList view;
	
	private AddressPane addrPane1;
	private AddressPane addrPane2;
	private Button addBtn;
	private Button removeBtn;
	
	@Override
	public void start(Stage ps) {
		Pane mainPane = new Pane();

		//add address pane
		addrPane1 = new AddressPane("Home Address");
		addrPane1.relocate(175, 10);
		addrPane1.setCollapsible(false);
		//add address pane
		addrPane2 = new AddressPane("Alternative Address");
		addrPane2.relocate(175, 250);
		addrPane2.setCollapsible(false);
		
		//add nameList pane
		view = new NameList(model);
		view.relocate(10, 10);
		
		//add btn group
		addBtn = new Button("Add");
		removeBtn = new Button("Remove");
		addBtn.relocate((175 + 310), 485);
		addBtn.setPrefSize(100, 25);
		removeBtn.relocate((175 + 310 - 120), 485);
		removeBtn.setPrefSize(100, 25);
		
		
		//Add event listeners
		removeBtn.setDisable(view.getList().getSelectionModel().getSelectedIndex() < 0);
		
		addBtn.setDisable(addrPane1.checkInput());
		
		
		
		
		
		
		
		
		mainPane.getChildren().addAll(addrPane1, addrPane2, view, addBtn, removeBtn);
		
		Scene scene = new Scene(mainPane, 600, 520);
		ps.setScene(scene);
		ps.setTitle("My Application-2");
		ps.setResizable(false);
		ps.show();
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
