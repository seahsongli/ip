public class MarkCommand extends Command {
    private final int taskIndex;

    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws MontyException {
        Task task = tasks.markTaskDone(taskIndex);
        ui.showTaskMarkedDone(task);
    }
}
