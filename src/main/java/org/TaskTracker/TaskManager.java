package org.TaskTracker;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TaskManager {

    public static void createTask(ArrayList<Map<String, Object>> task, String description, String status){
        Map<String, Object> data =  new HashMap<>();
        data.put("Id", task.size() + 1);
        data.put("Description", description);
        data.put("Status", status);
        data.put("CreatedAt", java.time.LocalDate.now().toString());
        data.put("UpdatedAt", java.time.LocalDate.now().toString());

        task.add(data);
    }

    public static void readTask(Map<String, Object> taskMap){
        System.out.println("Id: " + taskMap.get("Id"));
        System.out.println("Description: " + taskMap.get("Description"));
        System.out.println("Status: " + taskMap.get("Status"));
        System.out.println("CreatedAt: " + taskMap.get("CreatedAt"));
        System.out.println("UpdatedAt: " + taskMap.get("UpdatedAt"));
    }

    public static void showAllTasks(ArrayList<Map<String, Object>> taskList){
        for (Map<String, Object> taskMap : taskList) {
            readTask(taskMap);
        }
    }

    public static void updateTask(Map<String, Object> taskMap, String status){
        taskMap.put("Status", status);
        taskMap.put("UpdatedAt", java.time.LocalDate.now().toString());
    }

    public static void deleteTask(Map<String, Object> taskMap, String id){
        taskMap.remove(id);
    }
}
