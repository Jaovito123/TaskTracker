package org.TaskTracker;

import java.time.LocalDate;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {
        ArrayList<Map<String, Object>> tasks = FileHandler.loadJson();
        TaskManager.createTask(tasks, "Estudar Java", "Pendente");
        FileHandler.saveJson(tasks);
        TaskManager.showAllTasks(tasks);

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