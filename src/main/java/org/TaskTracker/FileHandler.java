package org.TaskTracker;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    private static final String FILE_NAME = "tasks.json";
    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

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
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return new ArrayList<Map<String, Object>>();
        }

        try (FileReader reader = new FileReader(FILE_NAME)){
            Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo " + e.getMessage());
            return new ArrayList<Map<String, Object>>();
        }
    }

    public static void saveJson(List<Map<String, Object>> data){
        String json = gson.toJson(data);

        try (FileWriter writer = new FileWriter(createJsonFile())){
            writer.write(json);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo " + e.getMessage());
        }
    }
}
