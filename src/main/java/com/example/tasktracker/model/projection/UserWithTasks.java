package com.example.tasktracker.model.projection;

import com.openmapper.annotations.entity.Field;
import com.openmapper.annotations.entity.Joined;
import com.openmapper.annotations.entity.Model;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Model(primaryKey = "id")
public class UserWithTasks {

    @Field
    private Integer id;

    @Field(name = "first_name")
    private String firstName;

    @Field(name = "last_name")
    private String lastName;

    @Field
    private String email;

    @Joined(joinBy = "id", to = "owner_id")
    private List<TaskSummary> tasks;
}
