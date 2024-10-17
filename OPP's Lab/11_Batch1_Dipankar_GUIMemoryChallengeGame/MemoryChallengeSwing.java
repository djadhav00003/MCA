import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class MemoryChallengeSwing extends JFrame {

    private MemoryGame memoryGame;
    private JTextField numberInput;
    private JTextArea displayArea;
    private JTextField userInputField;
    private JButton startButton;
    private JButton enterButton;
    private JButton submitButton;
    private JLabel feedbackLabel;

    private List<Integer> userSequence;
    private int sequenceIndex;

    public MemoryChallengeSwing() {
        setTitle("Memory Challenge");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for user input settings
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.setPreferredSize(new Dimension(400, 100));

        JLabel numberLabel = new JLabel("How many numbers would you like to memorize?");
        numberInput = new JTextField(5);
        startButton = new JButton("Start");

        inputPanel.add(numberLabel);
        inputPanel.add(numberInput);
        inputPanel.add(startButton);

        // Panel for displaying numbers and feedback
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());

        displayArea = new JTextArea(5, 30);
        displayArea.setPreferredSize(new Dimension(400, 50));
        displayArea.setEditable(false);
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);

        feedbackLabel = new JLabel();
        feedbackLabel.setHorizontalAlignment(SwingConstants.CENTER);

        displayPanel.add(new JScrollPane(displayArea), BorderLayout.CENTER);
        displayPanel.add(feedbackLabel, BorderLayout.SOUTH);

        // Panel for user input field and buttons
        JPanel userInputPanel = new JPanel();
        userInputPanel.setLayout(new FlowLayout());

        userInputField = new JTextField(10);
        enterButton = new JButton("Enter");
        submitButton = new JButton("Submit");

        userInputPanel.add(userInputField);
        userInputPanel.add(enterButton);
        userInputPanel.add(submitButton);

        // Add panels to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.CENTER);
        add(userInputPanel, BorderLayout.SOUTH);

        startButton.addActionListener(new StartButtonListener());
        enterButton.addActionListener(new EnterButtonListener());
        submitButton.addActionListener(new SubmitButtonListener());

        // Initialize user sequence and index
        userSequence = new ArrayList<>();
        sequenceIndex = 0;
    }

    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int numberCount;
            try {
                numberCount = Integer.parseInt(numberInput.getText());
                if (numberCount < 1) {
                    feedbackLabel.setText("Please enter a number greater than 0.");
                    return;
                }
            } catch (NumberFormatException ex) {
                feedbackLabel.setText("Invalid entry. Please enter a valid integer.");
                return;
            }

            int displayDuration = Math.max(numberCount * 1000, 1000);
            memoryGame = new MemoryGame(numberCount, displayDuration, displayArea);
            memoryGame.generateSequence();

            // Display the sequence on the EDT
            SwingUtilities.invokeLater(() -> displaySequence());

            // Hide the sequence after the specified duration
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    SwingUtilities.invokeLater(() -> {
                        displayArea.setText("The numbers are now hidden.");
                        userInputField.setEnabled(true);
                        enterButton.setEnabled(true);
                        submitButton.setEnabled(true);
                        feedbackLabel.setText("The numbers are hidden now. Please enter them one by one.");
                    });
                }
            }, displayDuration);

            // Initialize user sequence and index
            userSequence.clear();
            sequenceIndex = 0;
        }

        private void displaySequence() {
            StringBuilder sb = new StringBuilder("Memorize the numbers:\n");
            for (int number : memoryGame.getNumberSequence()) {
                sb.append(number).append(" ");
            }
            displayArea.setText(sb.toString());
        }
    }

    private class EnterButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (userInputField.isEnabled()) {
                try {
                    int number = Integer.parseInt(userInputField.getText());
                    userSequence.add(number);
                    userInputField.setText(""); // Clear the input field
                    sequenceIndex++;

                    if (sequenceIndex >= memoryGame.getNumberSequence().size()) {
                        userInputField.setEnabled(false);
                        enterButton.setEnabled(false);
                        feedbackLabel.setText("All numbers entered. Click 'Submit' to check your sequence.");
                    } else {
                        feedbackLabel.setText("Number " + (sequenceIndex + 1) + " entered. Enter the next number.");
                    }
                } catch (NumberFormatException ex) {
                    feedbackLabel.setText("Invalid entry. Please enter a valid integer.");
                }
            }
        }
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (userSequence.size() != memoryGame.getNumberSequence().size()) {
                feedbackLabel.setText("You have not entered all the numbers.");
                return;
            }

            if (memoryGame.isSequenceCorrect(userSequence)) {
                feedbackLabel.setText("Well done! You remembered all the numbers correctly.");
            } else {
                feedbackLabel.setText("Incorrect. The correct sequence was: " + memoryGame.getNumberSequence());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MemoryChallengeSwing frame = new MemoryChallengeSwing();
            frame.setVisible(true);
        });
    }

    // MemoryGame class as a non-static inner class
    class MemoryGame {
        private List<Integer> numberSequence;
        private int sequenceLength;
        private int displayDuration;
        private JTextArea displayArea;

        public MemoryGame(int sequenceLength, int displayDuration, JTextArea displayArea) {
            this.sequenceLength = sequenceLength;
            this.displayDuration = displayDuration;
            this.numberSequence = new ArrayList<>();
            this.displayArea = displayArea;
        }

        public void generateSequence() {
            Random random = new Random();
            numberSequence.clear(); // Clear previous sequence
            for (int i = 0; i < sequenceLength; i++) {
                numberSequence.add(random.nextInt(100));
            }
        }

        public boolean isSequenceCorrect(List<Integer> userSequence) {
            return numberSequence.equals(userSequence);
        }

        public List<Integer> getNumberSequence() {
            return numberSequence;
        }
    }
}
