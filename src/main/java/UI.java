import java.util.Scanner;

public class UI {
    private static final String DIVIDER = "____________________________________________________________";
    
    private final Scanner scanner;

    public UI() {
        this.scanner = new Scanner(System.in);
    }

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

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showGoodbye() {
        showMessage("Bye. Hope to see you again soon!");
    }

    public void showMessage(String message) {
        System.out.println(DIVIDER);
        System.out.println(" " + message);
        System.out.println(DIVIDER);
    }

    public void showTaskAdded(Task task, int totalTasks) {
        System.out.println(DIVIDER);
        System.out.println(" Got it. I've added this task:");
        System.out.println("   " + task);
        System.out.println(" Now you have " + totalTasks + " tasks in the list.");
        System.out.println(DIVIDER);
    }

    public void showTaskList(TaskList tasks) {
        System.out.println(DIVIDER);
        if (tasks.isEmpty()) {
            System.out.println(" Your task list is empty.");
        } else {
            System.out.println(" Here are the tasks in your list:");
            for (int i = 0; i < tasks.getSize(); i++) {
                System.out.println(" " + (i + 1) + "." + tasks.getTask(i));
            }
        }
        System.out.println(DIVIDER);
    }

    public void showTaskMarkedDone(Task task) {
        System.out.println(DIVIDER);
        System.out.println(" Nice! I've marked this task as done:");
        System.out.println("   " + task);
        System.out.println(DIVIDER);
    }

    public void showTaskMarkedNotDone(Task task) {
        System.out.println(DIVIDER);
        System.out.println(" OK, I've marked this task as not done yet:");
        System.out.println("   " + task);
        System.out.println(DIVIDER);
    }

    public void showError(String error) {
        System.out.println(DIVIDER);
        System.out.println(" " + error);
        System.out.println(DIVIDER);
    }

 
    public void close() {
        scanner.close();
    }
}
