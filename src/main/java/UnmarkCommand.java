public class UnmarkCommand extends Command {
    private final int taskIndex;

    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList tasks, UI ui) {
        Task task = tasks.markTaskNotDone(taskIndex);
        ui.showTaskMarkedNotDone(task);
    }
}
