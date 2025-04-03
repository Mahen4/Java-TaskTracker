package main.java.com.mahen4.tasktracker.service;

import main.java.com.mahen4.tasktracker.model.Task;
import main.java.com.mahen4.tasktracker.model.TaskStatus;

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
                // TODO tirar do repository
                System.out.printf("Task [%d] removida!", id);
                return;
            }
        }
        System.out.println("Task não encontrada");
    }

    @Override
    public void markInProgress(int id) {
        for(Task task: tasks){
            if (task.getId() == id){
                task.setStatus(TaskStatus.IN_PROGRESS);
                // TODO salvar mudança no repository
                System.out.printf("Task [%d] marcada como EM PROGRESSO\n", task.getId());
                return;
            }
        }
        System.out.println("Task com id " + id + "não encontrada");
    }

    @Override
    public void markDone(int id) {
        for(Task task: tasks){
            if (task.getId() == id){
                task.setStatus(TaskStatus.DONE);
                // TODO salvar mudança no repository
                System.out.printf("Task [%d] marcada como FEITA\n", task.getId());
                return;
            }
        }
        System.out.println("Task com id " + id + "não encontrada");
    }

    @Override
    public List<Task> listAll() {
        return tasks;
    }

    @Override
    public List<Task> listByStatus(String status) {
        return List.of();
    }

    @Override
    public void printAllTasks(List<Task> taskList) {

    }
}
