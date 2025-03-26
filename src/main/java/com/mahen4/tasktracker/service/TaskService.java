package main.java.com.mahen4.tasktracker.service;

import main.java.com.mahen4.tasktracker.model.Task;

import java.util.List;

public interface TaskService {
    void addTask(String description);
    void updateTask(int id, String description);
    void deleteTask(int id);

    void markInProgress(int id);
    void markDone(int id);

    List<Task> listAll();

    List<Task> listByStatus(String status);

    void printAllTasks (List<Task> taskList);
}
