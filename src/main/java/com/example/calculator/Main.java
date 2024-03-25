package com.example.calculator;

public class Main {
    public static void main(String[] args) {
        CalculatorUI ui = new CalculatorUI();
        CalculatorController controller = new CalculatorController(ui);
        Calculator calculator = new Calculator(ui);
        calculator.setVisible(true);
    }
}