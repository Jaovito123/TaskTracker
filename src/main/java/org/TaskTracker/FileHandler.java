package org.TaskTracker;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class FileHandler {

    public File createJsonFile(String filePath) throws IOException {
        File jsonFile = new File(filePath);

        if (jsonFile.exists()) {
            return jsonFile;
        }

        if (jsonFile.createNewFile()) {
            return jsonFile;
        } else {
            throw new IOException("Falha ao criar o arquivo " + filePath);
        }
    }

    public void saveJson(Map<String, Object> data){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(data);


    }
}
