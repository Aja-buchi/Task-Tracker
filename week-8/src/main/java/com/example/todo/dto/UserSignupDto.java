package com.example.todo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserSignupDto {

    private String userName;
    private String email;
    private String password;
}
