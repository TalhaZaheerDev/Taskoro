package com.taskoro.dto;

import com.taskoro.entity.enums.Priority;
import com.taskoro.entity.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TaskRequest {
    @NotBlank(message = "Title is required")
    private String title;
    @Size(max = 1000)
    private String description;
    @NotNull(message = "Status is required")
    private Status status;
    @NotNull(message = "Priority is required")
    private Priority priority;
    @NotNull(message = "Project id is required")
    private Long projectId;
    private Long assignedUserId;

}
