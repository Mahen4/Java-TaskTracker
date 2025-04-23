package main.java.com.mahen4.tasktracker.util;

import main.java.com.mahen4.tasktracker.model.Task;
import main.java.com.mahen4.tasktracker.model.TaskStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    public static List<Task> parseJsonToString(String json) {
        List<Task> tasks = new ArrayList<>();

        if (json == null || json.trim().isEmpty()) {
            return tasks;
        }

        json = json.substring(1, json.length() - 1).trim().replaceAll("\\s", "");
        String[] entries = splitJsonEntries(json);

        for (String entry : entries) {
            Task task = new Task();
            entry = entry.substring(1, entry.length() - 1);
            String[] jsonElements = entry.split(",", 5);

            for (String element : jsonElements) {

                String[] keyValue = element.split(":", 2);
                String key = keyValue[0].trim().replaceAll("\"", "");
                String value = keyValue[1].trim().replaceAll("\"", "");

                try {
                    switch (key) {
                        case "id":
                            task.setId(Integer.parseInt(value));
                            break;
                        case "description":
                            task.setDescription(value);
                            break;
                        case "status":
                            task.setStatus(TaskStatus.valueOf(value));
                            break;
                        case "createdAt":
                            if (!value.equals("null")) {
                                task.setCreatedAt(LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                            }
                            break;
                        case "updatedAt":
                            if (!value.equals("null")) {
                                task.setUpdatedAt(LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                            }
                            break;
                        default:
                            throw new IllegalArgumentException("Valor Inválido: " + key);
                    }
                } catch (DateTimeParseException e) {
                    System.err.println("Erro ao converter data-tempo para a chave '" + key + "': " + value);
                }

            }

            tasks.add(task);

        }
        return tasks;
    }

    private static String[] splitJsonEntries(String json) {
        List<String> entries = new ArrayList<>();
        int bracketCount = 0, braceCount = 0;
        boolean inQuotes = false;
        StringBuilder entry = new StringBuilder();

        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);

            if (c == '"') {
                inQuotes = !inQuotes;
            }

            if (!inQuotes) {
                if (c == '{') {
                    braceCount++;
                } else if (c == '}') {
                    braceCount--;
                } else if (c == '[') {
                    bracketCount++;
                } else if (c == ']') {
                    bracketCount--;
                }
            }

            if (c == ',' && !inQuotes && braceCount == 0 && bracketCount == 0) {
                entries.add(entry.toString().trim());
                entry.setLength(0);
            } else {
                entry.append(c);
            }
        }

        if (!entry.isEmpty()) {
            entries.add(entry.toString().trim());
        }

        return entries.toArray(new String[0]);
    }

    public static String convertTaskToJson(List<Task> tasksList){

        StringBuilder jsonTasks = new StringBuilder("[");

        for (int i = 0; i < tasksList.size(); i++){
            Task task = tasksList.get(i);
            jsonTasks.append("{")
                    .append("\"id\":").append(task.getId()).append(",")
                    .append("\"description\":\"").append(task.getDescription()).append("\",")
                    .append("\"status\":\"").append(task.getStatus().toString()).append("\",")
                    .append("\"createdAt\":\"").append(task.getCreatedAt() != null ? task.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) : null).append("\",")
                    .append("\"updatedAt\":\"").append(task.getUpdatedAt() != null ? task.getUpdatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) : null).append("\"")
                    .append("}");
            if (i < tasksList.size() - 1){
                jsonTasks.append(",");
            }
        }
        jsonTasks.append("]");
        return jsonTasks.toString();
    }

}
