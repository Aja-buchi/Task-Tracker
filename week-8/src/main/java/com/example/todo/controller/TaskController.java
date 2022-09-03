package com.example.todo.controller;

import com.example.todo.dto.TaskDto;
import com.example.todo.dto.UpdateTaskTitle;
import com.example.todo.enums.StatusEnums;
import com.example.todo.model.Task;
import com.example.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {


    private final TaskService taskService;


    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/createTask")
    public ResponseEntity<Task> createTask(@RequestBody TaskDto taskDto){
        return  new ResponseEntity<>(taskService.createTask(taskDto), HttpStatus.OK);
    }



    @PostMapping("/setTaskToDone/{id}")
    public ResponseEntity<Task> setTaskToDone(@PathVariable("id") Long id){
        return new ResponseEntity<>(taskService.setStatusDone(id), HttpStatus.OK);
    }

    @PostMapping("/setTaskToInprogress/{id}")
    public ResponseEntity<Task> setTaskToInprogress(@PathVariable("id") Long id){
        return new ResponseEntity<>(taskService.setStatusInProgress(id), HttpStatus.OK);
    }

    @GetMapping("/allTask")
    public  ResponseEntity <List<Task>> findAllTask(){

        return new ResponseEntity<>(taskService.findAllTask(), HttpStatus.OK);
    }

    @GetMapping("/findTaskByPending")
    public ResponseEntity <List<Task>> findTaskByStatus(){

        return new ResponseEntity<>(taskService.findTaskByPending(), HttpStatus.OK);
    }

    @GetMapping("/findTaskByInProgress")
    public ResponseEntity <List<Task>> allTaskByStatus(){

        return new ResponseEntity<>(taskService.findTaskByInProgress(), HttpStatus.OK);
    }

    @GetMapping("/findTaskByDone")
    public ResponseEntity <List<Task>> TaskByStatus(){
        return new ResponseEntity<>(taskService.findTaskByDone(), HttpStatus.OK);
    }

    @PatchMapping("/editTaskByTitleAndDescription/{id}")
    public  ResponseEntity<Task> editTask(@PathVariable("id") Long id, @RequestBody UpdateTaskTitle updateTaskTitle){
        Task task = taskService.updateTask(updateTaskTitle, id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") Long id){
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
