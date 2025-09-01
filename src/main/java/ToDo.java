public class ToDo extends Task {
    private static final String TASK_TYPE = "T";

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String getTaskType() {
        return TASK_TYPE;
    }
}