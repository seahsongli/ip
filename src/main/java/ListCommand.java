/**
 * Command to display all tasks in the task list.
 */
public class ListCommand extends Command {
    /**
     * Executes the list command by displaying all tasks in the task list.
     * 
     * @param tasks the task list to display
     * @param ui the user interface for displaying the task list
     * @param storage the storage component (not used in this command)
     * @throws MontyException if there is an error displaying the task list
     */
    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws MontyException {
        ui.showTaskList(tasks);
    }
}
