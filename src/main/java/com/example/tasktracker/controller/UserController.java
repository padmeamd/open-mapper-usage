package com.example.tasktracker.controller;

import com.example.tasktracker.model.projection.CreateUserRequest;
import com.example.tasktracker.model.projection.UserSummary;
import com.example.tasktracker.model.projection.UserWithTasks;
import com.example.tasktracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserSummary> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserSummary getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/{id}/tasks")
    public UserWithTasks getUserWithTasks(@PathVariable Integer id) {
        return userService.getUserWithTasks(id);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody CreateUserRequest request) {
        int id = userService.createUser(request);
        return ResponseEntity.created(URI.create("/api/users/" + id))
                .body(Map.of("id", id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateUser(@PathVariable Integer id,
                                                          @RequestBody CreateUserRequest request) {
        int rows = userService.updateUser(id, request);
        return ResponseEntity.ok(Map.of("updated", rows));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable Integer id) {
        int rows = userService.deleteUser(id);
        return ResponseEntity.ok(Map.of("deleted", rows));
    }
}
