package calculator;

import calculator.model.Calculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Arrays;

public class CalculatorController {

    @FXML
    private TextField display;

    private Calculator calculator;
    private boolean startNumber = true;
    private float number1;
    private String operator = "";
    private boolean float_used=false;
    private int c_number=0;

    @FXML
    private void initialize() {
        calculator = new Calculator();
    }

    @FXML
    public void processDigit(ActionEvent event) {
        String digitPressed = ((Button) event.getSource()).getText();
        System.out.println(digitPressed);
        if (startNumber || display.getText().equals("0")) {
            display.setText(digitPressed);
        } else {
            display.setText(display.getText() + digitPressed);
        }
        startNumber = false;
    }

    @FXML
    public void processOperator(ActionEvent event) {
        String operatorPressed = ((Button) event.getSource()).getText();
        System.out.println(operatorPressed);
        if (operatorPressed.equals("=")) {
           if (operator.isEmpty()) {
               return;
           }
           float number2 = Float.parseFloat(display.getText());
           float result = (float) calculator.calculate(number1, number2, operator);

            result_display(result,number2);

           operator = "";
        } else {
            if (! operator.isEmpty()) {
                return;
            }
            number1 =Float.parseFloat(display.getText());
            operator = operatorPressed;
            startNumber = true;
        }
    }

    private void result_display(float result,float number2){
        if (float_used){
            String[] arrOfStr= String.valueOf(number1).split("[.]",2);
            String[] arrOfStr2= String.valueOf(number2).split("[.]",2);

            c_number=Math.max(arrOfStr[1].length(),arrOfStr2[1].length());
            display.setText(String.format("%."+c_number+"f", result));

        }
        else{
            c_number=0;
            display.setText(String.format("%."+c_number+"f", result));
        }
    }

    @FXML
    public void delete_all(){
        System.out.println("delete");
        display.setText("0");
        startNumber=true;
        float_used=false;
    }
    @FXML
    public void SignumChange(){
        System.out.println("signum ");
        if (display.getText().startsWith("-"))
        {
            display.setText(display.getText().substring(1));
        }
        else{
            display.setText("-"+display.getText());
        }
    }
        @FXML
        public void floatpoint()
        {
            float_used=true;
            System.out.println("float init");
            display.setText(display.getText().concat("."));
        }




}
