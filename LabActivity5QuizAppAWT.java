import java.awt.*;
import java.awt.event.*;

public class LabActivity5QuizAppAWT extends Frame {
    Label questionLabel;
    CheckboxGroup options;
    Button nextButton;
    TextArea resultArea;

    // Array of questions and correct answers
    String[] questions = {
        "Which was the first web browser?",
        "What does HTTP stand for?",
        "Which of the following is responsible for managing computer resources?"
    };

    String[][] choices = {
        {"A. WorldWideWeb", "B. Netscape Navigator", "C. Internet Explorer", "D. Safari"},
        {"A. Hypertext Transfer Protocol", "B. Hypertext Transfer Plotter", "C. Head Tail Transfer Plot", "D. Head Tail Transfer Protocol"},
        {"A. Application Software", "B. Motherboard", "C. Operating System", "D. RAM"}
    };

    int[] answers = {0, 0, 2}; // Indexes of the correct answers
    int currentQuestion = 0;
    int score = 0;

    public LabActivity5QuizAppAWT() {
        // Set up the frame
        setTitle("Quiz Application");
        setSize(500, 300);
        setLayout(new FlowLayout());

        // Create components
        questionLabel = new Label(questions[currentQuestion]);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Set font style

        options = new CheckboxGroup();
        addChoices();

        nextButton = new Button("Next Question");
        customizeButton(nextButton);

        resultArea = new TextArea(5, 30);

        // Add components to the frame
        add(questionLabel);
        add(nextButton);
        add(resultArea);

        // Add action listener to the button
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Checkbox selected = options.getSelectedCheckbox();
                if (selected != null) {
                    int selectedIndex = -1;
                    String selectedLabel = selected.getLabel();

                    // Determine the selected index
                    for (int i = 0; i < choices[currentQuestion].length; i++) {
                        if (choices[currentQuestion][i].equals(selectedLabel)) {
                            selectedIndex = i;
                            break;
                        }
                    }

                    // Check if the answer is correct
                    if (selectedIndex == answers[currentQuestion]) {
                        resultArea.setText("Correct answer!");
                        score++;
                    } else {
                        resultArea.setText("Incorrect! The correct answer is: " + choices[currentQuestion][answers[currentQuestion]]);
                    }

                    // Move to the next question
                    currentQuestion++;
                    if (currentQuestion < questions.length) {
                        questionLabel.setText(questions[currentQuestion]);
                        resetSelections(); // Reset checkbox selection
                        addChoices(); // Add next choices
                    } else {
                        // Display final score
                        resultArea.setText("Quiz complete! You got " + score + " out of " + questions.length + " correct!");
                        disableQuiz(); // Disable the button and choices
                    }
                } else {
                    resultArea.setText("Please select an answer.");
                }
            }
        });

        // Add window listener for closing the application
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0); // Terminate the program
            }
        });

        // Set visibility
        setVisible(true);
    }

    private void addChoices() {
        for (String choice : choices[currentQuestion]) {
            Checkbox checkbox = new Checkbox(choice, options, false);
            customizeCheckbox(checkbox); // Customize each checkbox
            add(checkbox);
        }
    }

    private void resetSelections() {
        options.setSelectedCheckbox(null); // Reset selection
        for (Component comp : getComponents()) {
            if (comp instanceof Checkbox) {
                ((Checkbox) comp).setState(false);
            }
        }
    }

    private void customizeCheckbox(Checkbox checkbox) {
        checkbox.setFont(new Font("Arial", Font.PLAIN, 14)); // Customize checkbox font
    }

    private void customizeButton(Button button) {
        button.setBackground(Color.LIGHT_GRAY); // Customize button background color
        button.setFont(new Font("Arial", Font.BOLD, 14)); // Customize button font
    }

    private void disableQuiz() {
        nextButton.setEnabled(false); // Disable the next button
        for (Component comp : getComponents()) {
            if (comp instanceof Checkbox) {
                ((Checkbox) comp).setEnabled(false); // Disable all checkboxes
            }
        }
    }

    public static void main(String[] args) {
        new LabActivity5QuizAppAWT();
    }
}