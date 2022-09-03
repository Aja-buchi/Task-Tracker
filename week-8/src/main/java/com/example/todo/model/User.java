package com.example.todo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    @Size(min = 3, max = 10, message = "Username must be between 3 to 10 characters")
    private  String userName;
    @NotNull
    @Column(unique = true, nullable = false)
    private String email;
    @Size(min = 5, max = 15, message = "Password must be between 5 to 15 characters")
    private String password;

    @OneToMany(targetEntity = Task.class, mappedBy = "user1")
    private List<Task> taskList;

}
