/**
 * DisplayManager.java
 * SDC230L - Project Phase 3: Arrays and Lists
 * Author: Patrick Gonzalez
 *
 * Handles all message display output for the calculator application.
 * Provides reusable methods for printing titles, menus, and messages.
 */
public class DisplayManager {

    /** Prints the title header - Project Week 3, title, and author name. */
    public void printTitle() {
        System.out.println("============================================================");
        System.out.println("  Project Week 3 | Arrays and Lists Calculator");
        System.out.println("  Author: Patrick Gonzalez");
        System.out.println("  Course: SDC230L");
        System.out.println("============================================================");
    }

    /** Prints welcome message with basic instructions. */
    public void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the Memory Calculator!");
        System.out.println("This application allows you to store and manipulate");
        System.out.println("numeric values in memory.");
        System.out.println();
        System.out.println("You can store a single value in memory, or manage a");
        System.out.println("collection of up to 10 integer values.");
        System.out.println("Use the menu below to get started.");
        System.out.println();
    }

    /** Prints the main menu. */
    public void printMainMenu() {
        System.out.println("------------------------------------------------------------");
        System.out.println("                        MAIN MENU                          ");
        System.out.println("------------------------------------------------------------");
        System.out.println("  1. Single Value Memory");
        System.out.println("  2. Integer Collection Memory");
        System.out.println("  3. Quit");
        System.out.println("------------------------------------------------------------");
        System.out.print("Enter your choice: ");
    }

    /**
     * Prints the single-value memory sub-menu.
     * @param hasValue true if a value is currently stored
     * @param value    the value currently stored
     */
    public void printSingleMemoryMenu(boolean hasValue, double value) {
        System.out.println();
        System.out.println("--- Single Value Memory ---");
        if (hasValue) {
            System.out.println("  Current Memory Value: " + value);
        } else {
            System.out.println("  Current Memory Value: [empty]");
        }
        System.out.println("  1. Store a value");
        System.out.println("  2. Retrieve the value");
        System.out.println("  3. Clear the value");
        System.out.println("  4. Replace the value");
        System.out.println("  5. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    /**
     * Prints the collection memory sub-menu.
     * @param count current number of values stored
     */
    public void printCollectionMenu(int count) {
        System.out.println();
        System.out.println("--- Integer Collection Memory (Max: 10) ---");
        System.out.println("  Values stored: " + count + "/10");
        System.out.println("  1. Add value(s) to collection");
        System.out.println("  2. Display all values");
        System.out.println("  3. Display count of values");
        System.out.println("  4. Remove a value");
        System.out.println("  5. Get sum of all values");
        System.out.println("  6. Get average of all values");
        System.out.println("  7. Get difference of first and last values");
        System.out.println("  8. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    /** Prints a general informational message. */
    public void printMessage(String message) {
        System.out.println("  " + message);
    }

    /** Prints an error/warning message. */
    public void printError(String message) {
        System.out.println("  [!] " + message);
    }

    /** Prints the closing thank-you message. */
    public void printClosing() {
        System.out.println();
        System.out.println("============================================================");
        System.out.println("  Thank you for using the Memory Calculator!");
        System.out.println("  Goodbye, Patrick Gonzalez!");
        System.out.println("============================================================");
    }
}
