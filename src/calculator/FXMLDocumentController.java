/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author rinal
 */
public class FXMLDocumentController implements Initializable {
    
    private BigDecimal left;
    private String selectedOperator;
    private boolean numberInputting;
    
    @FXML
    private TextField textfield;
    @FXML
    private TextField textfield1;
    
    public FXMLDocumentController(){
        this.left = BigDecimal.ZERO;
        this.selectedOperator = "";
        this.numberInputting = false;
    }
    
    @FXML
    public void operateButton(ActionEvent evt){
        Button btn = (Button)evt.getSource();
        String buttonText = btn.getText();
        
        if(buttonText.equals("C")){
            if(buttonText.equals("C")){
                left = BigDecimal.ZERO;
            }
            
            selectedOperator = "";
            numberInputting = true;
            textfield.clear();
            textfield1.clear();
            return;
        }
        
        if(buttonText.matches("[0-9\\.]")){
            if(!numberInputting){
                numberInputting = true;
                textfield.clear();
            }
            
            textfield.appendText(buttonText);
            return;
        }
        
        if(buttonText.equals("+")){
            left = new BigDecimal(textfield.getText());
            selectedOperator = buttonText;
            numberInputting = false;
            textfield1.setText(left.toString() + selectedOperator);
            textfield.appendText(buttonText);
            return;
        }
        if(buttonText.equals("-")){
            left = new BigDecimal(textfield.getText());
            selectedOperator = buttonText;
            numberInputting = false;
            textfield1.setText(left.toString() + selectedOperator);
            textfield.appendText(buttonText);
            return;
        }
        if(buttonText.equals("*")){
            left = new BigDecimal(textfield.getText());
            selectedOperator = buttonText;
            numberInputting = false;
            textfield1.setText(left.toString() + selectedOperator);
            textfield.appendText(buttonText);
            return;
        }
        if(buttonText.equals("/")){
            left = new BigDecimal(textfield.getText());
            selectedOperator = buttonText;
            numberInputting = false;
            textfield1.setText(left.toString() + selectedOperator);
            textfield.appendText(buttonText);
            return;
        }
                                
        
        if(buttonText.equals("=")){
            final BigDecimal right = numberInputting ? new BigDecimal(textfield.getText()) : left;
            textfield1.setText(left.toString() + selectedOperator + right);
            left = calculate(selectedOperator, left, right);
            textfield.setText(left.toString());
            numberInputting = false;
            return;
        }
    }
    
    static BigDecimal calculate(String operator, BigDecimal left, BigDecimal right){
        switch(operator){
            case "+":
                return left.add(right);
            case "-":
                return left.subtract(right);
            case "*":
                return left.multiply(right);
            case "/":
                return left.divide(right);
        }
        return right;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
