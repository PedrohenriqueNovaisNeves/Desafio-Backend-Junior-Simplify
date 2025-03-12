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

    @Column(nullable = true)
    private boolean carriedOut;
    private String priority;
}
