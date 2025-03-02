package org.TaskTracker;

import java.time.LocalDate;
import java.util.Map;

public class Main {
    public static void main(String [] args) {
        LocalDate data = LocalDate.of(2025, 3, 2);

        Task task = new Task(123, "Um teste", "In_Progress", data, data);
        Map<String, Object> taskMap = TaskManeger.createTask(task);

        System.out.println(taskMap);

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