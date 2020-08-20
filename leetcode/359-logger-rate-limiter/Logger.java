import java.util.HashMap;
import java.util.Map;

public class Logger {
    private Map<String, Integer> previousMessages = new HashMap<>();

    /** Initialize your data structure here. */
    public Logger() {

    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (
                !previousMessages.containsKey(message) ||
                        previousMessages.containsKey(message) && (timestamp - previousMessages.get(message) >= 10)
                ) {
            previousMessages.put(message, timestamp);
            return true;
        }

        return false;
    }
}
