package com.example.to_do_list_Simplify.service;

import com.example.to_do_list_Simplify.models.TaskModel;
import com.example.to_do_list_Simplify.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public TaskModel saveTask(TaskModel taskModel){
        return taskRepository.save(taskModel);
    }

    public List<TaskModel> listAllTasks(){
        return taskRepository.findAll();
    }

    public Object listOneTask(UUID id){
        return taskRepository.findById(id);
    }


}
