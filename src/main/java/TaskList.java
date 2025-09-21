import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final List<Task> tasks;
    private final Storage storage;

    public TaskList() {
        this.tasks = new ArrayList<>();
        this.storage = new Storage();
    }

    public TaskList(Storage storage) {
        this.tasks = new ArrayList<>();
        this.storage = storage;
    }

    public TaskList(List<Task> initialTasks) {
        this.tasks = new ArrayList<>(initialTasks);
        this.storage = new Storage();
    }

    public Task getTask(int index) throws MontyException {
        if (index < 0 || index >= tasks.size()) {
            throw new MontyException("OOPS!!! Task number " + (index + 1) + " does not exist. Please check your task list.");
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

    public Task markTaskNotDone(int index) throws MontyException {
        Task task = getTask(index - 1);
        task.markNotDone();
        saveTasks();
        return task;
    }

    /**
     * Loads tasks from storage
     */
    public void loadTasks() {
        List<Task> loadedTasks = storage.loadTasks();
        tasks.clear();
        tasks.addAll(loadedTasks);
    }

    /**
     * Saves tasks to storage
     */
    private void saveTasks() {
        try {
            storage.saveTasks(tasks);
        } catch (IOException e) {
            System.err.println("Error saving tasks: " + e.getMessage());
        }
    }

    /**
     * Adds a task and saves to storage
     */
    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        tasks.add(task);
        saveTasks();
    }

    /**
     * Marks a task as done and saves to storage
     */
    public Task markTaskDone(int index) throws MontyException {
        Task task = getTask(index - 1);
        task.markDone();
        saveTasks();
        return task;
    }

    /**
     * Deletes a task and saves to storage
     */
    public Task deleteTask(int index) throws MontyException {
        Task task = getTask(index - 1);
        tasks.remove(index - 1);
        saveTasks();
        return task;
    }

    /**
     * Finds tasks that contain the given keyword in their description
     */
    public TaskList findTasks(String keyword) {
        TaskList matchingTasks = new TaskList();
        String searchKeyword = keyword.toLowerCase();
        
        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(searchKeyword)) {
                matchingTasks.addTaskDirectly(task);
            }
        }
        
        return matchingTasks;
    }

    /**
     * Helper method to add tasks directly without saving to storage
     * Used internally by findTasks method
     */
    private void addTaskDirectly(Task task) {
        if (task != null) {
            tasks.add(task);
        }
    }

}
