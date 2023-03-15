
/**********************************************
Workshop 6
Course: JAC444
Last Name: CAO
First Name: Siran
ID: 159235209
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 03/15/2023
**********************************************/

package nameRank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AppController {

    @FXML
    private Button btnExit;

    @FXML
    private Button btnSubmit;

    @FXML
    private TextField tfGender;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfYear;

    @FXML
    public void onSubmit(ActionEvent event) {
    	String header = null;
    	
    	try {
        	char gender = tfGender.getText().charAt(0);
        	String name = tfName.getText();
        	int year = Integer.parseInt(tfYear.getText());
        	
        	if(year < 2009 || year > 2018) {
        		header = "Please enter year between 2009 - 2018";
        	}
        	else if (gender != 'f' && gender != 'F' && gender != 'm' && gender != 'M') {
        		header = "Invalid gender, please enter m/f or M/F";
        	}
        	else {
        		//header = name;
    			int rank = 0;
    			boolean flag = false;
        		String fileName = "babynamesranking" + Integer.toString(year) + ".txt";
        		
        		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        			String line;
        			while((line = br.readLine()) != null && !flag) {
        				rank++;
        				String[] token = line.split(" \t");
        				flag = (gender == 'm' || gender == 'M') ? token[1].toLowerCase().contains(name.toLowerCase()) : token[2].toLowerCase().contains(name.toLowerCase());
        				
        			}
        			
        			if(flag) {
        				String sex = (gender == 'm' || gender == 'M') ? "Boy" : "Girl";
        				header = sex + " name " + name + " is ranked #" + Integer.toString(rank) + " in " + Integer.toString(year) + " year";
        			}
        			else {
        				header = "Sorry, cannot find any results on this name";
        			}
        		
        			
        		}
        		catch(IOException e) {
        			e.printStackTrace();
        			header = "Error: cannot read data";
        		}
        	}   
    	}
    	catch(NumberFormatException e) {
    		e.printStackTrace();
    		header = "Invalid year number, please try again";
    	}

    	display(header);
    }
    
    @FXML
    public void onExit(ActionEvent event) {
      Stage stage = (Stage)btnExit.getScene().getWindow();
      stage.close();
    }

    
    
    public void display(String header) {
    	//create new stage with nodes
    	Stage result = new Stage();
    	GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setVgap(50);

    	Button btnYes = new Button("Yes");
    	Button btnNo = new Button("No");
    	btnYes.setPrefSize(90, 25);
    	btnNo.setPrefSize(90, 25);
    	pane.add(new Label(header), 0, 0);
    	pane.add(new Label("Do you want to search for another name?"), 0, 1);
    	pane.add(btnYes, 0, 2);
    	pane.add(btnNo, 1, 2);

      	//mount scene
      	Scene sc = new Scene(pane, 400, 300);
      	result.setScene(sc);
      	result.setTitle("Search Result");
      	result.setResizable(false);
      	result.show();
    	
      	//add event handler
      	btnYes.setOnAction(new EventHandler<ActionEvent>() {
      		@Override
      		public void handle(ActionEvent arg) {
      			tfYear.clear();
      			tfGender.clear();
      			tfName.clear();
      			Stage stage = (Stage)btnYes.getScene().getWindow();
      			stage.close();
      		}
      	});
      	
      	btnNo.setOnAction(new EventHandler<ActionEvent>() {
      		@Override
      		public void handle(ActionEvent arg) {
      			Stage stage2 = (Stage)btnNo.getScene().getWindow();
      			stage2.close();
      			Stage stage1 = (Stage)btnExit.getScene().getWindow();
      			stage1.close();
      		}
      	});
      	
    }


}
