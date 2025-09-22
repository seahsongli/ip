
/**
 * Abstract base class for all task types in the Monty chatbot.
 * Provides common functionality for task management including marking tasks as done/not done,
 * getting task descriptions, and formatting task display.
 */
public abstract class Task {
    private static final String DONE_ICON = "[X]";
    private static final String NOT_DONE_ICON = "[ ]";
    
    private final String description;
    private boolean isDone;

    /**
     * Constructs a new Task with the given description.
     * 
     * @param description the task description (cannot be null or empty)
     * @throws IllegalArgumentException if description is null or empty
     */
    public Task(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be null or empty");
        }
        this.description = description.trim();
        this.isDone = false;
    }

    /**
     * Marks this task as completed.
     */
    public void markDone() {
        this.isDone = true;
    }

    /**
     * Marks this task as not completed.
     */
    public void markNotDone() {
        this.isDone = false;
    }

    /**
     * Returns whether this task is completed.
     * 
     * @return true if the task is done, false otherwise
     */
    public boolean isDone() {
        return this.isDone;
    }

    /**
     * Returns the description of this task.
     * 
     * @return the task description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns the task type identifier.
     * Must be implemented by concrete task classes.
     * 
     * @return the task type string (e.g., "T" for ToDo, "D" for Deadline, "E" for Event)
     */
    public abstract String getTaskType();

    /**
     * Returns the status icon for this task.
     * 
     * @return "[X]" if done, "[ ]" if not done
     */
    protected String getStatusIcon() {
        return isDone ? DONE_ICON : NOT_DONE_ICON;
    }

    /**
     * Returns a string representation of this task.
     * 
     * @return formatted string showing task type, status, and description
     */
    @Override
    public String toString() {
        return "[" + getTaskType() + "]" + getStatusIcon() + " " + description;
    }
}