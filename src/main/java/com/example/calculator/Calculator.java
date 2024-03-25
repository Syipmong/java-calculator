package com.example.calculator;

import javax.swing.JFrame;

public class Calculator extends JFrame {
    public Calculator(CalculatorUI calculatorUI) {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);

        add(calculatorUI);

        setVisible(true);
    }
}