
public abstract class Task {
    private static final String DONE_ICON = "[X]";
    private static final String NOT_DONE_ICON = "[ ]";
    
    private final String description;
    private boolean isDone;

    public Task(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be null or empty");
        }
        this.description = description.trim();
        this.isDone = false;
    }

    public void markDone() {
        this.isDone = true;
    }

    public void markNotDone() {
        this.isDone = false;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public String getDescription() {
        return this.description;
    }

    public abstract String getTaskType();

    protected String getStatusIcon() {
        return isDone ? DONE_ICON : NOT_DONE_ICON;
    }

    @Override
    public String toString() {
        return "[" + getTaskType() + "]" + getStatusIcon() + " " + description;
    }
}