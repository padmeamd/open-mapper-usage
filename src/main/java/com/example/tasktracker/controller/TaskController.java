package com.example.tasktracker.controller;

import com.example.tasktracker.model.projection.CreateTaskRequest;
import com.example.tasktracker.model.projection.TaskDetail;
import com.example.tasktracker.model.projection.TaskSummary;
import com.example.tasktracker.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<TaskSummary> getAllTasks(@RequestParam(required = false) String status,
                                        @RequestParam(required = false) Integer executorId) {
        if (status != null) return taskService.getTasksByStatus(status);
        if (executorId != null) return taskService.getTasksByExecutor(executorId);
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskDetail getTaskById(@PathVariable Integer id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/{id}/subtasks")
    public List<TaskSummary> getSubTasks(@PathVariable Integer id) {
        return taskService.getSubTasks(id);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createTask(@RequestBody CreateTaskRequest request) {
        int id = taskService.createTask(request);
        return ResponseEntity.created(URI.create("/api/tasks/" + id))
                .body(Map.of("id", id));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Map<String, Object>> updateStatus(@PathVariable Integer id,
                                                            @RequestBody Map<String, String> body) {
        int rows = taskService.updateTaskStatus(id, body.get("status"));
        return ResponseEntity.ok(Map.of("updated", rows));
    }

    @PatchMapping("/{id}/executor")
    public ResponseEntity<Map<String, Object>> assignExecutor(@PathVariable Integer id,
                                                              @RequestBody Map<String, Integer> body) {
        int rows = taskService.assignExecutor(id, body.get("executorId"));
        return ResponseEntity.ok(Map.of("updated", rows));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteTask(@PathVariable Integer id) {
        int rows = taskService.deleteTask(id);
        return ResponseEntity.ok(Map.of("deleted", rows));
    }
}
