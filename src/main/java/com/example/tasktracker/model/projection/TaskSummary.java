package com.example.tasktracker.model.projection;

import com.openmapper.annotations.entity.Field;
import com.openmapper.annotations.entity.Model;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Model(primaryKey = "id")
public class TaskSummary {

    @Field
    private Integer id;

    @Field
    private String title;

    @Field
    private String status;

    @Field
    private String type;

    @Field
    private String tags;
}
