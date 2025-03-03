package org.TaskTracker;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public static ArrayList<Map<String, Object>> loadJson(){
        return null;
    }

    public static void saveJson(ArrayList<String> tasks){

        try (FileWriter writer = new FileWriter(createJsonFile())){
            writer.write("[\n");
            for (int i = 0; i < tasks.size(); i++) {
                writer.write(tasks.get(i));
                if (i < tasks.size() - 1) {
                    writer.write(",\n");
                }
            }
            writer.write("\n]");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo " + e.getMessage());
        }
    }
}
