package probabilitypackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class InputValidator {
    public static boolean isValidPercentage(String input) {
        input = input.replace(",", "."); //replaces commas with period
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static int getValidInteger(Scanner scanner){
        while(true){
            String input = scanner.nextLine();
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(input);
            if(matcher.matches()){
                return Integer.parseInt(input);
            }
            System.out.println("Invalid input. Please enter a valid number of spins");
        }
    }

}
