package main.java.com.mahen4.tasktracker.cli;

import main.java.com.mahen4.tasktracker.service.TaskService;
import main.java.com.mahen4.tasktracker.service.TaskServiceImpl;

public class TaskTrackerCLI {
    public static void main(String[] args) {

        TaskService taskService = new TaskServiceImpl();
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
                break;
            case "mark-in-progress":
                if (args.length < 2) {
                    System.out.println("Defina uma tarefa como em andamento");
                    System.out.println("task-tracker mark-in-progress <id>");
                }
                break;
            case "mark-done":
                if (args.length < 2) {
                    System.out.println("Defina uma tarefa como feita");
                    System.out.println("task-tracker mark-done <id>");
                }
                break;
            case "list":
                System.out.println("Mostra todas as tarefas");
                System.out.println("task-tracker list [status]");
                break;
        }

    }
}