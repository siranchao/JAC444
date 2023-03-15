package example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FormExample extends Application{

	@Override
	public void start(Stage ps) throws Exception {
		
		//set Pane layout and nodes
		GridPane gPane = new GridPane();
		gPane.setAlignment(Pos.CENTER);
		gPane.setHgap(5.5);
		gPane.setVgap(5.5);
		
		gPane.add(new Label("First name: "), 0, 0);
		TextField fn = new TextField();
		gPane.add(fn,	1, 0);
		gPane.add(new Label("MI: "), 0, 1);
		TextField mi = new TextField();
		gPane.add(mi,	1, 1);
		gPane.add(new Label("Last name: "), 0, 2);
		TextField ln = new TextField();
		gPane.add(ln,	1, 2);
		
		Button btAdd = new Button("Add Name");
		Button btnR = new Button("Read Name(s)");
		gPane.add(btAdd, 1, 3);
		gPane.add(btnR, 1, 4);
		
		
		//set event handler
		btAdd.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				String fnS = fn.getText();
				String miS = mi.getText();
				String lnS = ln.getText();
				
				File file = new File("info.txt");
				try {
					FileWriter fw = new FileWriter(file,true);
					fw.write(fnS + "\n");
					fw.write(miS + "\n");
					fw.write(lnS + "\n");
					fw.close();
				}catch(IOException e) {e.printStackTrace();}
				fn.clear();
				mi.clear();
				ln.clear();
			}
			
		});
		
		//set event handler
		btnR.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				Stage rs = new Stage();
				Pane p = new Pane();
				TextArea ta = new TextArea();
				
				p.getChildren().add(ta);
				
				StringBuilder sb = new StringBuilder();
				String nline = System.getProperty("line.separator");
				
				try {
					BufferedReader br = new BufferedReader(new FileReader("info.txt"));
					String line;
					while((line = br.readLine()) != null) {
						System.out.println(line);
						sb.append(line);
						sb.append(nline);
					}
					ta.setText(sb.toString());
					br.close();
				}catch(IOException e) {e.printStackTrace();}
				
				Scene sc = new Scene(p, 500,500);
				rs.setScene(sc);
				rs.setTitle("User Records");
				rs.show();
			}
		});
		
		//create scene and add to stage
		Scene scene = new Scene(gPane, 400,400);
		ps.setScene(scene);
		ps.setTitle("User Form Filling");
		ps.show();
		
	}
	
	public static void main(String[] args) {
		launch();
	}
		
	

}
