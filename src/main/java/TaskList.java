import java.util.ArrayList;
import java.util.List;

public class TaskList {

    
    private final List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        tasks.add(task);
    }

    public Task getTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            throw new IndexOutOfBoundsException("OOPS!!! Task number " + (index + 1) + " does not exist. Please check your task list.");
        }
        return tasks.get(index);
    }

    public int getSize() {
        return tasks.size();
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public Task markTaskDone(int index) {
        Task task = getTask(index - 1);
        task.markDone();
        return task;
    }

    public Task markTaskNotDone(int index) {
        Task task = getTask(index - 1);
        task.markNotDone();
        return task;
    }
}
