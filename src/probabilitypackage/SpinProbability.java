package probabilitypackage;

import java.util.Scanner;

public class SpinProbability {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please type desired percentage");
            String input = scanner.nextLine(); // Probability of success on a single spin

            //allows user to end programm
            if (input.equalsIgnoreCase("quit")) {
                break;
            }

            //Checks for invalid inputs
            if (!InputValidator.isValidPercentage(input)) {
                System.out.println("Invalid input. Please enter a valid Percentage");
                continue;
            }

            double percentage = Double.parseDouble(input.replace(",", "."));
            //Convert Percentage number to calculate number
            double probability = percentage / 100;

            System.out.println("Please enter the number of spins you've already made:");

            //Loop until valid number of already made spins is gotten
            int spinsMade = InputValidator.getValidInteger(scanner);

            int spinsNeeded = Calculator.calculateSpins(probability);
            System.out.println("Number of spins needed: " + spinsNeeded);

            double probabilityNoSuccess = Calculator.calculateNoSuccessProbability(spinsMade, probability);

            String formattedProbability = Formatter.formatPercentage(probabilityNoSuccess);
            System.out.println("Probability of not getting " + percentage + "% chance in " + spinsMade + " spins: " + formattedProbability);
        }
        scanner.close();
    }
}