/**
 * Represents an event task with a specific start and end time.
 * Extends the base Task class to add event-specific functionality.
 */
public class Event extends Task {
    private static final String TASK_TYPE = "E";
    
    private final String from;
    private final String to;

    /**
     * Constructs a new Event task with the given description, start time, and end time.
     * 
     * @param description the task description (cannot be null or empty)
     * @param from the event start time (cannot be null or empty)
     * @param to the event end time (cannot be null or empty)
     * @throws IllegalArgumentException if any parameter is null or empty
     */
    public Event(String description, String from, String to) {
        super(description);
        if (from == null || from.trim().isEmpty()) {
            throw new IllegalArgumentException("Event start time cannot be null or empty");
        }
        if (to == null || to.trim().isEmpty()) {
            throw new IllegalArgumentException("Event end time cannot be null or empty");
        }
        this.from = from.trim();
        this.to = to.trim();
    }

    /**
     * Returns the event start time.
     * 
     * @return the start time string
     */
    public String getFrom() {
        return from;
    }

    /**
     * Returns the event end time.
     * 
     * @return the end time string
     */
    public String getTo() {
        return to;
    }

    /**
     * Returns the task type identifier for Event tasks.
     * 
     * @return "E" for Event
     */
    @Override
    public String getTaskType() {
        return TASK_TYPE;
    }

    /**
     * Returns a string representation of this event task.
     * 
     * @return formatted string showing task type, status, description, and time range
     */
    @Override
    public String toString() {
        return "[" + getTaskType() + "]" + getStatusIcon() + " " + getDescription() + " (from: " + from + " to: " + to + ")";
    }
}