/**
 * Monty is a personal task management chatbot that helps users manage their tasks.
 * It supports adding, listing, marking, deleting, and finding tasks.
 * Tasks can be of three types: ToDo, Deadline, or Event.
 */
public class Monty {
    private Storage storage;
    private TaskList tasks;
    private UI ui;

    /**
     * Constructs a new Monty chatbot instance.
     * 
     * @param filePath the path to the file where tasks are stored
     */
    public Monty(String filePath) {
        ui = new UI();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (MontyException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * Runs the main chatbot loop, processing user commands until exit.
     * Displays welcome message and handles all user interactions.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (MontyException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * Main entry point for the Monty chatbot application.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        new Monty("data/tasks.txt").run();
    }
}
