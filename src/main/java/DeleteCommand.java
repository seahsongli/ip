/**
 * Command to delete a task from the task list.
 */
public class DeleteCommand extends Command {
    private final int taskIndex;

    /**
     * Constructs a DeleteCommand with the index of the task to delete.
     * 
     * @param taskIndex the 1-based index of the task to delete
     */
    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Executes the delete command by removing the task from the task list and showing confirmation.
     * 
     * @param tasks the task list to delete the task from
     * @param ui the user interface for displaying messages
     * @param storage the storage component (not used in this command)
     * @throws MontyException if the task deletion fails or task index is invalid
     */
    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws MontyException {
        Task task = tasks.deleteTask(taskIndex);
        ui.showTaskDeleted(task, tasks.getSize());
    }
}
