public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws MontyException {
        ui.showTaskList(tasks);
    }
}
