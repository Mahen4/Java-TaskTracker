package main.java.com.mahen4.tasktracker.repository;

import main.java.com.mahen4.tasktracker.model.Task;
import main.java.com.mahen4.tasktracker.util.JsonUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {

    private static final String FILE_PATH = "tasks.json";

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
        String jsonString = JsonUtil.convertTaskToJson(tasks);
        File file = new File(FILE_PATH);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(jsonString);
        } catch (IOException e) {
            System.err.println("Error saving tasks: " + e.getMessage());
        }
    }

}
