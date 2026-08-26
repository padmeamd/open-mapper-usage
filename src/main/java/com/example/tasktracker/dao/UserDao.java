package com.example.tasktracker.dao;

import com.example.tasktracker.model.projection.CreateUserRequest;
import com.example.tasktracker.model.projection.UserSummary;
import com.example.tasktracker.model.projection.UserWithTasks;
import com.openmapper.annotations.DaoLayer;
import com.openmapper.annotations.DaoMethod;
import com.openmapper.annotations.Param;
import com.openmapper.model.operations.DmlOperation;

import java.util.List;

@DaoLayer
public interface UserDao {

    @DaoMethod
    List<UserSummary> findAllUsers();

    @DaoMethod
    UserSummary findUserById(@Param(name = "id") Integer id);

    @DaoMethod
    UserWithTasks findUserWithTasks(@Param(name = "id") Integer id);

    @DaoMethod(operation = DmlOperation.INSERT, returnKeys = true)
    int createUser(CreateUserRequest user);

    @DaoMethod(operation = DmlOperation.UPDATE)
    int updateUser(@Param(name = "id") Integer id,
                   @Param(name = "first_name") String firstName,
                   @Param(name = "last_name") String lastName,
                   @Param(name = "email") String email);

    @DaoMethod(operation = DmlOperation.DELETE)
    int deleteUser(@Param(name = "id") Integer id);
}
