package com.example.to_do_list_Simplify.controller;

import com.example.to_do_list_Simplify.dto.TaskRecord;
import com.example.to_do_list_Simplify.models.Priority;
import com.example.to_do_list_Simplify.models.TaskModel;
import com.example.to_do_list_Simplify.repository.TaskRepository;
import com.example.to_do_list_Simplify.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PostMapping("/saveTask")
    public ResponseEntity<Object> saveUser(@Valid @RequestBody TaskRecord taskRecord){
        var task = new TaskModel();
        BeanUtils.copyProperties(taskRecord, task);

        taskService.saveTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body("registered task");
    }

    @GetMapping("/listAllTasks")
    public ResponseEntity<List<TaskModel>> listAllTasks(){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.listAllTasks());
    }

    @GetMapping("/listOneTask/{id}")
    public ResponseEntity<Object> listOneTask(@PathVariable(value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.listOneTask(id));
    }

    @GetMapping("/listTasksByPriority")
    public ResponseEntity<List<TaskModel>> listTasksByPriority(@RequestBody TaskModel taskModel){
        List<TaskModel> listTasks = taskService.listByPriority(taskModel.getPriority());
        return ResponseEntity.status(HttpStatus.OK).body(listTasks);
    }

    @PutMapping("/updateTask/{id}")
    public ResponseEntity<Object> updateTask(@PathVariable(value = "id")UUID id, @Valid @RequestBody TaskRecord taskRecord){
        var task = new TaskModel();
        BeanUtils.copyProperties(taskRecord, task);

        taskService.updateTask(id, task);
        return ResponseEntity.status(HttpStatus.OK).body("Update completed successfully");
    }

    @PatchMapping("/toUpdateStatusTask/{id}")
    public ResponseEntity<Object> toUpdateStatusTask(@PathVariable(value = "id")UUID id, @Valid @RequestBody String status){
        taskService.toUpdateStatusTask(id, status);
        return ResponseEntity.status(HttpStatus.OK).body("Status update");
    }

    @DeleteMapping("/deleteAllTasks")
    public ResponseEntity<Object> deleteAllTasks(){
        taskService.deleteAllTasks();
        return ResponseEntity.status(HttpStatus.OK).body("Delete all completed successfully");
    }

    @DeleteMapping("/deleteOneTask/{id}")
    public ResponseEntity<Object> deleteOneTask(@PathVariable(value = "id")UUID id){
        taskService.deleteTask(id);
        return ResponseEntity.status(HttpStatus.OK).body("Task delete successfully");
    }
}
