package fruitapp;

import model.ItemList;
import view.GroceryListView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GroceryListApp extends Application{

	private ItemList model;
	private GroceryListView view;

	
	@Override
	public void start(Stage ps) throws Exception {
		model = new ItemList();
		model.add("Apples");
		model.add("Toilent Papers");
		model.add("Kectchup");
		
		view  = new GroceryListView(model);
		
		view.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) {
				handleAddButtonPress();
			}
		});
		
		view.getRemoveButton().setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) {
				handleRemoveButtonPress();
			}
		});
		
		view.getList().setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent m) {
				handleListSelection();
			}
		});
		
		view.getNewItemField().setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent m) {
				handleTextEntry();
			}
		});
		
		ps.setTitle("My Grocery List");
		ps.setResizable(false);
		ps.setScene(new Scene(view, 285,205));
		ps.show();
		
		
		
	}
	
	private void handleAddButtonPress() {
		String text = view.getNewItemField().getText().trim();
		if(text.length() > 0) {
			view.getNewItemField().setText("");
			model.add(text);
			view.update();
		}
	}
	
	private void handleRemoveButtonPress() {
		int index = view.getList().getSelectionModel().getSelectedIndex();
		if(index >= 0) {
			model.remove(index);
			view.update();
		}
	}
	
	private void handleListSelection() {view.update();}
	private void handleTextEntry() {view.update();}
	
	public static void main(String...strings) {
		launch(strings);
	}
}
