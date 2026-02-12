package com.taskoro.controller;

import com.taskoro.dto.TaskRequest;
import com.taskoro.dto.TaskResponse;
import com.taskoro.dto.WorkspaceRequest;
import com.taskoro.dto.WorkspaceResponse;
import com.taskoro.entity.Workspace;
import com.taskoro.service.WorkspaceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/workspaces")
public class WorkspaceController {
    private final WorkspaceService Service;


    @GetMapping
    public ResponseEntity<List<WorkspaceResponse>> getAll(){
        return ResponseEntity.ok(Service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkspaceResponse> update(@Valid @PathVariable Long id, @RequestBody WorkspaceRequest Request){
        return ResponseEntity.ok(Service.update(id, Request));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkspaceResponse> create(@Valid @RequestBody WorkspaceRequest Request){
        return new ResponseEntity<>(Service.create(Request), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<WorkspaceResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(Service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
