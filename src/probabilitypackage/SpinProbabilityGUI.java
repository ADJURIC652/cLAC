package probabilitypackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SpinProbabilityGUI extends JFrame implements ActionListener {
    private JLabel percentageLabel, spinsLabel, alreadyMadeLabel, neededLabel, noSuccessLabel;
    private JTextField percentageInput, spinsInput;
    private JButton calculateButton;

    public SpinProbabilityGUI() {
        super("Spin Probability Calculator");

        // Initialize UI components
        percentageLabel = new JLabel("Desired Percentage:");
        percentageInput = new JTextField(10);
        spinsLabel = new JLabel("Number of Spins:");
        spinsInput = new JTextField(10);
        alreadyMadeLabel = new JLabel("Already Made Spins:");
        neededLabel = new JLabel("Number of Spins Needed:");
        noSuccessLabel = new JLabel("Probability of No Success:");
        calculateButton = new JButton("Calculate");

        // Add action listener to the button
        calculateButton.addActionListener(this);

        // Layout components using a GridBagLayout for better flexibility
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        setLayout(layout);

        // Add components to the layout
        addComponent(layout, constraints, 0, 0, 1, 1, percentageLabel);
        addComponent(layout, constraints, 1, 0, 1, 1, percentageInput);
        addComponent(layout, constraints, 0, 1, 1, 1, spinsLabel);
        addComponent(layout, constraints, 1, 1, 1, 1, spinsInput);
        addComponent(layout, constraints, 0, 2, 1, 1, alreadyMadeLabel);
        addComponent(layout, constraints, 1, 2, 1, 1, neededLabel);
        addComponent(layout, constraints, 0, 3, 1, 1, noSuccessLabel);
        addComponent(layout, constraints, 0, 4, 2, 1, calculateButton);

        // Set window properties
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set a fixed window size
        setSize(600,300);
        setResizable(false);
    }

    private void addComponent(GridBagLayout layout, GridBagConstraints constraints, int x, int y, int width, int height, Component component) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        layout.setConstraints(component, constraints);
        add(component);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            calculateProbability();
        }
    }

    private void calculateProbability() {
        // Extract user input
        String percentageStr = percentageInput.getText();
        String spinsStr = spinsInput.getText();

        // Validate input (similar logic to your existing code)

        // Convert input to numbers
        double percentage = Double.parseDouble(percentageStr.replace(",", "."));
        double probability = percentage / 100;
        int spinsMade = Integer.parseInt(spinsStr);

        // Perform calculations using methods from your existing classes (e.g., Calculator)
        int spinsNeeded = Calculator.calculateSpins(probability);
        double probabilityNoSuccess = Calculator.calculateNoSuccessProbability(spinsMade, probability);

        // Update results labels with calculated values
        alreadyMadeLabel.setText("Already Made Spins: " + spinsMade);
        neededLabel.setText("Number of Spins Needed: " + spinsNeeded);
        noSuccessLabel.setText("Probability of No Success: " + Formatter.formatPercentage(probabilityNoSuccess));
    }

    public static void main(String[] args) {
        new SpinProbabilityGUI();
    }
}