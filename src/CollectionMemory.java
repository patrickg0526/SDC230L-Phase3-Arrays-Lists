import java.util.ArrayList;

/**
 * CollectionMemory.java
 * SDC230L - Project Phase 3: Arrays and Lists
 * Author: Patrick Gonzalez
 *
 * Manages a collection of up to 10 integer values in memory using ArrayList.
 * Supports add, display, remove, sum, average, and first/last difference operations.
 */
public class CollectionMemory {

    /** Maximum number of integers allowed in the collection. */
    private static final int MAX_SIZE = 10;

    /** The ArrayList storing the integer values. */
    private ArrayList<Integer> collection;

    /** Constructor - initializes an empty collection. */
    public CollectionMemory() {
        this.collection = new ArrayList<>();
    }

    /** @return the current number of values stored */
    public int getCount() { return collection.size(); }

    /** @return true if collection is at max capacity */
    public boolean isFull() { return collection.size() >= MAX_SIZE; }

    /** @return true if no values are stored */
    public boolean isEmpty() { return collection.isEmpty(); }

    /** @return how many more values can be added */
    public int remainingCapacity() { return MAX_SIZE - collection.size(); }

    /**
     * Adds a single integer to the collection if not full.
     * @param value the integer to add
     * @return true if added, false if collection is full
     */
    public boolean addValue(int value) {
        if (isFull()) {
            System.out.println("  [!] Collection is full (max " + MAX_SIZE + "). Cannot add more.");
            return false;
        }
        collection.add(value);
        System.out.println("  >> Value " + value + " added. Collection size: " + collection.size() + "/" + MAX_SIZE);
        return true;
    }

    /** Displays all values currently stored in the collection. */
    public void displayAll() {
        if (isEmpty()) { System.out.println("  [!] Collection is empty."); return; }
        System.out.println("  >> Values in collection:");
        for (int i = 0; i < collection.size(); i++) {
            System.out.println("     [" + i + "] " + collection.get(i));
        }
    }

    /** Displays the count of values stored. */
    public void displayCount() {
        System.out.println("  >> Number of values stored: " + collection.size() + "/" + MAX_SIZE);
    }

    /**
     * Removes a value from the collection by index.
     * @param index the index of the value to remove
     * @return true if removed, false if invalid index
     */
    public boolean removeByIndex(int index) {
        if (isEmpty()) { System.out.println("  [!] Collection is empty."); return false; }
        if (index < 0 || index >= collection.size()) {
            System.out.println("  [!] Invalid index. Must be 0 to " + (collection.size() - 1) + ".");
            return false;
        }
        int removed = collection.remove(index);
        System.out.println("  >> Value " + removed + " removed. Size: " + collection.size() + "/" + MAX_SIZE);
        return true;
    }

    /** Calculates and displays the sum of all values. */
    public void displaySum() {
        if (isEmpty()) { System.out.println("  [!] Collection is empty. Cannot compute sum."); return; }
        int sum = 0;
        for (int val : collection) sum += val;
        System.out.println("  >> Sum of all values: " + sum);
    }

    /** Calculates and displays the average of all values. */
    public void displayAverage() {
        if (isEmpty()) { System.out.println("  [!] Collection is empty. Cannot compute average."); return; }
        int sum = 0;
        for (int val : collection) sum += val;
        double avg = (double) sum / collection.size();
        System.out.printf("  >> Average of all values: %.2f%n", avg);
    }

    /** Calculates and displays the difference between the first and last values. */
    public void displayDifference() {
        if (isEmpty()) { System.out.println("  [!] Collection is empty."); return; }
        if (collection.size() == 1) { System.out.println("  [!] Need at least two values."); return; }
        int first = collection.get(0);
        int last = collection.get(collection.size() - 1);
        System.out.println("  >> First: " + first + " | Last: " + last);
        System.out.println("  >> Difference (first - last): " + (first - last));
    }
}
