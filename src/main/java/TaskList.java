import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages a collection of tasks and provides operations for task manipulation.
 * Handles task persistence through the Storage component.
 */
public class TaskList {
    private final List<Task> tasks;
    private final Storage storage;

    /**
     * Constructs an empty TaskList with default storage.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
        this.storage = new Storage();
    }

    /**
     * Constructs an empty TaskList with the specified storage component.
     * 
     * @param storage the storage component for task persistence
     */
    public TaskList(Storage storage) {
        this.tasks = new ArrayList<>();
        this.storage = storage;
    }

    /**
     * Constructs a TaskList with initial tasks and default storage.
     * 
     * @param initialTasks the initial list of tasks to populate the task list
     */
    public TaskList(List<Task> initialTasks) {
        this.tasks = new ArrayList<>(initialTasks);
        this.storage = new Storage();
    }

    /**
     * Retrieves a task at the specified index.
     * 
     * @param index the 0-based index of the task to retrieve
     * @return the task at the specified index
     * @throws MontyException if the index is out of bounds
     */
    public Task getTask(int index) throws MontyException {
        if (index < 0 || index >= tasks.size()) {
            throw new MontyException("OOPS!!! Task number " + (index + 1) + " does not exist. Please check your task list.");
        }
        return tasks.get(index);
    }

    /**
     * Returns the number of tasks in the task list.
     * 
     * @return the number of tasks
     */
    public int getSize() {
        return tasks.size();
    }

    /**
     * Checks if the task list is empty.
     * 
     * @return true if the task list is empty, false otherwise
     */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    /**
     * Returns a copy of all tasks in the task list.
     * 
     * @return a new list containing all tasks
     */
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    /**
     * Marks a task as not done and saves to storage.
     * 
     * @param index the 1-based index of the task to mark as not done
     * @return the task that was marked as not done
     * @throws MontyException if the index is out of bounds
     */
    public Task markTaskNotDone(int index) throws MontyException {
        Task task = getTask(index - 1);
        task.markNotDone();
        saveTasks();
        return task;
    }

    /**
     * Loads tasks from storage and replaces the current task list.
     */
    public void loadTasks() {
        List<Task> loadedTasks = storage.loadTasks();
        tasks.clear();
        tasks.addAll(loadedTasks);
    }

    /**
     * Saves the current task list to storage.
     * Errors are logged to stderr but do not propagate.
     */
    private void saveTasks() {
        try {
            storage.saveTasks(tasks);
        } catch (IOException e) {
            System.err.println("Error saving tasks: " + e.getMessage());
        }
    }

    /**
     * Adds a task to the task list and saves to storage.
     * 
     * @param task the task to add (cannot be null)
     * @throws IllegalArgumentException if task is null
     */
    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        tasks.add(task);
        saveTasks();
    }

    /**
     * Marks a task as done and saves to storage.
     * 
     * @param index the 1-based index of the task to mark as done
     * @return the task that was marked as done
     * @throws MontyException if the index is out of bounds
     */
    public Task markTaskDone(int index) throws MontyException {
        Task task = getTask(index - 1);
        task.markDone();
        saveTasks();
        return task;
    }

    /**
     * Deletes a task from the task list and saves to storage.
     * 
     * @param index the 1-based index of the task to delete
     * @return the task that was deleted
     * @throws MontyException if the index is out of bounds
     */
    public Task deleteTask(int index) throws MontyException {
        Task task = getTask(index - 1);
        tasks.remove(index - 1);
        saveTasks();
        return task;
    }

    /**
     * Finds tasks that contain the given keyword in their description.
     * The search is case-insensitive.
     * 
     * @param keyword the keyword to search for
     * @return a new TaskList containing matching tasks
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
     * Helper method to add tasks directly without saving to storage.
     * Used internally by findTasks method to avoid unnecessary persistence.
     * 
     * @param task the task to add (null tasks are ignored)
     */
    private void addTaskDirectly(Task task) {
        if (task != null) {
            tasks.add(task);
        }
    }

}
