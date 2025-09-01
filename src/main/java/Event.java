public class Event extends Task {
    private static final String TASK_TYPE = "E";
    
    private final String from;
    private final String to;

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

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String getTaskType() {
        return TASK_TYPE;
    }

    @Override
    public String toString() {
        return "[" + getTaskType() + "]" + getStatusIcon() + " " + getDescription() + " (from: " + from + " to: " + to + ")";
    }
}