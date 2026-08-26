package com.example.tasktracker.model.projection;

import com.openmapper.annotations.entity.Dto;
import com.openmapper.annotations.entity.Field;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Dto
public class CreateProjectRequest {

    @Field
    private String name;

    @Field
    private String description;
}
