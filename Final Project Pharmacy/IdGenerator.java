import java.util.HashMap;
import java.util.Map;

public class IdGenerator {
    // Map to keep track of counters for different entity types
    private static Map<String, Integer> counters = new HashMap<>();

    /**
     * Generates a unique ID for a given entity type.
     * @param entityType The type of entity (e.g., "Product", "Supplier", "Transaction").
     * @return The generated unique ID as a string with leading zeros.
     */
    public static String generateID(String entityType) {
        // Initialize counter for the entity type if not already present
        counters.putIfAbsent(entityType, 0);

        // Increment the counter
        int nextID = counters.get(entityType) + 1;
        counters.put(entityType, nextID);

        // Return the ID formatted with leading zeros (e.g., 0001, 0002)
        return String.format("%04d", nextID);
    }

    /**
     * Resets the counter for a specific entity type (optional).
     * @param entityType The type of entity to reset the counter for.
     */
    public static void resetCounter(String entityType) {
        counters.put(entityType, 0);
    }

    /**
     * Resets all counters (optional).
     */
    public static void resetAllCounters() {
        counters.clear();
    }
}

