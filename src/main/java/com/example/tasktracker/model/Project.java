package com.example.tasktracker.model;

import com.openmapper.annotations.entity.Field;
import com.openmapper.annotations.entity.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Model(primaryKey = "id")
public class Project {

    @Field
    private Integer id;

    @Field
    private String name;

    @Field
    private String description;

    @Field(name = "created_at")
    private Timestamp createdAt;

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
