package com.example.tasktracker.model.projection;

import com.openmapper.annotations.entity.Dto;
import com.openmapper.annotations.entity.Field;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Dto
public class CreateTaskRequest {

    @Field
    private String title;

    @Field
    private String description;

    @Field
    private String status;

    @Field
    private String type;

    @Field
    private String tags;

    @Field(name = "project_id")
    private Integer projectId;

    @Field(name = "owner_id")
    private Integer ownerId;

    @Field(name = "executor_id")
    private Integer executorId;

    @Field(name = "parent_id")
    private Integer parentId;
}
