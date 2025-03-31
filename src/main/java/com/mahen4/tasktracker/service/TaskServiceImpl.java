package main.java.com.mahen4.tasktracker.service;

import main.java.com.mahen4.tasktracker.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl implements TaskService{

    private int nextId = 1;
    private List<Task> tasks = new ArrayList<>();
    // TODO private TaskRepository taskRepository;

    @Override
    public void addTask(String description) {
        // TODO add Task to Json
        Task task = new Task(nextId, description);
        System.out.println("Task criada!");
        System.out.printf("Task [%d]\nDescrição: %s\nStatus: %s\n", task.getId(), task.getDescription(), task.getStatus());
        nextId++; // TODO Tirar depois com o repository feito
        tasks.add(task);
    }

    @Override
    public void updateTask(int id, String description) {
        for(Task task : tasks){
            if (task.getId() == id){
                task.setDescription(description);
                System.out.println("Task atualizada!");
                System.out.printf("Task [%d]\nDescrição: %s\nStatus: %s\n", task.getId(), task.getDescription(), task.getStatus());
                return;
            }
        }
        System.out.println("Task não encontrada");
    }

    @Override
    public void deleteTask(int id) {
        for(Task task: tasks){
            if (task.getId() == id){
                tasks.remove(task);
                System.out.printf("Task [%d] removida!", id);
                return;
            }
        }
        System.out.println("Task não encontrada");
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
