package com.taskoro.service;

import com.taskoro.dto.ProjectRequest;
import com.taskoro.dto.ProjectResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    public ProjectResponse create(ProjectRequest projectRequest);
    public Page<ProjectResponse> getAll(Pageable pageable);
    public ProjectResponse getById(Long id);
    public ProjectResponse update(Long Id, ProjectRequest projectRequest);
    public void delete(Long id);
}
