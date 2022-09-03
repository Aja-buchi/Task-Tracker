package com.example.todo.service;

import com.example.todo.dto.UserSignupDto;
import com.example.todo.model.User;

public interface UserService {
    User signup(UserSignupDto userSignupDto);
    User login(UserSignupDto userSignupDto);
    User fetchUsers(Long id);

    String logout();
}
