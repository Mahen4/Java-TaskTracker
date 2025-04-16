package main.java.com.mahen4.tasktracker.repository;

import main.java.com.mahen4.tasktracker.model.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> loadTask();
    void saveTasks(List<Task> tasks);
}
