package week9.LambdaPractice.fi;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FxLambda extends Application{

	@Override
	public void start(Stage ps) throws Exception {
		Pane pa = new Pane();
		Button btn = new Button("OK");
		
		btn.setOnAction(/*new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				System.out.println("Button is clicked");
			}
		}*/
				e->System.out.println("Button is clicked")
				);
		
		//button1.setOnAction(e->System.out.println("Button 1 is pressed!"));
		
		//button2.setOnAction(e->System.out.println("Ouch! Button 2 is pressed!"));
		
		
		pa.getChildren().add(btn);
		Scene sc = new Scene(pa,200,200);
		ps.setScene(sc);
		ps.show();
		
	}

	public static void main(String[] args) {
		launch();
	}
}
