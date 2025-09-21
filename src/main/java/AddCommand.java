public class AddCommand extends Command {
    private final Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws MontyException {
        tasks.addTask(task);
        ui.showTaskAdded(task, tasks.getSize());
    }
}
