package application2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.AddressItem;
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
		model = new ItemList();
		
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
		removeBtn.setDisable(true);
		removeBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) {
				handleRemoveButtonPress();
			}
		});
		
		addBtn.setDisable(true);
		
		addBtnListener();
		
		addBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) {
				handleAddButtonPress();
			}
		});
		

		view.getList().setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent m) {
				handleListSelection();
			}
		});
		
		addrPane1.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent m) {
				removeBtn.setDisable(true);
			}
		});
		addrPane2.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent m) {
				removeBtn.setDisable(true);
			}
		});
		
		
		
		mainPane.getChildren().addAll(addrPane1, addrPane2, view, addBtn, removeBtn);
		
		Scene scene = new Scene(mainPane, 600, 520);
		ps.setScene(scene);
		ps.setTitle("My Application-2");
		ps.setResizable(false);
		ps.show();
		
	}
	
	
	private void handleAddButtonPress() {
		//add address to model
		AddressItem item = new AddressItem(addrPane1.getResults().get(0), addrPane1.getResults().get(1), addrPane1.getResults().get(2), addrPane1.getResults().get(3), addrPane1.getResults().get(4), addrPane2.getResults().get(0), addrPane2.getResults().get(1), addrPane2.getResults().get(2), addrPane2.getResults().get(3), addrPane2.getResults().get(4));
		model.add(item);
		
		addrPane1.reset();
		addrPane2.reset();
		
		view.update();
	}
	
	
	private void handleRemoveButtonPress() {
		int index = view.getList().getSelectionModel().getSelectedIndex();
		if(index >= 0) {
			model.remove(index);
			view.update();
			removeBtn.setDisable(true);
		}
	}
	
	private void handleListSelection() {
		view.update();
		removeBtn.setDisable(model.size() == 0);
	}
	
	
	private void addBtnListener() {
		for(int i = 0; i < 5; i++) {
			addrPane1.getNodes().get(i).textProperty().addListener((observable, oldValue, newValue) -> {
			    if (newValue.trim().isEmpty()) {
			    	addBtn.setDisable(true);
			    } else {
			    	addBtn.setDisable(false);
			    }
			});
		}
	}
		
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
