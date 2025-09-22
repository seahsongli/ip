/**
 * Command to search for tasks containing a specific keyword.
 */
public class FindCommand extends Command {
    private final String keyword;

    /**
     * Constructs a FindCommand with the keyword to search for.
     * 
     * @param keyword the keyword to search for in task descriptions
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the find command by searching for tasks containing the keyword and displaying results.
     * 
     * @param tasks the task list to search through
     * @param ui the user interface for displaying search results
     * @param storage the storage component (not used in this command)
     * @throws MontyException if the search fails
     */
    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws MontyException {
        TaskList matchingTasks = tasks.findTasks(keyword);
        ui.showFoundTasks(matchingTasks, keyword);
    }
}
