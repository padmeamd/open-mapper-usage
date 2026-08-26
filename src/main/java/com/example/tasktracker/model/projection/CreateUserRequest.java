package com.example.tasktracker.model.projection;

import com.openmapper.annotations.entity.Dto;
import com.openmapper.annotations.entity.Field;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Dto
public class CreateUserRequest {

    @Field(name = "first_name")
    private String firstName;

    @Field(name = "last_name")
    private String lastName;

    @Field
    private String email;
}
