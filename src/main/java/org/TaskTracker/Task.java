package org.TaskTracker;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Task {
    private static Integer lastId = 0;
    private Integer id;
    private String description;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    Task(String description){
        this.id = ++lastId;
        this.description = description;
        this.status = Status.TODO.getValue();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void updateDescription(String description){
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    public void updateStatusInProgres(){
        this.status = Status.IN_PROGRESS.getValue();
        this.updatedAt = LocalDateTime.now();
    }

    public void updateStatusDone(){
        this.status = Status.DONE.getValue();
        this.updatedAt = LocalDateTime.now();
    }

    public String toJsonObject(){
        return "    {\n" +
                "       \"id\": " + id + ",\n" +
                "       \"description\": \"" + description + "\",\n" +
                "       \"status\": \"" + status + "\",\n" +
                "       \"createdAt\": \"" + createdAt + "\",\n" +
                "       \"updatedAt\": \"" + updatedAt + "\"\n" +
                "    }";
    }

    public static Task fromJsonObject(String json){
        String[] data = json.split(",");
        String description = data[1].split(":")[1].replace("\"", "");
        Task task = new Task(description);

        task.id = Integer.parseInt(data[0].split(":")[1]);
        task.description = data[1].split(":")[1].replace("\"", "");
        task.status = data[2].split(":")[1].replace("\"", "");
        task.createdAt = LocalDateTime.parse(data[3].split(":")[1].replace("\"", ""));
        task.updatedAt = LocalDateTime.parse(data[4].split(":")[1].replace("\"", ""));

        if (task.id > lastId) {
            lastId = task.id;
        }

        return task;
    }

}
