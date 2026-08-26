package com.example.tasktracker.service;

import com.example.tasktracker.dao.ProjectDao;
import com.example.tasktracker.dao.TaskDao;
import com.example.tasktracker.model.Project;
import com.example.tasktracker.model.projection.CreateProjectRequest;
import com.example.tasktracker.model.projection.ProjectOverview;
import com.example.tasktracker.model.projection.TaskSummary;
import com.example.tasktracker.model.projection.UserSummary;
import com.openmapper.annotations.UseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@UseRepository
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectDao projectDao;
    private final TaskDao taskDao;

    public List<Project> getAllProjects() {
        return projectDao.findAllProjects();
    }

    public Project getProjectById(Integer id) {
        return projectDao.findProjectById(id);
    }

    public ProjectOverview getProjectOverview(Integer id) {
        return projectDao.findProjectOverview(id);
    }

    public List<TaskSummary> getProjectTasks(Integer projectId) {
        return taskDao.findTasksByProject(projectId);
    }

    public List<UserSummary> getProjectMembers(Integer projectId) {
        return projectDao.findProjectMembers(projectId);
    }

    public int createProject(CreateProjectRequest request) {
        return projectDao.createProject(request);
    }

    public int addMember(Integer projectId, Integer userId, String role) {
        return projectDao.addProjectMember(projectId, userId, role);
    }

    public int removeMember(Integer projectId, Integer userId) {
        return projectDao.removeProjectMember(projectId, userId);
    }

    public int deleteProject(Integer id) {
        return projectDao.deleteProject(id);
    }
}
