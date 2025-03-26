package main.java.com.mahen4.tasktracker.model;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private String description;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public Task(){
        super();
    }

    public Task(int id, String description){
        this.id = id;
        this.description = description;
        this.status = "A FAZER";
        this.createdAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString(){
        return "Task [" + getId() +"] - descrição = " + getDescription() + ", status: " + getStatus() + ", criado em: " + getCreatedAt() + ", ultima vez modificado em: " + getUpdateAt();
    }

}
