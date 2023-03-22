package view;


import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;

/**
 * This class will create a simple pane component with 5 labels and 5 textFields
 * all elements have fixed size and position
 * @author Siran
 *
 */
public class AddressPane extends TitledPane{
	private Pane p;
	
	
	/**
	 * Constructor with two parameters, title and simple pane
	 * @param name title of the pane
	 */
	public AddressPane(String name) {
		super(name, new Pane());
        setContent(createContent());
	}
	
	
	/**
	 * this method create a simple pane with given labels and textFields
	 * @return content of the titledPane
	 */
	public Pane createContent() {
		p = new Pane();
		
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
        p.setPadding(new Insets(5, 5, 5, 5));
		
		return p;
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
	public TextField setupTf(double x, double y, double width, double height) {
		TextField tf = new TextField();
		tf.relocate(x, y);
		tf.setPrefSize(width, height);
		return tf;
	}
	
	
	
	/**
	 * this method will check if all the textField are filled
	 * @return boolean
	 */
	public boolean checkInput() {
		boolean res = true;
		
		//retrieve textField nodes and check
		for(Node node : p.getChildren()) {
			if(node instanceof TextField) {
				if(((TextField)node).getText().trim().length() == 0) {
					res = false;
				}	
			}
		}
		return res;
	}
	
	
}
