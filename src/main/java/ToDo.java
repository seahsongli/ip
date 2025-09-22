/**
 * Represents a simple to-do task without any specific time constraints.
 * Extends the base Task class to provide basic task functionality.
 */
public class ToDo extends Task {
    private static final String TASK_TYPE = "T";

    /**
     * Constructs a new ToDo task with the given description.
     * 
     * @param description the task description (cannot be null or empty)
     * @throws IllegalArgumentException if description is null or empty
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Returns the task type identifier for ToDo tasks.
     * 
     * @return "T" for ToDo
     */
    @Override
    public String getTaskType() {
        return TASK_TYPE;
    }
}