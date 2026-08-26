package com.example.tasktracker.model.projection;

import com.openmapper.annotations.entity.Field;
import com.openmapper.annotations.entity.Joined;
import com.openmapper.annotations.entity.Model;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@Model(primaryKey = "id")
public class TaskDetail {

    @Field
    private Integer id;

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

    @Field(name = "created_at")
    private Timestamp createdAt;

    @Field(name = "updated_at")
    private Timestamp updatedAt;

    @Joined(joinBy = "id", to = "parent_id")
    private List<TaskSummary> subTasks;
}
