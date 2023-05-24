package com.example.homeworkspringboot.Controller;

import com.example.homeworkspringboot.Model.User;
import com.example.homeworkspringboot.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")

public class UserController {

    private final UserService userService;

    @GetMapping("/get-All-Users")
    public ResponseEntity getAllUsers() {
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PostMapping("/add-user")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUsers(user);
        return ResponseEntity.status(200).body("user added");
    }

    @PutMapping("{id}/update-user/")
    public ResponseEntity updatedUser(@RequestBody @Valid User user, @PathVariable Integer id, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        if (userService.updateUsers(id, user))
            return ResponseEntity.status(200).body("user updated");
        return ResponseEntity.status(400).body(" the id not found");

    }

    @DeleteMapping("{id}/Delete-User")
    public ResponseEntity deleteUser(@PathVariable @Valid Integer id, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        if (userService.deleteUser(id))
            return ResponseEntity.status(200).body("the user delete");
        return ResponseEntity.status(400).body(" id not found");
    }

    // get all by age
    @GetMapping("/get-All-Users/{age}")
    public ResponseEntity findAllByAge(@Valid @PathVariable Integer age) {
        return ResponseEntity.status(200).body(userService.findAllByAge(age));
    }
    // get user by email

    @GetMapping("/get-User-jpql/{email}")
    public ResponseEntity JPQL(@PathVariable String email) {
        User user = userService.JPQL(email);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("//get-All-Users/{email}")
    public ResponseEntity findAllByEmail(@PathVariable String email) {
        return ResponseEntity.status(200).body(userService.findUserByEmail(email));
    }

    // check All user By Email And Passwd
    @GetMapping("/get-user/{username}/{password}")
    public ResponseEntity findUserByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
        User user = userService.findAllByEmailAndPassword(username, password);
        return ResponseEntity.status(200).body(user);
    }


}
