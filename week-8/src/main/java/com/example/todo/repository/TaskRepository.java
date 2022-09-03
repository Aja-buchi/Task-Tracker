package com.example.todo.repository;

import com.example.todo.enums.StatusEnums;
import com.example.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAll();

    List<Task> findByStatusEnums(StatusEnums statusEnums);

    Optional<Task> findTaskById(Long id);
}
