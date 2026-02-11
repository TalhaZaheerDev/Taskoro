package com.taskoro.service.implem;

import com.taskoro.dto.ProjectRequest;
import com.taskoro.dto.ProjectResponse;
import com.taskoro.entity.Project;
import com.taskoro.entity.Workspace;
import com.taskoro.repository.ProjectRepository;
import com.taskoro.repository.WorkspaceRepository;
import com.taskoro.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImplem implements ProjectService {
    private final ProjectRepository projectRepository;
    private final WorkspaceRepository workspaceRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProjectResponse create(ProjectRequest projectRequest) {

        Workspace workspace=workspaceRepository
                .findById(projectRequest.getWorkspaceId())
                .orElseThrow(() -> new RuntimeException("Workspace not Found"));

//        Project project = modelMapper.map(projectRequest, Project.class);

        Project project = new Project();
        project.setName(projectRequest.getName());
        project.setWorkspace(workspace);

        Project saved=projectRepository.save(project);
        return modelMapper.map(saved , ProjectResponse.class);
    }

    @Override
    public List<ProjectResponse> getAll() {
        return projectRepository.findAll()
                .stream()
                .map(project -> modelMapper.map(project, ProjectResponse.class))
                .toList();
    }

    @Override
    public ProjectResponse getById(Long id) {
        Project project=projectRepository.findById(id).orElseThrow(()->new RuntimeException("Project not found"));
        return modelMapper.map(project, ProjectResponse.class);
    }

    @Override
    public ProjectResponse update(Long Id, ProjectRequest projectRequest) {
        Project project=projectRepository.findById(Id).orElseThrow(()-> new RuntimeException("Project Not Found"));
//        modelMapper.map(projectRequest, project);
        project.setName(projectRequest.getName());

        if(projectRequest.getWorkspaceId() != null){
            Workspace ws = workspaceRepository.findById(projectRequest.getWorkspaceId())
                    .orElseThrow(() -> new RuntimeException("Workspace not Found"));
            project.setWorkspace(ws);
        }

        Project updated=projectRepository.save(project);
        return modelMapper.map(updated, ProjectResponse.class);
    }

    @Override
    public void delete(Long id) {
        projectRepository.findById(id).orElseThrow(()-> new RuntimeException("Project Not Found"));
        projectRepository.deleteById(id);
    }
}
