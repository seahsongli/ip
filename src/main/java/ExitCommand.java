/**
 * Command to exit the Monty chatbot application.
 */
public class ExitCommand extends Command {
    /**
     * Executes the exit command by showing a goodbye message.
     * 
     * @param tasks the task list (not used in this command)
     * @param ui the user interface for displaying the goodbye message
     * @param storage the storage component (not used in this command)
     */
    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws MontyException {
        ui.showGoodbye();
    }

    /**
     * Returns true since this is an exit command.
     * 
     * @return true to indicate the application should exit
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
