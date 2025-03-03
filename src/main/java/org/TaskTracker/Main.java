package org.TaskTracker;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
    public static void main(String [] args) {
        if (args.length == 0) {
            System.out.println("Uso: java -jar task-tracker.jar <comando>");
            System.exit(1);
        }

        String command = args[0].toLowerCase();

        switch (command){
            case "add":
                if (args.length < 2) {
                    System.out.println("Uso: java -jar task-tracker.jar add <descrição>");
                    System.exit(1);
                } else {
                    TaskManager.addTask(args[1]);
                }
                break;
            case "list":
                TaskManager.listTasks();
                break;
            case "list-todo":
                TaskManager.listTodoTasks();
                break;
            case "list-in-progress":
                TaskManager.listInProgresTasks();
                break;
            case "list-done":
                TaskManager.listDoneTasks();
                break;
            case "update-description":
                if (args.length < 3){
                    System.out.println("Uso: java -jar task-tracker.jar update description <id> <description>");
                    System.exit(1);
                } else{
                    TaskManager.updateDescription(Integer.parseInt(args[1]), args[2]);
                }
                break;
            case "update-status":
                if (args.length < 3){
                    System.out.println("Uso: java -jar task-tracker.jar update status <id> <status>");
                    System.exit(1);
                } else{
                    switch (args[2].toLowerCase()){
                        case "done":
                            TaskManager.updateStatusDone(Integer.parseInt(args[1]));
                            break;
                        case "in-progress":
                            TaskManager.updateStatusInProgres(Integer.parseInt(args[1]));
                            break;
                        default:
                            System.out.println("Status inválido");
                            System.exit(1);
                    }
                }
                break;
            case "remove":
                if (args.length < 2){
                    System.out.println("Uso: java -jar task-tracker.jar remove <id>");
                    System.exit(1);
                } else{
                    TaskManager.removeTask(Integer.parseInt(args[1]));
                }
                break;
            case "help":
                TaskManager.help();
                break;
            case "version":
                System.out.println("Task Tracker v1.0");
                break;
            default:
                System.out.println("Comando inválido. Use 'java -jar task-tracker.jar help' para ver os comandos disponíveis");
                System.exit(1);
        }
    }
}
