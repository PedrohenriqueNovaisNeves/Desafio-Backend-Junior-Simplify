package com.example.to_do_list_Simplify.service;

import com.example.to_do_list_Simplify.models.Priority;
import com.example.to_do_list_Simplify.models.TaskModel;
import com.example.to_do_list_Simplify.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public List<TaskModel> listByPriority(Priority priority){
        return taskRepository.findByPriority(priority);
    }

    public TaskModel updateTask(UUID id, TaskModel taskModel){
        Optional<TaskModel> task = taskRepository.findById(id);

        if(task.isEmpty()){
            throw new RuntimeException("Task not found");
        }

        TaskModel newTask = task.get();

        newTask.setName(taskModel.getName());
        newTask.setDescription(taskModel.getDescription());
        newTask.setCarriedOut(taskModel.isCarriedOut());
        newTask.setPriority(taskModel.getPriority());

        return taskRepository.save(newTask);
    }

    public void toUpdateStatusTask(UUID id, String status){
        Optional<TaskModel> task = taskRepository.findById(id);

        if(task.isEmpty()){
            throw new RuntimeException("Task not found");
        }

        TaskModel newTask = task.get();

        newTask.setStatus(status);
    }

     public void deleteTask(UUID id){
        Optional<TaskModel> task = taskRepository.findById(id);

        if(task.isEmpty()){
            throw new RuntimeException("Task not found");
        }

        taskRepository.delete(task.get());
    }

    public void deleteAllTasks(){
        taskRepository.deleteAll();
    }
}
