import java.util.Scanner;

/**
 * Handles all user interface operations for the Monty chatbot.
 * Provides methods for displaying messages, reading user input, and formatting output.
 */
public class UI {
    private static final String DIVIDER = "____________________________________________________________";
    
    private final Scanner scanner;

    /**
     * Constructs a new UI instance with a Scanner for reading user input.
     */
    public UI() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the welcome message and Monty logo to the user.
     */
    public void showWelcome() {
        String logo = """
                 __  __             _          
                |  \\/  | ___  _ __ | |_ _   _  
                | |\\/| |/ _ \\| '_ \\| __| | | | 
                | |  | | (_) | | | | |_| |_| | 
                |_|  |_|\\___/|_| |_|\\__|\\__,_| 
                """;
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Monty");
        System.out.println("What can I do for you?");
    }

    /**
     * Reads a command from the user input.
     * 
     * @return the command entered by the user
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Displays a goodbye message to the user.
     */
    public void showGoodbye() {
        showMessage("Bye. Hope to see you again soon!");
    }

    /**
     * Displays a message with divider lines.
     * 
     * @param message the message to display
     */
    public void showMessage(String message) {
        System.out.println(DIVIDER);
        System.out.println(" " + message);
        System.out.println(DIVIDER);
    }

    /**
     * Displays a message confirming that a task has been added.
     * 
     * @param task the task that was added
     * @param totalTasks the total number of tasks in the list
     */
    public void showTaskAdded(Task task, int totalTasks) {
        System.out.println(DIVIDER);
        System.out.println(" Got it. I've added this task:");
        System.out.println("   " + task);
        System.out.println(" Now you have " + totalTasks + " tasks in the list.");
        System.out.println(DIVIDER);
    }

    /**
     * Displays all tasks in the task list.
     * 
     * @param tasks the task list to display
     */
    public void showTaskList(TaskList tasks) {
        System.out.println(DIVIDER);
        if (tasks.isEmpty()) {
            System.out.println(" Your task list is empty.");
        } else {
            System.out.println(" Here are the tasks in your list:");
            for (int i = 0; i < tasks.getSize(); i++) {
                try {
                    System.out.println(" " + (i + 1) + "." + tasks.getTask(i));
                } catch (MontyException e) {
                    System.out.println(" " + (i + 1) + ". [Error loading task: " + e.getMessage() + "]");
                }
            }
        }
        System.out.println(DIVIDER);
    }

    /**
     * Displays a message confirming that a task has been marked as done.
     * 
     * @param task the task that was marked as done
     */
    public void showTaskMarkedDone(Task task) {
        System.out.println(DIVIDER);
        System.out.println(" Nice! I've marked this task as done:");
        System.out.println("   " + task);
        System.out.println(DIVIDER);
    }

    /**
     * Displays a message confirming that a task has been marked as not done.
     * 
     * @param task the task that was marked as not done
     */
    public void showTaskMarkedNotDone(Task task) {
        System.out.println(DIVIDER);
        System.out.println(" OK, I've marked this task as not done yet:");
        System.out.println("   " + task);
        System.out.println(DIVIDER);
    }

    /**
     * Displays a message confirming that a task has been deleted.
     * 
     * @param task the task that was deleted
     * @param remainingTasks the number of tasks remaining in the list
     */
    public void showTaskDeleted(Task task, int remainingTasks) {
        System.out.println(DIVIDER);
        System.out.println(" Noted. I've removed this task:");
        System.out.println("   " + task);
        System.out.println(" Now you have " + remainingTasks + " tasks in the list.");
        System.out.println(DIVIDER);
    }

    /**
     * Displays an error message with divider lines.
     * 
     * @param error the error message to display
     */
    public void showError(String error) {
        System.out.println(DIVIDER);
        System.out.println(" " + error);
        System.out.println(DIVIDER);
    }

    /**
     * Displays a divider line.
     */
    public void showLine() {
        System.out.println(DIVIDER);
    }

    /**
     * Displays a message indicating that there was an error loading tasks from file.
     */
    public void showLoadingError() {
        showMessage("Error loading tasks from file. Starting with an empty task list.");
    }

    /**
     * Displays the results of a task search.
     * 
     * @param matchingTasks the list of tasks that match the search keyword
     * @param keyword the keyword that was searched for
     */
    public void showFoundTasks(TaskList matchingTasks, String keyword) {
        System.out.println(DIVIDER);
        if (matchingTasks.isEmpty()) {
            System.out.println(" No tasks found containing the keyword: \"" + keyword + "\"");
        } else {
            System.out.println(" Here are the matching tasks in your list:");
            for (int i = 0; i < matchingTasks.getSize(); i++) {
                try {
                    System.out.println(" " + (i + 1) + "." + matchingTasks.getTask(i));
                } catch (MontyException e) {
                    System.out.println(" " + (i + 1) + ". [Error loading task: " + e.getMessage() + "]");
                }
            }
        }
        System.out.println(DIVIDER);
    }

    /**
     * Closes the scanner and releases system resources.
     */
    public void close() {
        scanner.close();
    }
}
