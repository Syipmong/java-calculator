package com.example.calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener {
    private CalculatorUI ui;
    private StringBuilder inputBuffer;
    private char operator;
    private double operand1;

    public CalculatorController(CalculatorUI ui) {
        this.ui = ui;
        inputBuffer = new StringBuilder();
        attachListeners();
    }

    private void attachListeners() {
        ui.getEqualsButton().addActionListener(this);
        ui.getClearButton().addActionListener(this);
        for (JButton numButton : ui.getNumButtons()) {
            numButton.addActionListener(this);
        }
        for (JButton opButton : ui.getOpButtons()) {
            opButton.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (Character.isDigit(command.charAt(0))) {
            inputBuffer.append(command);
            ui.getDisplayField().setText(inputBuffer.toString());
        } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            if (inputBuffer.length() > 0) {
                operand1 = Double.parseDouble(inputBuffer.toString());
                operator = command.charAt(0);
                inputBuffer.setLength(0);
            }
        } else if (command.equals("=")) {
            if (inputBuffer.length() > 0) {
                double operand2 = Double.parseDouble(inputBuffer.toString());
                double result = performOperation(operand1, operand2, operator);
                ui.getDisplayField().setText(String.valueOf(result));
                inputBuffer.setLength(0);
                inputBuffer.append(result);
            }
        } else if (command.equals("C")) {
            inputBuffer.setLength(0);
            ui.getDisplayField().setText("");
        }
    }

    private double performOperation(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    JOptionPane.showMessageDialog(ui, "Error: Division by zero!");
                    return Double.NaN;
                }
            default:
                return Double.NaN;
        }
    }
}
