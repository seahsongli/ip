/**
 * Abstract base class for all command types in the Monty chatbot.
 * Implements the Command pattern to encapsulate user actions as objects.
 */
public abstract class Command {
    /**
     * Executes this command with the given task list, UI, and storage components.
     * 
     * @param tasks the task list to operate on
     * @param ui the user interface for displaying messages
     * @param storage the storage component for persistence
     * @throws MontyException if the command execution fails
     */
    public abstract void execute(TaskList tasks, UI ui, Storage storage) throws MontyException;

    /**
     * Returns whether this command should cause the application to exit.
     * 
     * @return true if this is an exit command, false otherwise
     */
    public boolean isExit() {
        return false;
    }
}
