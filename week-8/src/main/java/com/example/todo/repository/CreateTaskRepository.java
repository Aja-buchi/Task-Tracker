package com.example.todo.repository;

import com.example.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreateTaskRepository extends JpaRepository<Task, Long> {
   boolean existsById(Long id);
}
