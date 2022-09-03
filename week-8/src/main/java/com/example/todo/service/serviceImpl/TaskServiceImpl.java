package com.example.todo.service.serviceImpl;

import com.example.todo.dto.TaskDto;
import com.example.todo.dto.UpdateTaskTitle;
import com.example.todo.enums.StatusEnums;
import com.example.todo.exceptions.TaskAlreadyExist;
import com.example.todo.exceptions.TaskNotFoundException;
import com.example.todo.exceptions.UserNotFoundException;
import com.example.todo.model.Task;
import com.example.todo.repository.TaskRepository;
import com.example.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.example.todo.enums.StatusEnums.*;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task setStatusDone(Long id) {
     Task task = taskRepository.findTaskById(id)
             .orElseThrow(() -> new TaskNotFoundException("This task does not exist"));
        task.setStatusEnums(StatusEnums.DONE);
        task.setUpdatedAt(LocalDateTime.now());
        task.setCompletedAt(LocalDateTime.now());
        taskRepository.save(task);
        return task;
    }


    @Override
    public Task setStatusInProgress(Long id) {
        Task task = taskRepository.findTaskById(id)
                .orElseThrow(() -> new TaskNotFoundException("This task does not exist"));
        task.setStatusEnums(IN_PROGRESS);
        task.setUpdatedAt(LocalDateTime.now());
        taskRepository.save(task);
        return task;
    }

    @Override
    public Task createTask(TaskDto taskDto) {
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setStatusEnums(PENDING);
        task.setDescription(taskDto.getDescription());
        task.setCreatedAt(LocalDateTime.now());
        return taskRepository.save(task);

    }

    @Override
    public List<Task> findAllTask() {
        return taskRepository.findAll();
    }

    @Override
   public List<Task> findTaskByPending() {
        return taskRepository.findByStatusEnums(PENDING);
    }

    @Override
    public List<Task> findTaskByInProgress() {
        return taskRepository.findByStatusEnums(IN_PROGRESS);
    }

    @Override
    public List<Task> findTaskByDone() {
        return taskRepository.findByStatusEnums(DONE);
    }

    @Override
    public Task updateTask(UpdateTaskTitle updateTaskTitle, Long id) {
        Task task = taskRepository.findTaskById(id)
                        .orElseThrow(() -> new TaskNotFoundException("This task does not exist"));
        task.setTitle(updateTaskTitle.getTitle());
        task.setDescription(updateTaskTitle.getDescription());
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findTaskById(id)
                .orElseThrow(()-> new TaskNotFoundException("This task does not exist"));
        taskRepository.delete(task);
    }

}
