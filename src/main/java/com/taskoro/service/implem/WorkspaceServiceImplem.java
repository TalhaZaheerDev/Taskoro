package com.taskoro.service.implem;

import com.taskoro.dto.WorkspaceRequest;
import com.taskoro.dto.WorkspaceResponse;
import com.taskoro.entity.User;
import com.taskoro.entity.Workspace;
import com.taskoro.exception.ResourceNotFoundException;
import com.taskoro.repository.UserRepository;
import com.taskoro.repository.WorkspaceRepository;
import com.taskoro.service.WorkspaceService;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkspaceServiceImplem implements WorkspaceService {

    private final WorkspaceRepository workspaceRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public WorkspaceResponse create(WorkspaceRequest workspaceRequest) {

        User user=userRepository.findById(workspaceRequest.getUserId())
                .orElseThrow(()-> new ResourceNotFoundException("User Not Found"));

//        Workspace workspace=modelMapper.map(workspaceRequest, Workspace.class);
        Workspace workspace=new Workspace();
        workspace.setName(workspaceRequest.getName());
        workspace.setUser(user);
        Workspace saved = workspaceRepository.save(workspace);
        return modelMapper.map(saved, WorkspaceResponse.class);
    }

    @Override
    public Page<WorkspaceResponse> getAll(Pageable pageable) {
        Page<Workspace> page= workspaceRepository.findAll(pageable);
        return page.map(workspace -> modelMapper.map(workspace, WorkspaceResponse.class));
    }

    @Override
    public WorkspaceResponse getById(Long id) {
        Workspace w=workspaceRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Workspace not found"));
        return modelMapper.map(w, WorkspaceResponse.class);
    }

    @Override
    public WorkspaceResponse update(Long id, WorkspaceRequest workspaceRequest) {
        Workspace ws=workspaceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException( "Workspace not found"));
//        modelMapper.map(workspaceRequest, w);
//        Workspace updated=workspaceRepository.save(w);

        ws.setName(workspaceRequest.getName());

        if(workspaceRequest.getUserId() != null){
            User u = userRepository.findById(workspaceRequest.getUserId())
                    .orElseThrow(() -> new ResourceNotFoundException( "User not found"));
            ws.setUser(u);
        }

        Workspace updated = workspaceRepository.save(ws);


        return modelMapper.map(updated, WorkspaceResponse.class);
    }

    @Override
    public void delete(Long id) {
        Workspace w=workspaceRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Workspace not found"));
        workspaceRepository.deleteById(id);
    }
}
