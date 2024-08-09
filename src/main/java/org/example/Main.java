package org.example;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add task");
            System.out.println("2. View all tasks");
            System.out.println("3. Update task");
            System.out.println("4. Delete task");
            System.out.println("5. Mark task as completed");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter task ID: ");
                    int taskId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline left-over
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter due date: ");
                    String dueDate = scanner.nextLine();
                    Task task = new Task(taskId, description, dueDate, false);
                    taskManager.addTask(task);
                    break;
                case 2:
                    taskManager.viewAllTasks();
                    break;
                case 3:
                    System.out.print("Enter task ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline left-over
                    System.out.print("Enter new description: ");
                    String newDescription = scanner.nextLine();
                    System.out.print("Enter new due date: ");
                    String newDueDate = scanner.nextLine();
                    taskManager.updateTask(updateId, newDescription, newDueDate);
                    break;
                case 4:
                    System.out.print("Enter task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    taskManager.deleteTask(deleteId);
                    break;
                case 5:
                    System.out.print("Enter task ID to mark as completed: ");
                    int completeId = scanner.nextInt();
                    taskManager.markTaskAsCompleted(completeId);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }

        }
        }
    }
