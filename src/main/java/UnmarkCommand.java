/**
 * Command to mark a task as not completed.
 */
public class UnmarkCommand extends Command {
    private final int taskIndex;

    /**
     * Constructs an UnmarkCommand with the index of the task to mark as not done.
     * 
     * @param taskIndex the 1-based index of the task to mark as not done
     */
    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Executes the unmark command by marking the task as not done and showing confirmation.
     * 
     * @param tasks the task list containing the task to unmark
     * @param ui the user interface for displaying confirmation
     * @param storage the storage component (not used in this command)
     * @throws MontyException if the task unmarking fails or task index is invalid
     */
    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws MontyException {
        Task task = tasks.markTaskNotDone(taskIndex);
        ui.showTaskMarkedNotDone(task);
    }
}
