package com.taskoro.service;

import com.taskoro.dto.TaskRequest;
import com.taskoro.dto.TaskResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    public TaskResponse create(TaskRequest task);

//    public List<TaskResponse> getAll();
    public Page<TaskResponse> getAll(Pageable pageable);

    public TaskResponse getById(Long id);
    public TaskResponse update(Long id, TaskRequest taskRequest);
    public void delete(Long id);
}
