package main.java.com.mahen4.tasktracker.service;

import main.java.com.mahen4.tasktracker.model.Task;

import java.util.List;

public class TaskServiceImpl implements TaskService{

    private int nextId = 1;

    @Override
    public void addTask(String description) {
        // TODO add Task to Json
        Task task = new Task(nextId, description);
        System.out.println("Task criada!");
        System.out.printf("Task [%d]\nDescrição: %s\nStatus: %s\n", task.getId(), task.getDescription(), task.getStatus());
    }

    @Override
    public void updateTask(int id, String description) {

    }

    @Override
    public void deleteTask(int id) {

    }

    @Override
    public void markInProgress(int id) {

    }

    @Override
    public void markDone(int id) {

    }

    @Override
    public List<Task> listAll() {
        return List.of();
    }

    @Override
    public List<Task> listByStatus(String status) {
        return List.of();
    }

    @Override
    public void printAllTasks(List<Task> taskList) {

    }
}
