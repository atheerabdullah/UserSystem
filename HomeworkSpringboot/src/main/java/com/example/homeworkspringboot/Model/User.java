package com.example.homeworkspringboot.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "the name cant be empty")
    @Column(columnDefinition = "varchar(4) not null")
    private String name;


    @NotEmpty(message = "the username cant be empty")
    @Column(columnDefinition = "varchar(4) not null unique")
    private String username;


    @NotEmpty(message = "the password cant be empty")
    private String password;

    @NotEmpty(message = "the email cant be empty")
    @Email
    @Column(columnDefinition = "varchar(299) not null unique")
    private String email;

    @NotEmpty(message = "the role must be admin or user ")
    @Column(columnDefinition = "varchar(4) not null unique check( role='admin' or role = 'user' )")
    private String role;

    @NotNull(message = "the age cant be empty")
    @Column(columnDefinition = "int not null unique")
    private Integer age;
}
