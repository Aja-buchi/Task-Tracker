package com.example.todo.dto;

import com.example.todo.enums.StatusEnums;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Getter
@Setter
public class TaskDto {

    private String title;
    private String description;
    private StatusEnums statusEnums;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime completedAt;
}
