/**
 * Command to mark a task as completed.
 */
public class MarkCommand extends Command {
    private final int taskIndex;

    /**
     * Constructs a MarkCommand with the index of the task to mark as done.
     * 
     * @param taskIndex the 1-based index of the task to mark as done
     */
    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Executes the mark command by marking the task as done and showing confirmation.
     * 
     * @param tasks the task list containing the task to mark
     * @param ui the user interface for displaying confirmation
     * @param storage the storage component (not used in this command)
     * @throws MontyException if the task marking fails or task index is invalid
     */
    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws MontyException {
        Task task = tasks.markTaskDone(taskIndex);
        ui.showTaskMarkedDone(task);
    }
}
