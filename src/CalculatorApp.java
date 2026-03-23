/**
 * CalculatorApp.java
 *
 * SDC230L - Project Phase 3: Arrays and Lists
 * Author: Patrick Gonzalez
 *
 * Main application class for the Memory Calculator.
 * This class ties together all components (DisplayManager, InputManager,
 * SingleMemory, CollectionMemory) to deliver the full Phase 3 functionality.
 *
 * Features:
 *   - Single value memory: store, retrieve, clear, replace
 *   - Collection memory: add up to 10 integers, display all, count,
 *     remove, sum, average, difference of first and last
 *   - Continues until the user selects Quit
 */
public class CalculatorApp {

    /**
     * Main entry point for the Memory Calculator application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        // Initialize all components (modular design)
        DisplayManager display = new DisplayManager();
        InputManager input = new InputManager();
        SingleMemory singleMem = new SingleMemory();
        CollectionMemory collectionMem = new CollectionMemory();

        // ----------------------------------------------------------
        // STEP 1: Print the title line
        // ----------------------------------------------------------
        display.printTitle();

        // ----------------------------------------------------------
        // STEP 2: Print the welcome/instructions message
        // ----------------------------------------------------------
        display.printWelcome();

        // ----------------------------------------------------------
        // STEP 3: Main loop - continue until user selects Quit
        // ----------------------------------------------------------
        boolean running = true;
        while (running) {

            display.printMainMenu();
            int mainChoice = input.getMenuChoice();

            switch (mainChoice) {

                // ---- Single Value Memory ----
                case 1:
                    boolean inSingleMenu = true;
                    while (inSingleMenu) {
                        display.printSingleMemoryMenu(singleMem.hasValue(), singleMem.getValue());
                        int singleChoice = input.getMenuChoice();

                        switch (singleChoice) {
                            case 1: // Store
                                double storeVal = input.getDouble("Enter a numeric value to store: ");
                                singleMem.store(storeVal);
                                break;
                            case 2: // Retrieve
                                singleMem.retrieve();
                                break;
                            case 3: // Clear
                                singleMem.clear();
                                break;
                            case 4: // Replace
                                if (!singleMem.hasValue()) {
                                    display.printError("No value in memory. Storing as new value instead.");
                                }
                                double replaceVal = input.getDouble("Enter replacement value: ");
                                singleMem.store(replaceVal);
                                break;
                            case 5: // Back
                                inSingleMenu = false;
                                break;
                            default:
                                display.printError("Invalid choice. Please enter 1-5.");
                        }
                    }
                    break;

                // ---- Integer Collection Memory ----
                case 2:
                    boolean inCollectionMenu = true;
                    while (inCollectionMenu) {
                        display.printCollectionMenu(collectionMem.getCount());
                        int colChoice = input.getMenuChoice();

                        switch (colChoice) {
                            case 1: // Add value(s)
                                if (collectionMem.isFull()) {
                                    display.printError("Collection is full (10/10). Remove a value before adding.");
                                } else {
                                    int addCount = input.getInt("How many values would you like to add? (up to "
                                            + collectionMem.remainingCapacity() + " more): ");
                                    if (addCount <= 0) {
                                        display.printError("Please enter a positive number.");
                                    } else {
                                        if (addCount > collectionMem.remainingCapacity()) {
                                            display.printError("You can only add " + collectionMem.remainingCapacity()
                                                    + " more value(s). Adjusting to that amount.");
                                            addCount = collectionMem.remainingCapacity();
                                        }
                                        for (int i = 0; i < addCount; i++) {
                                            if (collectionMem.isFull()) {
                                                display.printError("Collection is now full. Stopping early.");
                                                break;
                                            }
                                            int val = input.getInt("Enter integer #" + (i + 1) + ": ");
                                            collectionMem.addValue(val);
                                        }
                                    }
                                }
                                break;
                            case 2: // Display all
                                collectionMem.displayAll();
                                break;
                            case 3: // Display count
                                collectionMem.displayCount();
                                break;
                            case 4: // Remove a value
                                if (collectionMem.isEmpty()) {
                                    display.printError("Collection is empty. Nothing to remove.");
                                } else {
                                    collectionMem.displayAll();
                                    int removeIdx = input.getInt("Enter the index of the value to remove: ");
                                    collectionMem.removeByIndex(removeIdx);
                                }
                                break;
                            case 5: // Sum
                                collectionMem.displaySum();
                                break;
                            case 6: // Average
                                collectionMem.displayAverage();
                                break;
                            case 7: // Difference
                                collectionMem.displayDifference();
                                break;
                            case 8: // Back
                                inCollectionMenu = false;
                                break;
                            default:
                                display.printError("Invalid choice. Please enter 1-8.");
                        }
                    }
                    break;

                // ---- Quit ----
                case 3:
                    running = false;
                    break;

                default:
                    display.printError("Invalid choice. Please enter 1, 2, or 3.");
            }
        }

        // ----------------------------------------------------------
        // STEP 4: Print closing message
        // ----------------------------------------------------------
        display.printClosing();

        // Close scanner resource
        input.close();
    }
}
