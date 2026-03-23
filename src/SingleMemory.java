/**
 * SingleMemory.java
 * SDC230L - Project Phase 3: Arrays and Lists
 * Author: Patrick Gonzalez
 *
 * Handles the single-value memory functionality of the calculator.
 * Allows the user to store, retrieve, clear, and replace one numeric value.
 */
public class SingleMemory {

    /** The value currently stored in memory. */
    private double memoryValue;

    /** Whether a value is currently stored in memory. */
    private boolean hasValue;

    /** Constructor - initializes memory as empty. */
    public SingleMemory() {
        this.memoryValue = 0.0;
        this.hasValue = false;
    }

    /**
     * Stores a new value in memory.
     * @param value the numeric value to store
     */
    public void store(double value) {
        this.memoryValue = value;
        this.hasValue = true;
        System.out.println("  >> Value " + value + " stored in memory.");
    }

    /** Retrieves and displays the value currently stored in memory. */
    public void retrieve() {
        if (hasValue) {
            System.out.println("  >> Memory Value: " + memoryValue);
        } else {
            System.out.println("  [!] Memory is empty. No value to retrieve.");
        }
    }

    /** Clears the value from memory. */
    public void clear() {
        if (hasValue) {
            memoryValue = 0.0;
            hasValue = false;
            System.out.println("  >> Memory cleared.");
        } else {
            System.out.println("  [!] Memory is already empty.");
        }
    }

    /**
     * Returns whether memory currently holds a value.
     * @return true if a value is stored
     */
    public boolean hasValue() {
        return hasValue;
    }

    /**
     * Returns the value currently stored in memory.
     * @return the stored memory value
     */
    public double getValue() {
        return memoryValue;
    }
}
