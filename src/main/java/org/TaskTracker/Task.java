package org.TaskTracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Task {
    private Integer id;
    private String description;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    Task(String description, Integer id) {
        this.id = id;
        this.description = description;
        this.status = Status.TODO.getValue();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    Task(Integer id, String description, String status, String createdAt, String updatedAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = parseDateTime(createdAt);
        this.updatedAt = parseDateTime(updatedAt);
    }


    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
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
                "       \"id\": " + this.id + ",\n" +
                "       \"description\": \"" + description + "\",\n" +
                "       \"status\": \"" + status + "\",\n" +
                "       \"createdAt\": \"" + createdAt + "\",\n" +
                "       \"updatedAt\": \"" + updatedAt + "\"\n" +
                "    }";
    }

    public static Task fromJson(String json) {
        String idStr = json.split("\"id\": ")[1].split(",")[0].trim();
        Integer id = Integer.valueOf(idStr); // Agora converte corretamente para Integer

        String description = json.split("\"description\": \"")[1].split("\"")[0].trim();
        String status = json.split("\"status\": \"")[1].split("\"")[0].trim();
        String createdAt = json.split("\"createdAt\": \"")[1].split("\"")[0].trim();
        String updatedAt = json.split("\"updatedAt\": \"")[1].split("\"")[0].trim();

        return new Task(id, description, status, createdAt, updatedAt);
    }



    private static LocalDateTime parseDateTime(String dateStr){
        if (dateStr.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}")) {
            dateStr += ":00:00";
        } else if (dateStr.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}")) {
            dateStr += ":00";
        }
        return LocalDateTime.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);    }

    public static Task fromJsonObject(String json){
        String[] data = json.split(",");
        String description = data[1].split(":")[1].replace("\"", "");
        ArrayList<Task>  list = FileHandler.loadJson();
        Task task = new Task(description, list.size() + 1);

        String createdAtStr = data[3].split(":")[1].replace("\"", "").trim();
        String updatedAtStr = data[4].split(":")[1].replace("\"", "").replace("}", "").trim();


        task.id = Integer.parseInt(data[0].split(":")[1].replace(" ", ""));
        task.description = data[1].split(":")[1].replace("\"", "");
        task.status = data[2].split(":")[1].replace("\"", "");
        task.createdAt = parseDateTime(createdAtStr);
        task.updatedAt = parseDateTime(updatedAtStr);

        return task;
    }

    @Override
    public String toString() {
        return "Task{id=" + id +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt + '}';
    }

}
