package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//create Node
			Button btn = new Button("OK");
			
			Circle cir = new Circle();
			cir.setCenterX(200);
			cir.setCenterY(200);
			cir.setRadius(50);
			cir.setStroke(Color.BLACK);
			cir.setFill(Color.WHEAT);
			
			
			//create Pane
			//BorderPane root = new BorderPane();
			StackPane root = new StackPane();
			root.getChildren().add(cir);
			
			//create Scene
			Scene scene = new Scene(root,400,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			//create Stage
			primaryStage.setScene(scene);
			primaryStage.setTitle("My First FX");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	//launch application
	public static void main(String[] args) {
		launch(args);
	}
}
