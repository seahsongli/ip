import java.util.Scanner;

public class Monty {
    public static void main(String[] args) {
        String logo = " __  __             _          \n"
             + "|  \\/  | ___  _ __ | |_ _   _  \n"
             + "| |\\/| |/ _ \\| '_ \\| __| | | | \n"
             + "| |  | | (_) | | | | |_| |_| | \n"
             + "|_|  |_|\\___/|_| |_|\\__|\\__,_| \n";
        System.out.println("Hello from\n" + logo);

        String name = "Monty";
        System.out.println("Hello! I'm " + name);
        System.out.println("What can I do for you?");

        Scanner sc = new Scanner(System.in);
        Task[] tasks = new Task[100];
        int taskCount = 0;
        while (true) {
            String input = sc.nextLine();
            if (input.equals("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println(" Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                break;
            } else if (input.equals("list")) {
                System.out.println("____________________________________________________________");
                System.out.println(" Here are the tasks in your list:");
                for (int i = 0; i < taskCount; i++) {
                    System.out.println(" " + (i + 1) + "." + tasks[i]);
                }
                System.out.println("____________________________________________________________");
            } else if (input.startsWith("mark ")) {
                int index = Integer.parseInt(input.substring(5)) - 1;
                if (index >= 0 && index < taskCount) {
                    tasks[index].markDone();
                    System.out.println("____________________________________________________________");
                    System.out.println(" Nice! I've marked this task as done:");
                    System.out.println("   " + tasks[index]);
                    System.out.println("____________________________________________________________");
                }
            } else if (input.startsWith("unmark ")) {
                int index = Integer.parseInt(input.substring(7)) - 1;
                if (index >= 0 && index < taskCount) {
                    tasks[index].markNotDone();
                    System.out.println("____________________________________________________________");
                    System.out.println(" OK, I've marked this task as not done yet:");
                    System.out.println("   " + tasks[index]);
                    System.out.println("____________________________________________________________");
                }
            } else if (input.startsWith("todo ")) {
                String description = input.substring(5);
                tasks[taskCount] = new ToDo(description);
                taskCount++;
                System.out.println("____________________________________________________________");
                System.out.println(" Got it. I've added this task:");
                System.out.println("   " + tasks[taskCount - 1]);
                System.out.println(" Now you have " + taskCount + " tasks in the list.");
                System.out.println("____________________________________________________________");
            } else if (input.startsWith("deadline ")) {
                String remaining = input.substring(9);
                int byIndex = remaining.indexOf("/by ");
                if (byIndex != -1) {
                    String description = remaining.substring(0, byIndex).trim();
                    String by = remaining.substring(byIndex + 4).trim();
                    tasks[taskCount] = new Deadline(description, by);
                    taskCount++;
                    System.out.println("____________________________________________________________");
                    System.out.println(" Got it. I've added this task:");
                    System.out.println("   " + tasks[taskCount - 1]);
                    System.out.println(" Now you have " + taskCount + " tasks in the list.");
                    System.out.println("____________________________________________________________");
                }
            } else if (input.startsWith("event ")) {
                String remaining = input.substring(6);
                int fromIndex = remaining.indexOf("/from ");
                int toIndex = remaining.indexOf("/to ");
                if (fromIndex != -1 && toIndex != -1) {
                    String description = remaining.substring(0, fromIndex).trim();
                    String from = remaining.substring(fromIndex + 6, toIndex).trim();
                    String to = remaining.substring(toIndex + 4).trim();
                    tasks[taskCount] = new Event(description, from, to);
                    taskCount++;
                    System.out.println("____________________________________________________________");
                    System.out.println(" Got it. I've added this task:");
                    System.out.println("   " + tasks[taskCount - 1]);
                    System.out.println(" Now you have " + taskCount + " tasks in the list.");
                    System.out.println("____________________________________________________________");
                }
            } else {
                tasks[taskCount] = new ToDo(input);
                taskCount++;
                System.out.println("____________________________________________________________");
                System.out.println(" Got it. I've added this task:");
                System.out.println("   " + tasks[taskCount - 1]);
                System.out.println(" Now you have " + taskCount + " tasks in the list.");
                System.out.println("____________________________________________________________");
            }
        }
        sc.close();
    }
}
