package org.TaskTracker;

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

public class TaskManager {
    private static void reorganizeIds(ArrayList<Task> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            task.setId(i + 1);
            tasks.set(i, task);
        }
    }

    public static void addTask(String description) {
        ArrayList<Task> tasks = FileHandler.loadJson(); // Agora retorna ArrayList<Task>
        Integer id = tasks.size() + 1;
        Task task = new Task(description, id);
        tasks.add(task);
        FileHandler.saveJson(tasks);
    }

    public static void listTasks() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        ArrayList<Task> tasks = FileHandler.loadJson();
        for (Task task : tasks) {
            System.out.println("id: " + task.getId());
            System.out.println("description: " + task.getDescription());
            System.out.println("status: " + task.getStatus());
            System.out.println("createdAt: " + task.getCreatedAt().format(formatter));
            System.out.println("updatedAt: " + task.getUpdatedAt().format(formatter));
            System.out.println();
        }
    }

    public static void listTodoTasks() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        ArrayList<Task> tasks = FileHandler.loadJson();
        for (Task task : tasks) {
            if (task.getStatus().equals(Status.TODO.getValue())) {
                System.out.println("id: " + task.getId());
                System.out.println("description: " + task.getDescription());
                System.out.println("status: " + task.getStatus());
                System.out.println("createdAt: " + task.getCreatedAt().format(formatter));
                System.out.println("updatedAt: " + task.getUpdatedAt().format(formatter));
                System.out.println();
            }
        }
    }

    public static void listInProgresTasks() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        ArrayList<Task> tasks = FileHandler.loadJson();
        for (Task task : tasks) {
            if (task.getStatus().equals(Status.IN_PROGRESS.getValue())) {
                System.out.println("id: " + task.getId());
                System.out.println("description: " + task.getDescription());
                System.out.println("status: " + task.getStatus());
                System.out.println("createdAt: " + task.getCreatedAt().format(formatter));
                System.out.println("updatedAt: " + task.getUpdatedAt().format(formatter));
                System.out.println();
            }
        }
    }

    public static void listDoneTasks() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        ArrayList<Task> tasks = FileHandler.loadJson();
        for (Task task : tasks) {
            if (task.getStatus().equals(Status.DONE.getValue())) {
                System.out.println("id: " + task.getId());
                System.out.println("description: " + task.getDescription());
                System.out.println("status: " + task.getStatus());
                System.out.println("createdAt: " + task.getCreatedAt().format(formatter));
                System.out.println("updatedAt: " + task.getUpdatedAt().format(formatter));
                System.out.println();
            }
        }
    }

    public static void updateDescription(Integer id, String description) {
        ArrayList<Task> tasks = FileHandler.loadJson();

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getId().equals(id)) {
                task.updateDescription(description);
                tasks.set(i, task);
                FileHandler.saveJson(tasks);
                break;
            } else if (i == tasks.size() -1) {
                System.out.println("Tarefa não encontrada");
            }
        }
    }

    public static void removeTask(Integer id) {
        ArrayList<Task> tasks = FileHandler.loadJson();

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getId().equals(id)) {
                tasks.remove(i);
                reorganizeIds(tasks);
                FileHandler.saveJson(tasks);
                break;
            } else if (i == tasks.size() -1) {
                System.out.println("Tarefa não encontrada");
            }
        }
    }

    public static void updateStatusDone(Integer id) {
        ArrayList<Task> tasks = FileHandler.loadJson();
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getId().equals(id)) {
                task.updateStatusDone();
                tasks.set(i, task);
                FileHandler.saveJson(tasks);
                break;
            } else if (i == tasks.size() -1) {
                System.out.println("Tarefa não encontrada");
            }
        }
    }

    public static void updateStatusInProgres(Integer id) {
        ArrayList<Task> tasks = FileHandler.loadJson();
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getId().equals(id)) {
                task.updateStatusInProgres();
                tasks.set(i, task);
                FileHandler.saveJson(tasks);
                break;
            } else if (i == tasks.size() -1) {
                System.out.println("Tarefa não encontrada");
            }
        }
    }

    public static void help() {
        System.out.println("Uso: java -jar task-tracker.jar <comando>\n");
        System.out.println("Comandos disponíveis:");
        System.out.printf("  %-50s %s%n", "add <descrição>", "- Adiciona uma nova tarefa");
        System.out.printf("  %-50s %s%n", "list", "- Lista todas as tarefas");
        System.out.printf("  %-50s %s%n", "list-todo", "- Lista as tarefas a fazer");
        System.out.printf("  %-50s %s%n", "list-in-progress", "- Lista as tarefas em andamento");
        System.out.printf("  %-50s %s%n", "list-done", "- Lista as tarefas concluídas");
        System.out.printf("  %-50s %s%n", "update-description <id> <descrição>", "- Atualiza a descrição de uma tarefa");
        System.out.printf("  %-50s %s%n", "update-status <id> <status>", "- Atualiza o status de uma tarefa");
        System.out.println("      Status disponíveis: done, in-progress");
        System.out.printf("  %-50s %s%n", "remove <id>", "- Deleta uma tarefa");
        System.out.printf("  %-50s %s%n", "help", "- Exibe a ajuda");
        System.out.printf("  %-50s %s%n", "version", "- Exibe a versão do aplicativo");
    }
}
