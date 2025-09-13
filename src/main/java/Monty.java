public class Monty {
    private final UI ui;
    private final TaskList tasks;

    public Monty() {
        this.ui = new UI();
        this.tasks = new TaskList();
        // Load existing tasks from storage
        tasks.loadTasks();
    }

    public void run() {
        ui.showWelcome();
        
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command command = Parser.parse(fullCommand);
                command.execute(tasks, ui);
                isExit = command.isExit();
            } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                ui.showError(e.getMessage());
            } catch (Exception e) {
                ui.showError("An unexpected error occurred: " + e.getMessage());
            }
        }
        
        ui.close();
    }

    public static void main(String[] args) {
        new Monty().run();
    }
}
