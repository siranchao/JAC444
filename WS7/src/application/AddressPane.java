package application;

import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;

/**
 * This class will create a simple pane component with 5 labels and 5 textFields
 * all elements have fixed size and position
 * @author Siran
 *
 */
public class AddressPane {

	/**
	 * this method creates a pane with all elements mounted
	 * @return addressPane
	 */
	@SuppressWarnings("exports")
	public TitledPane createPane(String name) {
	
		Pane p = new Pane();
		
		//setup all labels
		p.getChildren().add(setupLabel("Name: ", 10, 20, 80, 30));
		p.getChildren().add(setupLabel("Street: ", 10, 55, 80, 30));		
		p.getChildren().add(setupLabel("City: ", 10, 90, 80, 30));		
		p.getChildren().add(setupLabel("Province: ", 10, 125, 80, 30));
		p.getChildren().add(setupLabel("Post-code: ", 10, 160, 80, 30));
		
		//setup all textFields
		p.getChildren().add(setupTf(100, 20, 300, 30));
		p.getChildren().add(setupTf(100, 55, 300, 30));
		p.getChildren().add(setupTf(100, 90, 300, 30));
		p.getChildren().add(setupTf(100, 125, 300, 30));
		p.getChildren().add(setupTf(100, 160, 300, 30));
		
		 // Set the title and border of the pane
    	TitledPane frame = new TitledPane(name, p);
		frame.setCollapsible(false);
        p.setPadding(new Insets(5, 5, 5, 5));
        
		return frame;
	}
	
	
	/**
	 * this method creates a new Label object based on parameters receives
	 * @param name title
	 * @param x positionX
	 * @param y positionY
	 * @param width set width
	 * @param height set height
	 * @return new label
	 */
	@SuppressWarnings("exports")
	public Label setupLabel(String name, double x, double y, double width, double height) {
		Label lb = new Label(name);
		lb.relocate(x, y);
		lb.setPrefSize(width, height);
		return lb;
	}
	
	
	/**
	 * this method creates a new textField object based on parameters receives
	 * @param x positionX
	 * @param y positionY
	 * @param width set width
	 * @param height set height
	 * @return new textField
	 */
	@SuppressWarnings("exports")
	public TextField setupTf(double x, double y, double width, double height) {
		TextField tf = new TextField();
		tf.relocate(x, y);
		tf.setPrefSize(width, height);
		return tf;
	}
}
