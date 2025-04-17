package main.java.com.mahen4.tasktracker.cli;

import main.java.com.mahen4.tasktracker.model.Task;
import main.java.com.mahen4.tasktracker.model.TaskStatus;
import main.java.com.mahen4.tasktracker.repository.TaskRepository;
import main.java.com.mahen4.tasktracker.repository.TaskRepositoryImpl;
import main.java.com.mahen4.tasktracker.service.TaskService;
import main.java.com.mahen4.tasktracker.service.TaskServiceImpl;

import java.util.List;

public class TaskTrackerCLI {
    public static void main(String[] args) {

        TaskRepository taskRepository = new TaskRepositoryImpl();

        TaskService taskService = new TaskServiceImpl(taskRepository);
        // só para testes
        // taskService.addTask("Teste1");

        if(args.length == 0){
            System.out.println("task-tracker <comando> [argumentos]");
        }

        String command = args[0];

        switch (command){
            case "add":
                if (args.length < 2) {
                    System.out.println("Adicione uma tarefa nova");
                    System.out.println("task-tracker add <descrição>");
                }
                String description = args[1];
                taskService.addTask(description);
                break;
            case "update":
                if (args.length < 3) {
                    System.out.println("Modifique uma tarefa já existente");
                    System.out.println("task-tracker update <id> <descrição>");
                }
                int updateId = Integer.parseInt(args[1]);
                String newDescription = args[2];
                taskService.updateTask(updateId, newDescription);
                break;
            case "delete":
                if (args.length < 2) {
                    System.out.println("Delete uma tarefa");
                    System.out.println("task-tracker delete <id>");
                }
                int deleteId = Integer.parseInt(args[1]);
                taskService.deleteTask(deleteId);
                break;
            case "mark-in-progress":
                if (args.length < 2) {
                    System.out.println("Defina uma tarefa como em andamento");
                    System.out.println("task-tracker mark-in-progress <id>");
                }
                int inProgressId = Integer.parseInt(args[1]);
                taskService.markInProgress(inProgressId);
                break;
            case "mark-done":
                if (args.length < 2) {
                    System.out.println("Defina uma tarefa como feita");
                    System.out.println("task-tracker mark-done <id>");
                }
                int doneId = Integer.parseInt(args[1]);
                taskService.markDone(doneId);
                break;
            case "list":
                if(args.length == 1){
                    List<Task> allTasks = taskService.listAllTask();
                    taskService.printAllTasks(allTasks);
                } else if (args.length == 2){
                    String statusArg = args[1].toUpperCase().replaceAll("-","_");
                    try{
                        TaskStatus status = TaskStatus.valueOf(statusArg);
                        List<Task> filteredList = taskService.listByStatus(status);
                        taskService.printAllTasks(filteredList);
                    } catch (IllegalArgumentException e){
                        System.out.println("Status");
                    }

                    System.out.println("Mostra todas as tarefas");
                    System.out.println("task-tracker list [status]");
                    taskService.listAllTask();
                    break;
                }
        }

    }
}