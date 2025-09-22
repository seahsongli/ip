/**
 * Command to add a new task to the task list.
 */
public class AddCommand extends Command {
    private final Task task;

    /**
     * Constructs an AddCommand with the task to be added.
     * 
     * @param task the task to add to the task list
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    /**
     * Executes the add command by adding the task to the task list and showing confirmation.
     * 
     * @param tasks the task list to add the task to
     * @param ui the user interface for displaying messages
     * @param storage the storage component (not used in this command)
     * @throws MontyException if the task addition fails
     */
    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws MontyException {
        tasks.addTask(task);
        ui.showTaskAdded(task, tasks.getSize());
    }
}
