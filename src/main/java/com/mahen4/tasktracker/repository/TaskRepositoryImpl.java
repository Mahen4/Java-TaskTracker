package main.java.com.mahen4.tasktracker.repository;

import main.java.com.mahen4.tasktracker.model.Task;
import main.java.com.mahen4.tasktracker.util.JsonUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {

    private static final String FILE_PATH = "src/main/java/com/mahen4/tasktracker/tasks.json";

    @Override
    public List<Task> loadTask() {
        List<Task> tasks = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()){
            System.out.println("tasks.json não encontrado. Iniciando com uma lista em branco");
            return tasks;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
            tasks = JsonUtil.parseJsonToString(jsonString.toString());
        } catch (IOException e) {
            System.err.println("Falha ao ler as tasks: " + e.getMessage());
            e.printStackTrace();
        }

        return tasks;
    }

    @Override
    public void saveTasks(List<Task> tasks) {

    }

}
