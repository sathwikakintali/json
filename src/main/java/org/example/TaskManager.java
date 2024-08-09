package org.example;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private ObjectMapper objectMapper;
    private File file;

    public TaskManager() {
        objectMapper = new ObjectMapper();
        file = new File("tasks.json");
        tasks = loadTasks();
    }

    public void addTask(Task task) {
        tasks.add(task);
        saveTasks();
    }

    public void viewAllTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void updateTask(int taskId, String description, String dueDate) {
        for (Task task : tasks) {
            if (task.getTaskId() == taskId) {
                task.setDescription(description);
                task.setDueDate(dueDate);
            }
        }
        saveTasks();
    }

    public void deleteTask(int taskId) {
        tasks.removeIf(task -> task.getTaskId() == taskId);
        saveTasks();
    }

    public void markTaskAsCompleted(int taskId) {
        for (Task task : tasks) {
            if (task.getTaskId() == taskId) {
                task.setCompleted(true);
            }
        }
        saveTasks();
    }

    private List<Task> loadTasks() {
        try {
            return objectMapper.readValue(file, new TypeReference<List<Task>>() {});
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void saveTasks() {
        try {
            objectMapper.writeValue(file, tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

