package com.example.to_do_list_Simplify.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_tasks")
public class TaskModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idTask;
    private String name;
    private String description;

    @Column(nullable = false)
    private boolean carriedOut;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Priority priority;

    public UUID getIdTask() {
        return idTask;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCarriedOut() {
        return carriedOut;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setIdTask(UUID idTask) {
        this.idTask = idTask;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCarriedOut(boolean carriedOut) {
        this.carriedOut = carriedOut;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setStatus(String status){
        if(status.equals("Realizado")){
            this.carriedOut = true;
        }else if(status.equals("Nao realizado")){
            this.carriedOut = false;
        }
    }
}
