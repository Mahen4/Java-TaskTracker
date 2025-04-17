package main.java.com.mahen4.tasktracker.service;

import main.java.com.mahen4.tasktracker.model.Task;
import main.java.com.mahen4.tasktracker.model.TaskStatus;

import java.util.List;

public interface TaskService {
    void addTask(String description);
    void updateTask(int id, String description);
    void deleteTask(int id);

    void markInProgress(int id);
    void markDone(int id);

    List<Task> listAllTask();

    List<Task> listByStatus(TaskStatus status);

    void printAllTasks (List<Task> taskList);
}
