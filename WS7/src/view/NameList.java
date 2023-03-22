package view;

import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import model.ItemList;

public class NameList extends Pane{
	
	private ItemList model;
	private ListView<String> nameList;
	
	public ListView<String> getList() {
		return nameList;
	}
	
	public NameList(ItemList model) {
		//copy from parameters
		this.model = model;
		
		//convert arrayList to viewable array
		String[] displayList = Arrays.copyOf(model.getStrArray(), model.size());
	
		nameList = new ListView<>();
		ObservableList<String> items = FXCollections.observableArrayList(displayList);
		nameList.setItems(items);
		nameList.setPrefSize(150, 465);
		getChildren().add(nameList);
		
		update();
	}
	
	
	public void update() {
		String[] displayList = Arrays.copyOf(model.getStrArray(), model.size());
		
		int selectedIndex = nameList.getSelectionModel().getSelectedIndex();
		nameList.setItems(FXCollections.observableArrayList(displayList));
		nameList.getSelectionModel().select(selectedIndex);
		
	}

}
