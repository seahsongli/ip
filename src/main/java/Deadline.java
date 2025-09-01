
public class Deadline extends Task {
    private static final String TASK_TYPE = "D";
    
    private final String by;

    public Deadline(String description, String by) {
        super(description);
        if (by == null || by.trim().isEmpty()) {
            throw new IllegalArgumentException("Deadline cannot be null or empty");
        }
        this.by = by.trim();
    }

    public String getBy() {
        return by;
    }

    @Override
    public String getTaskType() {
        return TASK_TYPE;
    }

    @Override
    public String toString() {
        return "[" + getTaskType() + "]" + getStatusIcon() + " " + getDescription() + " (by: " + by + ")";
    }
}