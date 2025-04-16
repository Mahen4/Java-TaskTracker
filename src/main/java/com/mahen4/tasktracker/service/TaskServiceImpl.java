package main.java.com.mahen4.tasktracker.service;

import main.java.com.mahen4.tasktracker.model.Task;
import main.java.com.mahen4.tasktracker.model.TaskStatus;
import main.java.com.mahen4.tasktracker.repository.TaskRepository;
import main.java.com.mahen4.tasktracker.repository.TaskRepositoryImpl;

import java.util.List;

public class TaskServiceImpl implements TaskService{

    private int nextId;
    private List<Task> tasks;
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository){
        super();
        this.taskRepository = taskRepository;
        this.tasks = taskRepository.loadTask();
        this.nextId = tasks.isEmpty() ? 1 : tasks.getLast().getId() + 1;
    }

    @Override
    public void addTask(String description) {
        // TODO add Task to Json
        Task task = new Task(nextId, description);
        System.out.println("Task criada!");
        System.out.printf("Task [%d]\nDescrição: %s\nStatus: %s\n", task.getId(), task.getDescription(), task.getStatus());
        System.out.println(task.getCreatedAt());
        System.out.println(task.getUpdatedAt());
        nextId++; // TODO Tirar depois com o repository feito
        tasks.add(task);
    }

    @Override
    public void updateTask(int id, String description) {
        for(Task task : tasks){
            if (task.getId() == id){
                task.setDescription(description);
                // TODO atualizar no repository
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
    public List<Task> listAllTask() {
        return tasks;
    }

    @Override
    public List<Task> listByStatus(String status) {
        return List.of();
    }

    @Override
    public void printAllTasks(List<Task> tasks) {
        if(tasks.isEmpty()) {
            System.out.println("No Tasks Found");
        } else {
            for(Task task : tasks) {
                System.out.println(task);
            }
        }
    }
}
