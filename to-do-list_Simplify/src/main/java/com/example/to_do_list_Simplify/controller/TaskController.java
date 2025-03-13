package com.example.to_do_list_Simplify.controller;

import com.example.to_do_list_Simplify.repository.TaskRepository;
import com.example.to_do_list_Simplify.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/ping")
    public String ping(){
        return "ping!";
    }
}
