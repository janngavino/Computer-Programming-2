import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class finallabprojectcalculator extends JFrame implements ActionListener {
    private JTextField display;
    private String operator;
    private double num1, num2, result;
    private double memoryValue = 0; // Memory variable

    public Calculator() {
        // Set up the frame
        setTitle("Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create display
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setBackground(new Color(255, 228, 225)); // Light pink background
        display.setForeground(new Color(220, 20, 60)); // Strawberry red text
        add(display, BorderLayout.NORTH);

        // Create buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 4, 10, 10)); // Set to 8 rows and 4 columns
        panel.setBackground(new Color(255, 192, 203)); // Pastel pink background

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "DEL", "+",
            "%", "+/-", "√", "^",
            "M+", "M-", "MR", "MC"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.setBackground(new Color(255, 182, 193)); // Light strawberry pink for buttons
            button.setForeground(new Color(255, 20, 147)); // Deeper strawberry color for text
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "C":
                display.setText("");
                operator = null;
                break;
            case "DEL":
                String currentText = display.getText();
                if (!currentText.isEmpty()) {
                    display.setText(currentText.substring(0, currentText.length() - 1)); // Remove last character
                }
                break;
            case "=":
                num2 = Double.parseDouble(display.getText());
                calculateResult();
                break;
            case "+/-":
                toggleSign();
                break;
            case "√":
                calculateSquareRoot();
                break;
            case "^":
                num1 = Double.parseDouble(display.getText());
                operator = command;
                display.setText("");
                break;
            case "M+":
                memoryAdd();
                break;
            case "M-":
                memorySubtract();
                break;
            case "MR":
                memoryRecall();
                break;
            case "MC":
                memoryClear();
                break;
            default:
                if ("0123456789".contains(command)) {
                    display.setText(display.getText() + command);
                } else {
                    if (!display.getText().isEmpty()) {
                        num1 = Double.parseDouble(display.getText());
                        operator = command;
                        display.setText("");
                    }
                }
                break;
        }
    }

    private void toggleSign() {
        if (!display.getText().isEmpty()) {
            double currentValue = Double.parseDouble(display.getText());
            currentValue = -currentValue; // Toggle sign
            display.setText(String.valueOf(currentValue));
        }
    }

    private void calculateSquareRoot() {
        if (!display.getText().isEmpty()) {
            double currentValue = Double.parseDouble(display.getText());
            if (currentValue >= 0) {
                result = Math.sqrt(currentValue);
                display.setText(String.valueOf(result));
            } else {
                display.setText("Error");
            }
        }
    }

    private void calculateResult() {
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    display.setText("Error");
                    return;
                }
                break;
            case "%":
                result = num1 % num2;
                break;
            case "^":
                result = Math.pow(num1, num2);
                break;
        }
        display.setText(String.valueOf(result));
        operator = null; // Reset operator after calculation
    }

    private void memoryAdd() {
        if (!display.getText().isEmpty()) {
            memoryValue += Double.parseDouble(display.getText());
        }
    }

    private void memorySubtract() {
        if (!display.getText().isEmpty()) {
            memoryValue -= Double.parseDouble(display.getText());
        }
    }

    private void memoryRecall() {
        display.setText(String.valueOf(memoryValue));
    }

    private void memoryClear() {
        memoryValue = 0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}