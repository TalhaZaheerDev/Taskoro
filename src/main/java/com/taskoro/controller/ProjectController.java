package com.taskoro.controller;

import com.taskoro.dto.ProjectRequest;
import com.taskoro.dto.ProjectResponse;
import com.taskoro.dto.WorkspaceRequest;
import com.taskoro.dto.WorkspaceResponse;
import com.taskoro.entity.Project;
import com.taskoro.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService Service;

    @GetMapping
    public ResponseEntity<List<ProjectResponse>> getAll(){
        return ResponseEntity.ok(Service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponse> update(@PathVariable Long id, @RequestBody ProjectRequest Request){
        return ResponseEntity.ok(Service.update(id, Request));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectResponse> create(@RequestBody ProjectRequest Request){
        return new ResponseEntity<>(Service.create(Request), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(Service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
