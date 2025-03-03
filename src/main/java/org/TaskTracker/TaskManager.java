package org.TaskTracker;

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

public class TaskManager {
    public static void addTask(String description) {
        ArrayList<Task> tasks = FileHandler.loadJson(); // Agora retorna ArrayList<Task>
        Integer id = tasks.size() + 1;
        Task task = new Task(description, id);
        tasks.add(task);
        FileHandler.saveJson(tasks); // Salva a lista de objetos corretamente
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

    public static void deleteTask(Integer id) {
        ArrayList<Task> tasks = FileHandler.loadJson();

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getId().equals(id)) {
                tasks.remove(i);
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

}
