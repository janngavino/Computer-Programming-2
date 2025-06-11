import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabActivity6SwingToDoList {
    private JFrame mainFrame;
    private DefaultTableModel tableModel;
    private JTable taskTable;
    private JFrame inputFrame;

    public LabActivity6SwingToDoList() {
        // Initialize the main window
        mainFrame = new JFrame("To-Do List Viewer");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 300);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.getContentPane().setBackground(new Color(255, 224, 204)); // Light pastel pink

        // Table model and JTable setup
        String[] columnNames = {"Task Name", "Task Description", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0);
        taskTable = new JTable(tableModel);
        taskTable.setBackground(new Color(255, 255, 204)); // Light pastel yellow
        taskTable.setFillsViewportHeight(true);

        // Add components to the main frame
        mainFrame.add(new JScrollPane(taskTable), BorderLayout.CENTER);
        JButton addButton = new JButton("Add Task");
        addButton.setBackground(new Color(204, 255, 204)); // Light pastel green
        addButton.setFocusPainted(false);
        addButton.addActionListener(new AddTaskActionListener());
        mainFrame.add(addButton, BorderLayout.NORTH);

        // Make the main window visible
        mainFrame.setVisible(true);
    }

    private void openInputForm() {
        // Prevent opening multiple forms
        if (inputFrame != null && inputFrame.isVisible()) {
            return; // Do nothing if the form is already open
        }

        // Initialize the input form window
        inputFrame = new JFrame("To-Do List Form");
        inputFrame.setSize(300, 300);
        inputFrame.setLayout(new FlowLayout());
        inputFrame.getContentPane().setBackground(new Color(204, 229, 255)); // Light pastel blue

        // Text fields for task input
        JTextField taskNameField = new JTextField(15);
        JTextArea taskDescArea = new JTextArea(5, 15);
        taskDescArea.setLineWrap(true);
        taskDescArea.setWrapStyleWord(true);
        String[] statuses = {"Not Started", "Ongoing", "Completed"};
        JComboBox<String> statusComboBox = new JComboBox<>(statuses);
        JButton submitButton = new JButton("Save Task");
        submitButton.setBackground(new Color(255, 204, 204)); // Light pastel peach

        // Action listener for the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskName = taskNameField.getText();
                String taskDesc = taskDescArea.getText();
                String status = (String) statusComboBox.getSelectedItem();

                if (!taskName.trim().isEmpty()) {
                    tableModel.addRow(new Object[]{taskName, taskDesc, status});
                    taskNameField.setText("");
                    taskDescArea.setText("");
                    inputFrame.dispose(); // Close input window after adding
                    inputFrame = null; // Reset input frame reference
                } else {
                    JOptionPane.showMessageDialog(inputFrame, "Task Name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add components to the input frame
        inputFrame.add(new JLabel("Task Name:"));
        inputFrame.add(taskNameField);
        inputFrame.add(new JLabel("Description:"));
        inputFrame.add(new JScrollPane(taskDescArea)); // Use JScrollPane for text area
        inputFrame.add(new JLabel("Status:"));
        inputFrame.add(statusComboBox);
        inputFrame.add(submitButton);
        
        // Make the input window visible
        inputFrame.setVisible(true);
    }

    // Action listener for the "Add Task" button
    private class AddTaskActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            openInputForm();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LabActivity6SwingToDoList::new);
    }
}