package com.example.tasktracker.service;

import com.example.tasktracker.dao.TaskDao;
import com.example.tasktracker.model.projection.CreateTaskRequest;
import com.example.tasktracker.model.projection.TaskDetail;
import com.example.tasktracker.model.projection.TaskSummary;
import com.openmapper.annotations.UseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@UseRepository
@RequiredArgsConstructor
public class TaskService {

    private final TaskDao taskDao;

    public List<TaskSummary> getAllTasks() {
        return taskDao.findAllTasks();
    }

    public TaskDetail getTaskById(Integer id) {
        return taskDao.findTaskById(id);
    }

    public List<TaskSummary> getTasksByProject(Integer projectId) {
        return taskDao.findTasksByProject(projectId);
    }

    public List<TaskSummary> getTasksByStatus(String status) {
        return taskDao.findTasksByStatus(status);
    }

    public List<TaskSummary> getTasksByExecutor(Integer executorId) {
        return taskDao.findTasksByExecutor(executorId);
    }

    public List<TaskSummary> getSubTasks(Integer parentId) {
        return taskDao.findSubTasks(parentId);
    }

    public int createTask(CreateTaskRequest request) {
        return taskDao.createTask(request);
    }

    public int updateTaskStatus(Integer id, String status) {
        return taskDao.updateTaskStatus(id, status);
    }

    public int assignExecutor(Integer id, Integer executorId) {
        return taskDao.assignExecutor(id, executorId);
    }

    public int deleteTask(Integer id) {
        return taskDao.deleteTask(id);
    }
}
