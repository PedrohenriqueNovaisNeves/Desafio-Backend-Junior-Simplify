package com.example.to_do_list_Simplify.repository;

import com.example.to_do_list_Simplify.models.Priority;
import com.example.to_do_list_Simplify.models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, UUID> {

    List<TaskModel> findByPriority(Priority priority);
}
