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
        String[] tasks = new String[100];
        int taskCount = 0;
        while (true) {
            String input = sc.nextLine();
            if (input.equals("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println(" Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                break;
            }
            else if (input.equals("list")) {
                System.out.println("____________________________________________________________");
                for (int i = 0; i < taskCount; i++) {
                    System.out.println(" " + (i + 1) + ". " + tasks[i]);
                }
                System.out.println("____________________________________________________________");
            }
            else {
                // add task to array
                tasks[taskCount] = input;
                taskCount++;

                System.out.println("____________________________________________________________");
                System.out.println(" added: " + input);
                System.out.println("____________________________________________________________");
            }
        }
        sc.close();
    }
}
