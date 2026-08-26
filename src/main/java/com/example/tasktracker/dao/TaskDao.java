package com.example.tasktracker.dao;

import com.example.tasktracker.model.projection.CreateTaskRequest;
import com.example.tasktracker.model.projection.TaskDetail;
import com.example.tasktracker.model.projection.TaskSummary;
import com.openmapper.annotations.DaoLayer;
import com.openmapper.annotations.DaoMethod;
import com.openmapper.annotations.Param;
import com.openmapper.model.operations.DmlOperation;

import java.util.List;

@DaoLayer
public interface TaskDao {

    @DaoMethod
    List<TaskSummary> findAllTasks();

    @DaoMethod
    TaskDetail findTaskById(@Param(name = "id") Integer id);

    @DaoMethod
    List<TaskSummary> findTasksByProject(@Param(name = "project_id") Integer projectId);

    @DaoMethod
    List<TaskSummary> findTasksByStatus(@Param(name = "status") String status);

    @DaoMethod
    List<TaskSummary> findTasksByExecutor(@Param(name = "executor_id") Integer executorId);

    @DaoMethod
    List<TaskSummary> findSubTasks(@Param(name = "parent_id") Integer parentId);

    @DaoMethod(operation = DmlOperation.INSERT, returnKeys = true)
    int createTask(CreateTaskRequest task);

    @DaoMethod(operation = DmlOperation.UPDATE)
    int updateTaskStatus(@Param(name = "id") Integer id,
                         @Param(name = "status") String status);

    @DaoMethod(operation = DmlOperation.UPDATE)
    int assignExecutor(@Param(name = "id") Integer id,
                       @Param(name = "executor_id") Integer executorId);

    @DaoMethod(operation = DmlOperation.DELETE)
    int deleteTask(@Param(name = "id") Integer id);
}
