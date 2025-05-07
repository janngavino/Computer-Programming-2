import java.awt.*;
import java.awt.event.*;

public class LabActivity4EmpInfoSystemGUI extends Frame implements ActionListener {
    // Declare components
    Label lblFirstName, lblLastName, lblHoursWorked, lblHourlyRate, lblDailyWage;
    TextField txtFirstName, txtLastName, txtHoursWorked, txtHourlyRate, txtDailyWage;
    Button btnCalculate, btnClear;

    public LabActivity4EmpInfoSystemGUI() {
        // Set layout
        setLayout(new GridLayout(6, 2)); // 6 rows, 2 columns

        // Initialize labels and text fields
        lblFirstName = new Label("First Name:");
        txtFirstName = new TextField(20);
        lblLastName = new Label("Last Name:");
        txtLastName = new TextField(20);
        lblHoursWorked = new Label("Hours Worked:");
        txtHoursWorked = new TextField(10);
        lblHourlyRate = new Label("Hourly Rate:");
        txtHourlyRate = new TextField(10);
        lblDailyWage = new Label("Daily Wage:");
        txtDailyWage = new TextField(10);
        txtDailyWage.setEditable(false); // Non-editable field

        // Initialize buttons
        btnCalculate = new Button("Calculate");
        btnClear = new Button("Clear");

        // Add components to frame
        add(lblFirstName);
        add(txtFirstName);
        add(lblLastName);
        add(txtLastName);
        add(lblHoursWorked);
        add(txtHoursWorked);
        add(lblHourlyRate);
        add(txtHourlyRate);
        add(btnCalculate);
        add(btnClear);
        add(lblDailyWage);
        add(txtDailyWage);

        // Add action listeners
        btnCalculate.addActionListener(this);
        btnClear.addActionListener(this);

        // Frame settings
        setTitle("Employee Info System");
        setSize(300, 300);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalculate) {
            try {
                String firstName = txtFirstName.getText().trim();
                String lastName = txtLastName.getText().trim();
                double hoursWorked = Double.parseDouble(txtHoursWorked.getText().trim());
                double hourlyRate = Double.parseDouble(txtHourlyRate.getText().trim());

                // Basic validation
                if (firstName.isEmpty() || lastName.isEmpty() || hoursWorked < 0 || hourlyRate < 0) {
                    txtDailyWage.setText("Invalid input!");
                    return;
                }

                // Calculate daily wage
                double dailyWage = hoursWorked * hourlyRate;
                txtDailyWage.setText(String.format("%.2f", dailyWage));
            } catch (NumberFormatException ex) {
                txtDailyWage.setText("Invalid number!");
            }
        } else if (e.getSource() == btnClear) {
            // Clear all fields
            txtFirstName.setText("");
            txtLastName.setText("");
            txtHoursWorked.setText("");
            txtHourlyRate.setText("");
            txtDailyWage.setText("");
        }
    }

    public static void main(String[] args) {
        new LabActivity4EmpInfoSystemGUI();
    }
}