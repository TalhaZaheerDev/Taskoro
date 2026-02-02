package com.taskoro.service;

import com.taskoro.dto.WorkspaceRequest;
import com.taskoro.dto.WorkspaceResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkspaceService {
    public WorkspaceResponse create(WorkspaceRequest workspaceRequest);
    public List<WorkspaceResponse> getAll();
    public WorkspaceResponse getByID(Long id);
    public WorkspaceResponse update(Long id, WorkspaceRequest workspaceRequest);
    public void delete(Long id);
}
