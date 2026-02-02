package com.taskoro.service;

import com.taskoro.dto.ProjectRequest;
import com.taskoro.dto.ProjectResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    public ProjectResponse create(ProjectRequest projectRequest);
    public List<ProjectResponse> getAll();
    public ProjectResponse getById(Long id);
    public ProjectResponse update(Long Id, ProjectRequest projectRequest);
    public void delete(Long id);
}
