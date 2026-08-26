package com.example.tasktracker.dao;

import com.example.tasktracker.model.Project;
import com.example.tasktracker.model.projection.CreateProjectRequest;
import com.example.tasktracker.model.projection.ProjectOverview;
import com.example.tasktracker.model.projection.UserSummary;
import com.openmapper.annotations.DaoLayer;
import com.openmapper.annotations.DaoMethod;
import com.openmapper.annotations.Param;
import com.openmapper.model.operations.DmlOperation;

import java.util.List;

@DaoLayer
public interface ProjectDao {

    @DaoMethod
    List<Project> findAllProjects();

    @DaoMethod
    Project findProjectById(@Param(name = "id") Integer id);

    @DaoMethod
    ProjectOverview findProjectOverview(@Param(name = "id") Integer id);

    @DaoMethod
    List<UserSummary> findProjectMembers(@Param(name = "project_id") Integer projectId);

    @DaoMethod(operation = DmlOperation.INSERT, returnKeys = true)
    int createProject(CreateProjectRequest project);

    @DaoMethod(operation = DmlOperation.INSERT)
    int addProjectMember(@Param(name = "project_id") Integer projectId,
                         @Param(name = "user_id") Integer userId,
                         @Param(name = "role") String role);

    @DaoMethod(operation = DmlOperation.DELETE)
    int removeProjectMember(@Param(name = "project_id") Integer projectId,
                            @Param(name = "user_id") Integer userId);

    @DaoMethod(operation = DmlOperation.DELETE)
    int deleteProject(@Param(name = "id") Integer id);
}
