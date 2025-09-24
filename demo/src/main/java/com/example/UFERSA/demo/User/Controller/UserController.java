package com.example.UFERSA.demo.User.Controller;

import com.example.UFERSA.demo.User.Models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/User")
public class UserController {

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(new User(id, "raimundo", "kkkk"));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> messages = List.of(
                new User(1L, "raimundo", "kkkk"),
                new User(2L, "João Pedro ", "kkkk")
        );
        return ResponseEntity.ok(messages);
    }
    @PostMapping
    public ResponseEntity<User> createMessage(@RequestBody User newUser) {
        User createdMessage = new User(99L,newUser.nome(),newUser.senha());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdMessage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateMessage(@PathVariable Long id, @RequestBody User updatedUser) {
        User responseMessage = new User(id,updatedUser.nome(),updatedUser.senha());

        return ResponseEntity.ok(responseMessage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

}
