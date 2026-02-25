package com.taskoro.service;

import com.taskoro.dto.WorkspaceRequest;
import com.taskoro.dto.WorkspaceResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkspaceService {
    public WorkspaceResponse create(WorkspaceRequest workspaceRequest);
    public Page<WorkspaceResponse> getAll(Pageable pageable);
    public WorkspaceResponse getById(Long id);
    public WorkspaceResponse update(Long id, WorkspaceRequest workspaceRequest);
    public void delete(Long id);
}
