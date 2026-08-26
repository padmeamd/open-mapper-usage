package com.example.tasktracker.model;

import com.openmapper.annotations.entity.Field;
import com.openmapper.annotations.entity.Joined;
import com.openmapper.annotations.entity.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Model(primaryKey = "id")
public class User {

    @Field
    private Integer id;

    @Field(name = "first_name")
    private String firstName;

    @Field(name = "last_name")
    private String lastName;

    @Field
    private String email;

    @Field(name = "created_at")
    private Timestamp createdAt;

    @Joined(joinBy = "id", to = "owner_id")
    private List<Task> tasks;

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
