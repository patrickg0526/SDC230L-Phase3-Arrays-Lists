import java.util.Scanner;

/**
 * InputManager.java
 * SDC230L - Project Phase 3: Arrays and Lists
 * Author: Patrick Gonzalez
 *
 * Handles all user input operations with validation and error handling.
 */
public class InputManager {

    /** Scanner used to read user input from the console. */
    private Scanner scanner;

    /** Constructor - initializes the Scanner for System.in. */
    public InputManager() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Reads a valid integer menu choice from the user.
     * @return the integer entered by the user
     */
    public int getMenuChoice() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("  [!] Invalid input. Please enter a number: ");
            }
        }
    }

    /**
     * Reads a valid double from the user.
     * @param prompt the message to display before reading
     * @return the double entered by the user
     */
    public double getDouble(String prompt) {
        while (true) {
            System.out.print("  " + prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  [!] Invalid input. Please enter a numeric value.");
            }
        }
    }

    /**
     * Reads a valid integer from the user.
     * @param prompt the message to display before reading
     * @return the integer entered by the user
     */
    public int getInt(String prompt) {
        while (true) {
            System.out.print("  " + prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  [!] Invalid input. Please enter a whole number.");
            }
        }
    }

    /** Closes the scanner when the application exits. */
    public void close() {
        scanner.close();
    }
}
