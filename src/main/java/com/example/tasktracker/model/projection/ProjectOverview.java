package com.example.tasktracker.model.projection;

import com.openmapper.annotations.entity.Field;
import com.openmapper.annotations.entity.Model;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Model(primaryKey = "id")
public class ProjectOverview {

    @Field
    private Integer id;

    @Field
    private String name;

    @Field
    private String description;

    @Field(name = "total_tasks")
    private Integer totalTasks;

    @Field(name = "finished_tasks")
    private Integer finishedTasks;

    @Field(name = "unfinished_tasks")
    private Integer unfinishedTasks;

    @Field(name = "member_count")
    private Integer memberCount;
}
