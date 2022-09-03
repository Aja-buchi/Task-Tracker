package com.example.todo.controller;

import com.example.todo.dto.TaskDto;
import com.example.todo.dto.UserSignupDto;
import com.example.todo.exceptions.UserNotFoundException;
import com.example.todo.model.Task;
import com.example.todo.model.User;
import com.example.todo.repository.TaskRepository;
import com.example.todo.service.TaskService;
import com.example.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<User> userSignUp(@RequestBody UserSignupDto userSignupDto){
        return new ResponseEntity<>(userService.signup(userSignupDto),HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<User> userLogin(@RequestBody UserSignupDto userSignupDto){
        return new ResponseEntity<>(userService.login(userSignupDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> signUp(@PathVariable("id") Long id) throws UserNotFoundException {
        return new ResponseEntity<>(userService.fetchUsers(id), HttpStatus.OK);
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(){
        return new ResponseEntity<>(userService.logout(), HttpStatus.OK);
    }

}
