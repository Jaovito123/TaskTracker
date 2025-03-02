package org.TaskTracker;

import java.util.Map;
import java.util.HashMap;

public class TaskManeger {

    public static Map<String, Object> createTask(Task task){
        Map<String, Object>  data =  new HashMap<>();
        data.put("Id", task.getId());
        data.put("Description", task.getDescription());
        data.put("Status", task.getStatus());
        data.put("CreatedAt", task.getCreatedAt());
        data.put("UpdatedAt", task.getUpdatedAt());

        return data;
    }

}
