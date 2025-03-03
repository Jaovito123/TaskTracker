package org.TaskTracker;

import java.io.FileReader;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    private static final String FILE_NAME = "tasks.json";

    public static File createJsonFile() throws IOException {
        File jsonFile = new File(FILE_NAME);

        if (jsonFile.exists()) {
            return jsonFile;
        }

        if (jsonFile.createNewFile()) {
            return jsonFile;
        } else {
            throw new IOException("Falha ao criar o arquivo tasks.json");
        }
    }

    public static ArrayList<Task> loadJson() {
        ArrayList<Task> tasks = new ArrayList<>();
        try (FileReader reader = new FileReader(createJsonFile())) {
            int data;
            StringBuilder json = new StringBuilder();
            while ((data = reader.read()) != -1) {
                json.append((char) data);
            }

            String[] jsonTasks = json.toString().replace("[", "").replace("]", "").split("},");
            for (String task : jsonTasks) {
                if (!task.trim().isEmpty()) {
                    if (!task.endsWith("}")) {
                        task += "}";
                    }
                    tasks.add(Task.fromJson(task));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo " + e.getMessage());
        }
        return tasks;
    }


    public static void saveJson(ArrayList<Task> tasks) {
        try (FileWriter writer = new FileWriter(createJsonFile())) {
            writer.write("[\n");
            for (int i = 0; i < tasks.size(); i++) {
                writer.write(tasks.get(i).toJsonObject());
                if (i < tasks.size() - 1) {
                    writer.write(",\n");
                }
            }
            writer.write("\n]");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

}
