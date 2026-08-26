package com.example.tasktracker.model.projection;

import com.openmapper.annotations.entity.Field;
import com.openmapper.annotations.entity.Model;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Model(primaryKey = "id")
public class UserSummary {

    @Field
    private Integer id;

    @Field(name = "first_name")
    private String firstName;

    @Field(name = "last_name")
    private String lastName;

    @Field
    private String email;
}
