package main.java.com.mahen4.tasktracker.service;

import main.java.com.mahen4.tasktracker.model.Task;
import main.java.com.mahen4.tasktracker.model.TaskStatus;
import main.java.com.mahen4.tasktracker.repository.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

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
        Task task = new Task(nextId, description);
        tasks.add(task);
        taskRepository.saveTasks(tasks);
        System.out.println("Task criada com sucesso!");
        System.out.println(task);
    }

    @Override
    public void updateTask(int id, String description) {
        for(Task task : tasks){
            if (task.getId() == id){
                task.setDescription(description);
                task.updateTaskDate();
                taskRepository.saveTasks(tasks);
                System.out.println("Task atualizada!");
                System.out.println(task);
                return;
            }
        }
        System.out.printf("Task com ID [%d] não encontrada", id);
    }

    @Override
    public void deleteTask(int id) {
        for(Task task: tasks){
            if (task.getId() == id){
                tasks.remove(task);
                taskRepository.saveTasks(tasks);
                System.out.printf("Task [%d] removida!", id);
                return;
            }
        }
        System.out.printf("Task com ID [%d] não encontrada", id);
    }

    @Override
    public void markInProgress(int id) {
        for(Task task: tasks){
            if (task.getId() == id){
                task.setStatus(TaskStatus.IN_PROGRESS);
                task.updateTaskDate();
                taskRepository.saveTasks(tasks);
                System.out.printf("Task [%d] marcada como EM PROGRESSO (IN_PROGRESS)\n", task.getId());
                return;
            }
        }
        System.out.printf("Task com ID [%d] não encontrada", id);
    }

    @Override
    public void markDone(int id) {
        for(Task task: tasks){
            if (task.getId() == id){
                task.setStatus(TaskStatus.DONE);
                task.updateTaskDate();
                taskRepository.saveTasks(tasks);
                System.out.printf("Task [%d] marcada como FEITA (DONE)\n", task.getId());
                return;
            }
        }
        System.out.printf("Task com ID [%d] não encontrada", id);
    }

    @Override
    public List<Task> listAllTask() {
        return tasks;
    }

    @Override
    public List<Task> listByStatus(TaskStatus status) {
        List<Task> filteredTasks = tasks.stream().filter(task -> task.getStatus() == status).collect(Collectors.toList());
        return filteredTasks;
    }

    @Override
    public void printAllTasks(List<Task> tasks) {
        if(tasks.isEmpty()) {
            System.out.println("Nenhuma task encontrada");
        } else {
            for(Task task : tasks) {
                System.out.println(task);
            }
        }
    }
}
