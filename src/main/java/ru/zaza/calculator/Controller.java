package ru.zaza.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.Objects;

public class Controller {
    private Calculator calculator = new Calculator();
    @FXML
    private Label savedNumber, currentNumber;

    public void buttonZero(MouseEvent e) {
        if(calculator.isWasEquals()) savedNumber.setText("");
        currentNumber.setText(calculator.addDigit("0"));
    }
    public void buttonOne(MouseEvent e) {
        if(calculator.isWasEquals()) savedNumber.setText("");
        currentNumber.setText(calculator.addDigit("1"));
    }
    public void buttonTwo(MouseEvent e) {
        if(calculator.isWasEquals()) savedNumber.setText("");
        currentNumber.setText(calculator.addDigit("2"));
    }
    public void buttonThree(MouseEvent e) {
        if(calculator.isWasEquals()) savedNumber.setText("");
        currentNumber.setText(calculator.addDigit("3"));
    }
    public void buttonFour(MouseEvent e) {
        if(calculator.isWasEquals()) savedNumber.setText("");
        currentNumber.setText(calculator.addDigit("4"));
    }
    public void buttonFive(MouseEvent e) {
        if(calculator.isWasEquals()) savedNumber.setText("");
        currentNumber.setText(calculator.addDigit("5"));
    }
    public void buttonSix(MouseEvent e) {
        if(calculator.isWasEquals()) savedNumber.setText("");
        currentNumber.setText(calculator.addDigit("6"));
    }
    public void buttonSeven(MouseEvent e) {
        if(calculator.isWasEquals()) savedNumber.setText("");
        currentNumber.setText(calculator.addDigit("7"));
    }
    public void buttonEight(MouseEvent e) {
        if(calculator.isWasEquals()) savedNumber.setText("");
        currentNumber.setText(calculator.addDigit("8"));
    }
    public void buttonNine(MouseEvent e) {
        if(calculator.isWasEquals()) savedNumber.setText("");
        currentNumber.setText(calculator.addDigit("9"));
    }

    public void buttonDot(MouseEvent e) {
        if(String.valueOf(calculator.getCurrentNumber()).matches("\\d+")) currentNumber.setText(calculator.addDigit("."));
    }

    public void onKeyPressed(KeyEvent keyEvent) {
//        System.out.println(keyEvent.getCode());
        if(keyEvent.getCode().equals(KeyCode.BACK_SPACE)) clearOneDigit();
        if(keyEvent.getCode().isWhitespaceKey()) pressSign("=");
        if(keyEvent.getText().matches("\\d+")) pressNumber(keyEvent.getText());
        if(keyEvent.getText().matches("(\\+|-|\\*|/|=|\\.)+")) pressSign(keyEvent.getText());
    }

    public void pressNumber(String digit) {
        if(calculator.isWasEquals()) savedNumber.setText("");
        currentNumber.setText(calculator.addDigit(digit));
    }

    public void pressSign(String sign) {
        switch (sign) {
            case ".":
                if(String.valueOf(calculator.getCurrentNumber()).matches("\\d+")) currentNumber.setText(calculator.addDigit("."));
                break;
            case "/":
                divide();
                break;
            case "*":
                multiply();
                break;
            case "-":
                minus();
                break;
            case "+":
                plus();
                break;
            case "=":
                equals();
                break;
            default:
                break;
        }
    }

    public void divide() {
        currentNumber.setText("");
        savedNumber.setText(calculator.divide());
    }

    public void divide(MouseEvent e) {
        currentNumber.setText("");
        savedNumber.setText(calculator.divide());
    }

    public void multiply() {
        currentNumber.setText("");
        savedNumber.setText(calculator.multiply());
    }

    public void multiply(MouseEvent e) {
        currentNumber.setText("");
        savedNumber.setText(calculator.multiply());
    }

    public void minus() {
        currentNumber.setText("");
        savedNumber.setText(calculator.minus());
    }

    public void minus(MouseEvent e) {
        currentNumber.setText("");
        savedNumber.setText(calculator.minus());
    }

    public void plus() {
        currentNumber.setText("");
        savedNumber.setText(calculator.plus());
    }

    public void plus(MouseEvent e) {
        currentNumber.setText("");
        savedNumber.setText(calculator.plus());
    }

    public void equals() {
        savedNumber.setText(calculator.getSavedNumber() + " " + calculator.getSign() + " " + calculator.getCurrentNumber() + " =");
        currentNumber.setText(calculator.equals());
    }

    public void equals(MouseEvent e) {
        savedNumber.setText(calculator.getSavedNumber() + " " + calculator.getSign() + " " + calculator.getCurrentNumber() + " =");
        currentNumber.setText(calculator.equals());
    }

    public void clear(MouseEvent e) {
        calculator.clear();
        savedNumber.setText("");
        currentNumber.setText("0");
    }

    public void clearCurrentNumber(MouseEvent e) {
        currentNumber.setText("0");
        calculator.clearCurrentNumber();
    }

    public void clearOneDigit(MouseEvent e) {
        currentNumber.setText(calculator.clearOneDigit());
        if(currentNumber.getText().equals("")) currentNumber.setText("0");
    }

    public void clearOneDigit() {
        currentNumber.setText(calculator.clearOneDigit());
        if(currentNumber.getText().equals("")) currentNumber.setText("0");
    }
}