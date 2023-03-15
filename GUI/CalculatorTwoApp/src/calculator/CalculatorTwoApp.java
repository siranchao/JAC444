package calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CalculatorTwoApp extends Application{

	TextField valueField, answerField;
	RadioButton[] buttons;
	
	
	@Override
	public void start(Stage ps) throws Exception {
		Pane p = new Pane();
		
		Label label = new Label("Input X:");
		label.relocate(10, 10);
		label.setPrefSize(100, 30);
		p.getChildren().add(label);
		
		valueField = new TextField();
		valueField.relocate(80, 10);
		valueField.setPrefSize(140, 30);
		p.getChildren().add(valueField);
		
		label = new Label("Operation:");
		label.relocate(10, 55);
		label.setPrefSize(100, 30);
		p.getChildren().add(label);
		
		ToggleGroup operations = new ToggleGroup();
		buttons = new RadioButton[4];
		String[] buttonLabels = {"X + X", "X * X", "X ^ 0.5", "1 / X"};
		for(int i=0; i<4; i++) {
			buttons[i] = new RadioButton(buttonLabels[i]);
			buttons[i].relocate(80, 60 + i*20);
			buttons[i].setPrefSize(150, 20);
			p.getChildren().add(buttons[i]);
			buttons[i].setToggleGroup(operations);
			buttons[i].setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					if(!valueField.getText().matches("^[-,+]?[0-9]+")) {
						answerField.setText("Invalid Input");
						return;
					}
					
					int value = Integer.parseInt(valueField.getText());
					
					int buttonNumber = 0;
					for(buttonNumber=0; buttonNumber<4; buttonNumber++) {
						if(buttons[buttonNumber] == e.getSource())
							break;
					}
					
					double result = 0.0;
					switch(buttonNumber) {
					case 0: result = value + value;break;
					case 1: result = value * value; break;
					case 2: result = Math.sqrt(value); break;
					case 3: result = 1 / (double)value; break;
					}
					
					answerField.setText(""+result);
				}
			});
		}
		
		label = new Label("Answer: ");
		label.relocate(10, 150); label.setPrefSize(100, 30);
		p.getChildren().add(label);
		
		answerField = new TextField();
		answerField.relocate(80, 150);
		answerField.setPrefSize(140, 30);
		answerField.setEditable(false);
		p.getChildren().add(answerField);
		
		ps.setTitle("Cal 2");
		ps.setResizable(false);
		ps.setScene(new Scene(p,220,180));
		ps.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
