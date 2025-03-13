package com.example.to_do_list_Simplify;

import com.example.to_do_list_Simplify.models.Priority;
import com.example.to_do_list_Simplify.models.TaskModel;
import com.example.to_do_list_Simplify.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ToDoListSimplifyApplication {

	public static void main(String[] args) {

		SpringApplication.run(ToDoListSimplifyApplication.class, args);

	}

}
