import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Handles the persistence of tasks to and from the file system.
 * Provides methods to load tasks from a file and save tasks to a file.
 * Supports automatic directory creation and error handling for corrupted data.
 */
public class Storage {
    private static final String DATA_DIR = "data";
    private static final String DATA_FILE = "duke.txt";
    private final String filePath;

    /**
     * Constructs a Storage instance with the default file path.
     * The default path is "data/duke.txt".
     */
    public Storage() {
        this.filePath = DATA_DIR + File.separator + DATA_FILE;
    }

    /**
     * Constructs a Storage instance with the specified file path.
     * 
     * @param filePath the path to the file where tasks are stored
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Creates the data directory if it doesn't exist.
     * 
     * @throws IOException if the directory creation fails
     */
    private void createDataDirectoryIfNeeded() throws IOException {
        Path dataDirPath = Paths.get(DATA_DIR);
        if (!Files.exists(dataDirPath)) {
            Files.createDirectories(dataDirPath);
        }
    }

    /**
     * Loads tasks from the data file.
     * 
     * @return a list of tasks loaded from the file
     * @throws MontyException if there is an error loading tasks
     */
    public List<Task> load() throws MontyException {
        return loadTasks();
    }

    /**
     * Loads tasks from the data file.
     * Returns empty list if file doesn't exist or is corrupted.
     * 
     * @return a list of tasks loaded from the file (empty if file doesn't exist)
     */
    public List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        File file = new File(filePath);
        
        if (!file.exists()) {
            return tasks; // Return empty list if file doesn't exist
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    try {
                        Task task = parseTaskFromLine(line);
                        if (task != null) {
                            tasks.add(task);
                        }
                    } catch (Exception e) {
                        // Skip corrupted lines, continue loading other tasks
                        System.err.println("Warning: Skipping corrupted line: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading data file: " + e.getMessage());
        }

        return tasks;
    }

    /**
     * Saves tasks to the data file.
     * 
     * @param tasks the list of tasks to save
     * @throws IOException if there is an error writing to the file
     */
    public void saveTasks(List<Task> tasks) throws IOException {
        createDataDirectoryIfNeeded();
        
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Task task : tasks) {
                writer.write(taskToFileString(task) + System.lineSeparator());
            }
        }
    }

    /**
     * Parses a task from a file line.
     * Expected formats:
     * - ToDo: T | 1 | read book
     * - Deadline: D | 0 | return book | June 6th
     * - Event: E | 0 | project meeting | Aug 6th 2pm | 4pm
     * 
     * @param line the line from the file to parse
     * @return the parsed task
     * @throws IllegalArgumentException if the line format is invalid
     */
    private Task parseTaskFromLine(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length < 3) {
            throw new IllegalArgumentException("Invalid task format: " + line);
        }

        String taskType = parts[0].trim();
        int isDone = Integer.parseInt(parts[1].trim());
        String description = parts[2].trim();

        Task task = switch (taskType) {
            case "T" -> new ToDo(description);
            case "D" -> {
                if (parts.length < 4) {
                    throw new IllegalArgumentException("Deadline task missing 'by' parameter: " + line);
                }
                yield new Deadline(description, parts[3].trim());
            }
            case "E" -> {
                if (parts.length < 5) {
                    throw new IllegalArgumentException("Event task missing 'from' or 'to' parameter: " + line);
                }
                yield new Event(description, parts[3].trim(), parts[4].trim());
            }
            default -> throw new IllegalArgumentException("Unknown task type: " + taskType);
        };

        // Set the done status
        if (isDone == 1) {
            task.markDone();
        }

        return task;
    }

    /**
     * Converts a task to file string format.
     * Output formats:
     * - ToDo: T | 1 | read book
     * - Deadline: D | 0 | return book | June 6th
     * - Event: E | 0 | project meeting | Aug 6th 2pm | 4pm
     * 
     * @param task the task to convert to string format
     * @return the formatted string representation of the task
     */
    private String taskToFileString(Task task) {
        StringBuilder sb = new StringBuilder();
        sb.append(task.getTaskType()).append(" | ");
        sb.append(task.isDone() ? "1" : "0").append(" | ");
        sb.append(task.getDescription());

        if (task instanceof Deadline deadline) {
            sb.append(" | ").append(deadline.getBy());
        } else if (task instanceof Event event) {
            sb.append(" | ").append(event.getFrom()).append(" | ").append(event.getTo());
        }

        return sb.toString();
    }
}
