package org.TaskTracker;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {

        ArrayList<String> tasks = new ArrayList<>();

        Task task1 = new Task("Estudar Java");
        Task task2 = new Task("Estudar Spring Boot");
        Task task3 = new Task("Estudar MySQL");

        String json = task1.toJsonObject();
        tasks.add(json);
        String json2 = task2.toJsonObject();
        tasks.add(json2);
        String json3 = task3.toJsonObject();
        tasks.add(json3);

        FileHandler.saveJson(tasks);
        System.out.println(tasks);

    }
}




/*
├── src/main/java/com/tasktracker/
│   ├── Task.java            # Modelo da Tarefa
│   ├── TaskManager.java      # Gerencia as tarefas (CRUD)
│   ├── FileHandler.java      # Lida com JSON (salvar/carregar)
│   ├── CLI.java              # Interface de Linha de Comando
│   ├── TaskTrackerApp.java   # Classe principal (entry point)
├── tasks.json                # Arquivo onde as tarefas serão armazenadas
├── pom.xml                   # Configuração do Maven
*/