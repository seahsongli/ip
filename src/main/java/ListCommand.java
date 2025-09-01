public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, UI ui) {
        ui.showTaskList(tasks);
    }
}
