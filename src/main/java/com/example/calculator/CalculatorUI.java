package com.example.calculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorUI extends JPanel {
    private JTextField displayField;
    private JButton[] numButtons;
    private JButton[] opButtons;
    private JButton equalsButton;
    private JButton clearButton;

    private String currentInput;
    private double result;

    public CalculatorUI() {
        setLayout(new BorderLayout());
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        displayField = new JTextField();
        displayField.setEditable(true);
        displayField.setFont(new Font("Arial", Font.PLAIN, 24)); // Set font size
        displayField.setBackground(Color.WHITE); // Set background color
        displayField.setForeground(Color.BLACK); // Set text color
        add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
        buttonPanel.setBackground(Color.GRAY); // Set background color

        numButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].setFont(new Font("Arial", Font.PLAIN, 20)); // Set font size
            numButtons[i].setBackground(Color.LIGHT_GRAY); // Set button background color
            numButtons[i].setForeground(Color.BLACK); // Set button text color
            buttonPanel.add(numButtons[i]);
        }

        opButtons = new JButton[4];
        opButtons[0] = new JButton("+");
        opButtons[1] = new JButton("-");
        opButtons[2] = new JButton("*");
        opButtons[3] = new JButton("/");
        for (JButton opButton : opButtons) {
            opButton.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font size
            opButton.setBackground(Color.LIGHT_GRAY); // Set button background color
            opButton.setForeground(Color.BLACK); // Set button text color
            buttonPanel.add(opButton);
        }

        equalsButton = new JButton("=");
        equalsButton.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font size
        equalsButton.setBackground(Color.GREEN); // Set button background color
        equalsButton.setForeground(Color.BLACK); // Set button text color
        buttonPanel.add(equalsButton);

        clearButton = new JButton("C");
        clearButton.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font size
        clearButton.setBackground(Color.RED); // Set button background color
        clearButton.setForeground(Color.WHITE); // Set button text color
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.CENTER);

        currentInput = "";
        result = 0.0;
    }

    public JTextField getDisplayField() {
        return displayField;
    }

    public JButton[] getNumButtons() {
        return numButtons;
    }

    public JButton[] getOpButtons() {
        return opButtons;
    }

    public JButton getEqualsButton() {
        return equalsButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }
}
