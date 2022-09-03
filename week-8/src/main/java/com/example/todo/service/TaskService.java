package com.example.todo.service;

import com.example.todo.dto.TaskDto;
import com.example.todo.dto.UpdateTaskTitle;
import com.example.todo.dto.UserSignupDto;
import com.example.todo.enums.StatusEnums;
import com.example.todo.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task setStatusDone(Long id);

    Task setStatusInProgress(Long id);

    Task createTask(TaskDto taskDto);

    List<Task> findAllTask();
    List<Task> findTaskByPending();
    List<Task> findTaskByInProgress();
    List<Task> findTaskByDone();
    Task updateTask(UpdateTaskTitle updateTaskTitle, Long id);

    void deleteTask(Long id);

}
