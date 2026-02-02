package com.taskoro.dto;

import com.taskoro.entity.enums.Priority;
import com.taskoro.entity.enums.Status;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TaskRequest {
    private String title;
    private String description;
    private Status status;
    private Priority priority;
}
