package ru.zaza.calculator;

public class Calculator {
    private String savedNumber = "", currentNumber = "";
    private String sign, result;
    private boolean isWasEquals = false;

    public boolean isWasEquals() {
        return isWasEquals;
    }

    public String getSavedNumber() {
        return savedNumber;
    }

    public String getCurrentNumber() {
        return currentNumber;
    }

    public String getSign() {
        return sign;
    }

    public String getResult() {
        return result;
    }

    public String addDigit(String digit) {
        isWasEquals = false;
        currentNumber += digit;
        return currentNumber;
    }

    public String divide() {
        sign = "/";
        if(isWasEquals) {
            if(result.contains(".0")) savedNumber = result.substring(0, result.length() - 2);
            else savedNumber = result;
            isWasEquals = false;
            return savedNumber + " " + sign;
        }
        savedNumber = currentNumber;
        currentNumber = "";
        return savedNumber + " " + sign;
    }

    public String multiply() {
        sign = "*";
        if(isWasEquals) {
            if(result.contains(".0")) savedNumber = result.substring(0, result.length() - 2);
            else savedNumber = result;
            isWasEquals = false;
            return savedNumber + " " + sign;
        }
        savedNumber = currentNumber;
        currentNumber = "";
        return savedNumber + " " + sign;
    }

    public String minus() {
        sign = "-";
        if(isWasEquals) {
            if(result.contains(".0")) savedNumber = result.substring(0, result.length() - 2);
            else savedNumber = result;
            isWasEquals = false;
            return savedNumber + " " + sign;
        }
        savedNumber = currentNumber;
        currentNumber = "";
        return savedNumber + " " + sign;
    }

    public String plus() {
        sign = "+";
        if(isWasEquals) {
            if(result.contains(".0")) savedNumber = result.substring(0, result.length() - 2);
            else savedNumber = result;
            isWasEquals = false;
            return savedNumber + " " + sign;
        }
        savedNumber = currentNumber;
        currentNumber = "";
        return savedNumber + " " + sign;
    }

    public String equals() {
        switch (sign) {
            case "/":
                result = String.valueOf(Double.parseDouble(savedNumber) / Double.parseDouble(currentNumber));
                currentNumber = "";
                savedNumber = "";
                isWasEquals = true;
                if(result.contains(".0")) return result.substring(0, result.length() - 2);
                else return result;
            case "*":
                result = String.valueOf(Double.parseDouble(savedNumber) * Double.parseDouble(currentNumber));
                currentNumber = "";
                savedNumber = "";
                isWasEquals = true;
                if(result.contains(".0")) return result.substring(0, result.length() - 2);
                else return result;
            case "-":
                result = String.valueOf(Double.parseDouble(savedNumber) - Double.parseDouble(currentNumber));
                currentNumber = "";
                savedNumber = "";
                isWasEquals = true;
                if(result.contains(".0")) return result.substring(0, result.length() - 2);
                else return result;
            case "+":
                result = String.valueOf(Double.parseDouble(savedNumber) + Double.parseDouble(currentNumber));
                currentNumber = "";
                savedNumber = "";
                isWasEquals = true;
                if(result.contains(".0")) return result.substring(0, result.length() - 2);
                else return result;
        }
        currentNumber = "";
        savedNumber = "";
        isWasEquals = true;
        return result;
    }

    public void clear() {
        savedNumber = "";
        currentNumber = "";
        sign = null;
        result = null;
    }

    public void clearCurrentNumber() {
        currentNumber = "";
    }

    public String clearOneDigit() {
        currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
        return currentNumber;
    }
}
