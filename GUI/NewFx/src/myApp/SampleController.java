package myApp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class SampleController {
	
	private static final NumberFormat CURRENCY = NumberFormat.getCurrencyInstance();
	private static final NumberFormat PERCENTAGE = NumberFormat.getPercentInstance();
	private BigDecimal tipPercentage = new BigDecimal(0.15);

    @FXML
    private TextField amountField;

    @FXML
    private Button calcBtn;

    @FXML
    private TextField tipField;

    @FXML
    private Label tipLevel;

    @FXML
    private Slider tipSlider;

    @FXML
    private TextField totalField;

    @FXML
    void clickBtn(ActionEvent event) {
    	try {
    		BigDecimal amount = new BigDecimal(amountField.getText());
    		BigDecimal tip = amount.multiply(tipPercentage);
    		BigDecimal total = amount.add(tip);
    		
    		tipField.setText(CURRENCY.format(tip));
    		totalField.setText(CURRENCY.format(total));
    		
    	}
    	catch(NumberFormatException e) {
    		amountField.setText("Enter valid amount");
    		amountField.selectAll();
    		amountField.requestFocus();
    	}
    }
    
    public void initialize() {
    	CURRENCY.setRoundingMode(RoundingMode.HALF_UP);
    	tipSlider.valueProperty().addListener(new ChangeListener<Number>() {
    		
    		@Override
    		public void changed(ObservableValue<? extends Number> ov, Number oldv, Number nv) {
    			tipPercentage = BigDecimal.valueOf(nv.intValue()/100.0);
    			tipLevel.setText(PERCENTAGE.format(tipPercentage));
    		}
    	});

    }	
    	
    	
}
