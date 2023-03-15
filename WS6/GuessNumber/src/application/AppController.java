
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

package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AppController {
	Random rand = new Random();
	private static final int MAX = 1000;
	private static final int MIN = 0;
	private int answer = rand.nextInt(MAX + 1);;

	private void resetGame() {
		answer = rand.nextInt(MAX + 1);
		leftHint.setText("Game Starts!");
		rightHint.setText("Please enter your first guess");
		leftHint.setTextFill(Color.BLUE);
		rightHint.setTextFill(Color.BLUE);
		tfInput.setDisable(false);
		tfInput.setStyle("-fx-background-color: white;");
		tfInput.clear();
	}
	
    @FXML
    private Button btnExit;

    @FXML
    private Button btnGuess;

    @FXML
    private Button btnNewGame;

    @FXML
    private Label leftHint;

    @FXML
    private Label rightHint;

    @FXML
    private TextField tfInput;

    @FXML
    void exitGame(ActionEvent event) {
        Stage stage = (Stage)btnExit.getScene().getWindow();
        stage.close();
    }
    
    
    private void checkGuess(int guess) {
		leftHint.setText("Keep Guessing");
		
		if((guess - answer) > 0) {
			rightHint.setText("Too High");
			tfInput.setStyle("-fx-background-color: #ff6347;");
		}
		else {
			rightHint.setText("Too Low");
			tfInput.setStyle("-fx-background-color: #4169e1;");
		}
		
		leftHint.setTextFill(Color.BLUE);
		rightHint.setTextFill(Color.BLUE);			
    }
    

    @FXML
    void guessNum(ActionEvent event) {
    	System.out.println(answer);
    	try {
    		int guess = Integer.parseInt(tfInput.getText());
    		
    		if(guess > MAX || guess < MIN) {
        		leftHint.setText("Error!");
        		rightHint.setText("Number out of range");
        		leftHint.setTextFill(Color.RED);
        		rightHint.setTextFill(Color.RED);
    		}
    		else if(guess == answer) {
        		leftHint.setText("Correct!");
        		rightHint.setText("You guess the right answer");
        		leftHint.setTextFill(Color.GREEN);
        		rightHint.setTextFill(Color.GREEN);
        		tfInput.setDisable(true);
    			tfInput.setStyle("-fx-background-color: green;");
    		}
    		else {
    			checkGuess(guess);
    		}
    		
    	}
    	catch(NumberFormatException e) {
    		e.printStackTrace();
    		leftHint.setText("Error!");
    		rightHint.setText("Invalid input number");
    		leftHint.setTextFill(Color.RED);
    		rightHint.setTextFill(Color.RED);
    	}
    
    }

    @FXML
    void newGame(ActionEvent event) {
    	resetGame();
    }

}
