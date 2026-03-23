/**
 * CalculatorApp.java
 *
 * SDC230L - Project Phase 3: Arrays and Lists
 * Author: Patrick Gonzalez
 *
 * Main application class for the Memory Calculator.
 * Ties together DisplayManager, InputManager, SingleMemory, CollectionMemory.
 */
public class CalculatorApp {

    public static void main(String[] args) {

        DisplayManager display = new DisplayManager();
        InputManager input = new InputManager();
        SingleMemory singleMem = new SingleMemory();
        CollectionMemory collectionMem = new CollectionMemory();

        // STEP 1: Print title (SCREENSHOT REQUIRED)
        display.printTitle();

        // STEP 2: Print welcome message (SCREENSHOT REQUIRED)
        display.printWelcome();

        // STEP 3: Main loop - continue until user quits
        boolean running = true;
        while (running) {
            display.printMainMenu();
            int mainChoice = input.getMenuChoice();

            switch (mainChoice) {
                case 1: // Single Value Memory
                    boolean inSingleMenu = true;
                    while (inSingleMenu) {
                        display.printSingleMemoryMenu(singleMem.hasValue(), singleMem.getValue());
                        int singleChoice = input.getMenuChoice();
                        switch (singleChoice) {
                            case 1:
                                double storeVal = input.getDouble("Enter a numeric value to store: ");
                                singleMem.store(storeVal);
                                break;
                            case 2:
                                singleMem.retrieve();
                                break;
                            case 3:
                                singleMem.clear();
                                break;
                            case 4:
                                if (!singleMem.hasValue()) {
                                    display.printError("No value in memory. Storing as new value instead.");
                                }
                                double replaceVal = input.getDouble("Enter replacement value: ");
                                singleMem.store(replaceVal);
                                break;
                            case 5:
                                inSingleMenu = false;
                                break;
                            default:
                                display.printError("Invalid choice. Please enter 1-5.");
                        }
                    }
                    break;

                case 2: // Integer Collection Memory
                    boolean inCollectionMenu = true;
                    while (inCollectionMenu) {
                        display.printCollectionMenu(collectionMem.getCount());
                        int colChoice = input.getMenuChoice();
                        switch (colChoice) {
                            case 1:
                                if (collectionMem.isFull()) {
                                    display.printError("Collection is full (10/10). Remove a value first.");
                                } else {
                                    int addCount = input.getInt("How many values to add? (up to "
                                            + collectionMem.remainingCapacity() + " more): ");
                                    if (addCount <= 0) {
                                        display.printError("Please enter a positive number.");
                                    } else {
                                        if (addCount > collectionMem.remainingCapacity()) {
                                            addCount = collectionMem.remainingCapacity();
                                            display.printError("Adjusting to max: " + addCount);
                                        }
                                        for (int i = 0; i < addCount; i++) {
                                            if (collectionMem.isFull()) break;
                                            int val = input.getInt("Enter integer #" + (i + 1) + ": ");
                                            collectionMem.addValue(val);
                                        }
                                    }
                                }
                                break;
                            case 2: collectionMem.displayAll(); break;
                            case 3: collectionMem.displayCount(); break;
                            case 4:
                                if (collectionMem.isEmpty()) {
                                    display.printError("Collection is empty.");
                                } else {
                                    collectionMem.displayAll();
                                    int removeIdx = input.getInt("Enter the index to remove: ");
                                    collectionMem.removeByIndex(removeIdx);
                                }
                                break;
                            case 5: collectionMem.displaySum(); break;
                            case 6: collectionMem.displayAverage(); break;
                            case 7: collectionMem.displayDifference(); break;
                            case 8: inCollectionMenu = false; break;
                            default: display.printError("Invalid choice. Please enter 1-8.");
                        }
                    }
                    break;

                case 3: // Quit
                    running = false;
                    break;

                default:
                    display.printError("Invalid choice. Please enter 1, 2, or 3.");
            }
        }

        // STEP 4: Print closing message (SCREENSHOT REQUIRED)
        display.printClosing();
        input.close();
    }
                        }
