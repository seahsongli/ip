# Monty User Guide

Monty is a personal task management chatbot that helps you manage your tasks efficiently. It supports three types of tasks: ToDo, Deadline, and Event, and provides commands to add, list, mark, delete, and find tasks.

## Quick Start

To start using Monty, run the application and you'll see a welcome message. You can then enter commands to manage your tasks. Type `bye` to exit the application.

## Adding Tasks

### Adding a ToDo Task

Add a simple task without any time constraints.

Example: `todo read book`

```
Got it. I've added this task:
  [T][ ] read book
Now you have 1 task in the list.
```

### Adding a Deadline Task

Add a task with a specific deadline.

Example: `deadline submit assignment /by 2024-12-31`

```
Got it. I've added this task:
  [D][ ] submit assignment (by: 2024-12-31)
Now you have 2 tasks in the list.
```

### Adding an Event Task

Add a task that represents an event with start and end times.

Example: `event team meeting /from 2pm /to 3pm`

```
Got it. I've added this task:
  [E][ ] team meeting (from: 2pm to: 3pm)
Now you have 3 tasks in the list.
```

## Listing Tasks

View all your tasks in the list.

Example: `list`

```
Here are the tasks in your list:
1.[T][ ] read book
2.[D][ ] submit assignment (by: 2024-12-31)
3.[E][ ] team meeting (from: 2pm to: 3pm)
```

## Marking Tasks

### Mark a Task as Done

Mark a task as completed by its number in the list.

Example: `mark 1`

```
Nice! I've marked this task as done:
  [T][X] read book
```

### Unmark a Task

Mark a completed task as not done.

Example: `unmark 1`

```
OK, I've marked this task as not done yet:
  [T][ ] read book
```

## Deleting Tasks

Remove a task from your list permanently.

Example: `delete 2`

```
Noted. I've removed this task:
  [D][ ] submit assignment (by: 2024-12-31)
Now you have 2 tasks in the list.
```

## Finding Tasks

Search for tasks that contain a specific keyword.

Example: `find meeting`

```
Here are the matching tasks in your list:
1.[E][ ] team meeting (from: 2pm to: 3pm)
```

## Exiting Monty

Exit the application when you're done.

Example: `bye`

```
Bye. Hope to see you again soon!
```