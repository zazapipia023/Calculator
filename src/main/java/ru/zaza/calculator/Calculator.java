package ru.zaza.calculator;

public class Calculator {
    private String savedNumber = "", currentNumber = "";
    private String sign = "", result;
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
            if(result.endsWith(".0")) savedNumber = result.substring(0, result.length() - 2);
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
            if(result.endsWith(".0")) savedNumber = result.substring(0, result.length() - 2);
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
            if(result.endsWith(".0")) savedNumber = result.substring(0, result.length() - 2);
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
            if(result.endsWith(".0")) savedNumber = result.substring(0, result.length() - 2);
            else savedNumber = result;
            isWasEquals = false;
            return savedNumber + " " + sign;
        }
        savedNumber = currentNumber;
        currentNumber = "";
        return savedNumber + " " + sign;
    }

    public String equals() {
        if(savedNumber.isEmpty()) {
            result = currentNumber;
            clear();
            isWasEquals = true;
            return result;
        }
        switch (sign) {
            case "/" -> {
                result = String.valueOf(Double.parseDouble(savedNumber) / Double.parseDouble(currentNumber));
                clear();
                isWasEquals = true;
                if (result.endsWith(".0")) return result.substring(0, result.length() - 2);
                else return result;
            }
            case "*" -> {
                result = String.valueOf(Double.parseDouble(savedNumber) * Double.parseDouble(currentNumber));
                clear();
                isWasEquals = true;
                if (result.endsWith(".0")) return result.substring(0, result.length() - 2);
                else return result;
            }
            case "-" -> {
                result = String.valueOf(Double.parseDouble(savedNumber) - Double.parseDouble(currentNumber));
                clear();
                isWasEquals = true;
                if (result.endsWith(".0")) return result.substring(0, result.length() - 2);
                else return result;
            }
            case "+" -> {
                result = String.valueOf(Double.parseDouble(savedNumber) + Double.parseDouble(currentNumber));
                clear();
                isWasEquals = true;
                if (result.endsWith(".0")) return result.substring(0, result.length() - 2);
                else return result;
            }
        }
        clear();
        isWasEquals = true;
        return result;
    }

    public void clear() {
        savedNumber = "";
        currentNumber = "";
        sign = "";
    }

    public void clearCurrentNumber() {
        currentNumber = "";
    }

    public String clearOneDigit() {
        currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
        return currentNumber;
    }

    public String sqrt() {
        isWasEquals = true;
        result = String.valueOf(Math.sqrt(Double.parseDouble(currentNumber)));
        savedNumber = currentNumber;
        currentNumber = result;
        if (result.endsWith(".0")) return result.substring(0, result.length() - 2);
        return result;
    }

    public String sqr() {
        isWasEquals = true;
        result = String.valueOf(Math.pow(Double.parseDouble(currentNumber), 2));
        savedNumber = currentNumber;
        currentNumber = result;
        if (result.endsWith(".0")) return result.substring(0, result.length() - 2);
        return result;
    }

    public String divideOne() {
        isWasEquals = true;
        result = String.valueOf(1 / Double.parseDouble(currentNumber));
        savedNumber = currentNumber;
        currentNumber = result;
        if (result.endsWith(".0")) return result.substring(0, result.length() - 2);
        return result;
    }
}
