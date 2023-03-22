package view;

import model.ItemList;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class GroceryListView extends Pane{

	private ItemList model;
	
	private ListView<String> groceryList;
	private Button addButton;
	private Button removeButton;
	private TextField newItemField;
	
	public ListView<String> getList(){return groceryList;}
	public Button getAddButton() {return addButton;}
	public Button getRemoveButton() {return removeButton;}
	public TextField getNewItemField() {
		return newItemField;
	}
	
	public GroceryListView(ItemList model) {
		this.model = model;
		
		newItemField = new TextField();
		newItemField.relocate(10, 10);
		newItemField.setPrefSize(150, 25);
		
		addButton = new Button("Add");
		addButton.relocate(175, 10);
		addButton.setPrefSize(100, 25);
		
		removeButton = new Button("Remove");
		removeButton.relocate(175, 45);
		removeButton.setPrefSize(100, 25);
		
		groceryList = new ListView<>();
		String[] fruits = {"Apples", "Oranges", "Bananas", "Durian", "Toilet Paper", "Ketchup","Cereal","Milk","Cookies","Cheese"};
		
		groceryList.setItems(FXCollections.observableArrayList(fruits));
		groceryList.relocate(10, 45);
		groceryList.setPrefSize(150, 150);
		
		getChildren().addAll(newItemField, addButton, removeButton, groceryList);
		
		update();
	}
	
	public void update() {
		String[] exactList = new String[model.getSize()];
		
		for(int i=0; i<model.getSize(); i++)
			exactList[i] = model.getItem()[i];
		
		int selectedIndex = groceryList.getSelectionModel().getSelectedIndex();
		groceryList.setItems(FXCollections.observableArrayList(exactList));
		groceryList.getSelectionModel().select(selectedIndex);
		
		removeButton.setDisable(groceryList.getSelectionModel().getSelectedIndex() < 0);
		
		addButton.setDisable(newItemField.getText().trim().length() == 0);
	}
	
	
}
