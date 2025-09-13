public class Parser {
    private static final String COMMAND_BYE = "bye";
    private static final String COMMAND_LIST = "list";
    private static final String COMMAND_MARK = "mark ";
    private static final String COMMAND_UNMARK = "unmark ";
    private static final String COMMAND_DELETE = "delete ";
    private static final String COMMAND_TODO = "todo ";
    private static final String COMMAND_DEADLINE = "deadline ";
    private static final String COMMAND_EVENT = "event ";
    
    private static final String DELIMITER_BY = "/by ";
    private static final String DELIMITER_FROM = "/from ";
    private static final String DELIMITER_TO = "/to ";

    public static Command parse(String fullCommand) {
        if (fullCommand == null || fullCommand.trim().isEmpty()) {
            throw new IllegalArgumentException("Command cannot be empty");
        }

        String trimmedCommand = fullCommand.trim();

        if (trimmedCommand.equals(COMMAND_BYE)) {
            return new ExitCommand();
        } else if (trimmedCommand.equals(COMMAND_LIST)) {
            return new ListCommand();
        } else if (trimmedCommand.startsWith(COMMAND_MARK)) {
            return parseMarkCommand(trimmedCommand);
        } else if (trimmedCommand.startsWith(COMMAND_UNMARK)) {
            return parseUnmarkCommand(trimmedCommand);
        } else if (trimmedCommand.startsWith(COMMAND_DELETE)) {
            return parseDeleteCommand(trimmedCommand);
        } else if (trimmedCommand.startsWith(COMMAND_TODO)) {
            return parseTodoCommand(trimmedCommand);
        } else if (trimmedCommand.startsWith(COMMAND_DEADLINE)) {
            return parseDeadlineCommand(trimmedCommand);
        } else if (trimmedCommand.startsWith(COMMAND_EVENT)) {
            return parseEventCommand(trimmedCommand);
        } else {
            throw new IllegalArgumentException("I'm sorry, but I don't know what that means :-(");
        }
    }

    private static Command parseMarkCommand(String command) {
        try {
            int taskIndex = Integer.parseInt(command.substring(COMMAND_MARK.length()).trim());
            return new MarkCommand(taskIndex);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("OOPS!!! Please provide a valid task number for the mark command.");
        }
    }

    private static Command parseUnmarkCommand(String command) {
        try {
            int taskIndex = Integer.parseInt(command.substring(COMMAND_UNMARK.length()).trim());
            return new UnmarkCommand(taskIndex);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("OOPS!!! Please provide a valid task number for the unmark command.");
        }
    }

    private static Command parseDeleteCommand(String command) {
        try {
            int taskIndex = Integer.parseInt(command.substring(COMMAND_DELETE.length()).trim());
            return new DeleteCommand(taskIndex);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("OOPS!!! Please provide a valid task number for the delete command.");
        }
    }

    private static Command parseTodoCommand(String command) {
        String description = command.substring(COMMAND_TODO.length()).trim();
        if (description.isEmpty()) {
            throw new IllegalArgumentException("OOPS!!! The description of a todo cannot be empty.");
        }
        return new AddCommand(new ToDo(description));
    }

    private static Command parseDeadlineCommand(String command) {
        String remaining = command.substring(COMMAND_DEADLINE.length()).trim();
        int byIndex = remaining.indexOf(DELIMITER_BY);
        
        if (byIndex == -1) {
            throw new IllegalArgumentException("OOPS!!! The deadline command requires a '/by' parameter. Please specify when the task is due.");
        }
        
        String description = remaining.substring(0, byIndex).trim();
        String by = remaining.substring(byIndex + DELIMITER_BY.length()).trim();
        
        if (description.isEmpty()) {
            throw new IllegalArgumentException("OOPS!!! The description of a deadline cannot be empty.");
        }
        if (by.isEmpty()) {
            throw new IllegalArgumentException("OOPS!!! The '/by' parameter for deadline cannot be empty. Please specify when the task is due.");
        }
        
        return new AddCommand(new Deadline(description, by));
    }

    private static Command parseEventCommand(String command) {
        String remaining = command.substring(COMMAND_EVENT.length()).trim();
        int fromIndex = remaining.indexOf(DELIMITER_FROM);
        int toIndex = remaining.indexOf(DELIMITER_TO);
        
        if (fromIndex == -1) {
            throw new IllegalArgumentException("OOPS!!! The event command requires a '/from' parameter. Please specify when the event starts.");
        }
        if (toIndex == -1) {
            throw new IllegalArgumentException("OOPS!!! The event command requires a '/to' parameter. Please specify when the event ends.");
        }
        if (fromIndex >= toIndex) {
            throw new IllegalArgumentException("OOPS!!! The '/from' parameter must come before the '/to' parameter in event command.");
        }
        
        String description = remaining.substring(0, fromIndex).trim();
        String from = remaining.substring(fromIndex + DELIMITER_FROM.length(), toIndex).trim();
        String to = remaining.substring(toIndex + DELIMITER_TO.length()).trim();
        
        if (description.isEmpty()) {
            throw new IllegalArgumentException("OOPS!!! The description of an event cannot be empty.");
        }
        if (from.isEmpty()) {
            throw new IllegalArgumentException("OOPS!!! The '/from' parameter for event cannot be empty. Please specify when the event starts.");
        }
        if (to.isEmpty()) {
            throw new IllegalArgumentException("OOPS!!! The '/to' parameter for event cannot be empty. Please specify when the event ends.");
        }
        
        return new AddCommand(new Event(description, from, to));
    }
}
