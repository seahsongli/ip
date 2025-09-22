
/**
 * Represents a deadline task with a specific due date/time.
 * Extends the base Task class to add deadline-specific functionality.
 */
public class Deadline extends Task {
    private static final String TASK_TYPE = "D";
    
    private final String by;

    /**
     * Constructs a new Deadline task with the given description and due date/time.
     * 
     * @param description the task description (cannot be null or empty)
     * @param by the deadline due date/time (cannot be null or empty)
     * @throws IllegalArgumentException if description or by is null or empty
     */
    public Deadline(String description, String by) {
        super(description);
        if (by == null || by.trim().isEmpty()) {
            throw new IllegalArgumentException("Deadline cannot be null or empty");
        }
        this.by = by.trim();
    }

    /**
     * Returns the deadline due date/time.
     * 
     * @return the deadline string
     */
    public String getBy() {
        return by;
    }

    /**
     * Returns the task type identifier for Deadline tasks.
     * 
     * @return "D" for Deadline
     */
    @Override
    public String getTaskType() {
        return TASK_TYPE;
    }

    /**
     * Returns a string representation of this deadline task.
     * 
     * @return formatted string showing task type, status, description, and deadline
     */
    @Override
    public String toString() {
        return "[" + getTaskType() + "]" + getStatusIcon() + " " + getDescription() + " (by: " + by + ")";
    }
}