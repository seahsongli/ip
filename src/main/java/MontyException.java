/**
 * Custom exception class for Monty chatbot operations.
 * Used to handle application-specific errors and provide meaningful error messages to users.
 */
public class MontyException extends Exception {
    /**
     * Constructs a new MontyException with the specified detail message.
     * 
     * @param message the detail message explaining what went wrong
     */
    public MontyException(String message) {
        super(message);
    }
}
