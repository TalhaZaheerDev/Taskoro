package com.taskoro.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProjectRequest {
    @NotBlank
    private String name;
    @NotNull
    private Long workspaceId;
}
