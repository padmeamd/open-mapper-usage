package com.example.tasktracker.service;

import com.example.tasktracker.dao.UserDao;
import com.example.tasktracker.model.projection.CreateUserRequest;
import com.example.tasktracker.model.projection.UserSummary;
import com.example.tasktracker.model.projection.UserWithTasks;
import com.openmapper.annotations.UseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@UseRepository
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public List<UserSummary> getAllUsers() {
        return userDao.findAllUsers();
    }

    public UserSummary getUserById(Integer id) {
        return userDao.findUserById(id);
    }

    public UserWithTasks getUserWithTasks(Integer id) {
        return userDao.findUserWithTasks(id);
    }

    public int createUser(CreateUserRequest request) {
        return userDao.createUser(request);
    }

    public int updateUser(Integer id, CreateUserRequest request) {
        return userDao.updateUser(id, request.getFirstName(), request.getLastName(), request.getEmail());
    }

    public int deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }
}
