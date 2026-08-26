package com.example.tasktracker.controller;

import com.example.tasktracker.model.Project;
import com.example.tasktracker.model.projection.CreateProjectRequest;
import com.example.tasktracker.model.projection.ProjectOverview;
import com.example.tasktracker.model.projection.UserSummary;
import com.example.tasktracker.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Integer id) {
        return projectService.getProjectById(id);
    }

    @GetMapping("/{id}/overview")
    public ProjectOverview getProjectOverview(@PathVariable Integer id) {
        return projectService.getProjectOverview(id);
    }

    @GetMapping("/{id}/members")
    public List<UserSummary> getProjectMembers(@PathVariable Integer id) {
        return projectService.getProjectMembers(id);
    }

    @GetMapping("/{id}/tasks")
    public List<?> getProjectTasks(@PathVariable Integer id) {
        return projectService.getProjectTasks(id);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createProject(@RequestBody CreateProjectRequest request) {
        int id = projectService.createProject(request);
        return ResponseEntity.created(URI.create("/api/projects/" + id))
                .body(Map.of("id", id));
    }

    @PostMapping("/{id}/members")
    public ResponseEntity<Map<String, Object>> addMember(@PathVariable Integer id,
                                                         @RequestBody Map<String, Object> body) {
        int userId = (Integer) body.get("userId");
        String role = (String) body.getOrDefault("role", "member");
        int rows = projectService.addMember(id, userId, role);
        return ResponseEntity.ok(Map.of("added", rows));
    }

    @DeleteMapping("/{id}/members/{userId}")
    public ResponseEntity<Map<String, Object>> removeMember(@PathVariable Integer id,
                                                            @PathVariable Integer userId) {
        int rows = projectService.removeMember(id, userId);
        return ResponseEntity.ok(Map.of("removed", rows));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteProject(@PathVariable Integer id) {
        int rows = projectService.deleteProject(id);
        return ResponseEntity.ok(Map.of("deleted", rows));
    }
}
