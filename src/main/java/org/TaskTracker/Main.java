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

        String command = args[0].toLowerCase(); // args[0] é o comando

        switch (command){
            case "add":
                if (args.length < 2) {
                    System.out.println("Uso: java -jar task-tracker.jar add <descrição>");
                    System.exit(1);
                } else {
                    TaskManager.addTask(args[1]); // args[1] é a descrição da tarefa
                }
                break;
            case "list":
                TaskManager.listTasks();
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
            case "delete":
                if (args.length < 2){
                    System.out.println("Uso: java -jar task-tracker.jar delete <id>");
                    System.exit(1);
                } else{
                    TaskManager.deleteTask(Integer.parseInt(args[1]));
                }
                break;
            case "help":
                System.out.println("Uso: java -jar task-tracker.jar <comando>\n");
                System.out.println("Comandos disponíveis:");
                System.out.printf("  %-25s %s%n", "add <descrição>", "- Adiciona uma nova tarefa");
                System.out.printf("  %-25s %s%n", "list", "- Lista todas as tarefas");
                System.out.printf("  %-25s %s%n", "update-description <id> <descrição>", "- Atualiza a descrição de uma tarefa");
                System.out.printf("  %-25s %s%n", "update-status <id> <status>", "- Atualiza o status de uma tarefa");
                System.out.println("    Status disponíveis: done, in-progress");
                System.out.printf("  %-25s %s%n", "delete <id>", "- Deleta uma tarefa");
                System.out.printf("  %-25s %s%n", "help", "- Exibe a ajuda");
                System.out.printf("  %-25s %s%n", "version", "- Exibe a versão do aplicativo");

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
