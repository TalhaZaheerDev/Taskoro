package com.taskoro.service.implem;

import com.taskoro.dto.WorkspaceRequest;
import com.taskoro.dto.WorkspaceResponse;
import com.taskoro.entity.Workspace;
import com.taskoro.repository.WorkspaceRepository;
import com.taskoro.service.WorkspaceService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkspaceServiceImplem implements WorkspaceService {

    private final WorkspaceRepository workspaceRepository;
    private final ModelMapper modelMapper;

    @Override
    public WorkspaceResponse create(WorkspaceRequest workspaceRequest) {
        Workspace workspace=modelMapper.map(workspaceRequest, Workspace.class);
        Workspace saved = workspaceRepository.save(workspace);
        return modelMapper.map(saved, WorkspaceResponse.class);
    }

    @Override
    public List<WorkspaceResponse> getAll() {
        return workspaceRepository.findAll()
                .stream()
                .map(workspace -> modelMapper.map(workspace, WorkspaceResponse.class))
                .toList();
    }

    @Override
    public WorkspaceResponse getByID(Long id) {
        Workspace w=workspaceRepository.findById(id).orElseThrow(()->new RuntimeException("Workspace not found"));
        return modelMapper.map(w, WorkspaceResponse.class);
    }

    @Override
    public WorkspaceResponse update(Long id, WorkspaceRequest workspaceRequest) {
        Workspace w=workspaceRepository.findById(id).orElseThrow(() -> new RuntimeException( "Workspace not found"));
        modelMapper.map(workspaceRequest, w);
        Workspace updated=workspaceRepository.save(w);
        return modelMapper.map(updated, WorkspaceResponse.class);
    }

    @Override
    public void delete(Long id) {
        Workspace w=workspaceRepository.findById(id).orElseThrow(()->new RuntimeException("Workspace not found"));
        workspaceRepository.deleteById(id);
    }
}
