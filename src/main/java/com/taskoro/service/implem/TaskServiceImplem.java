package com.taskoro.service.implem;

import com.taskoro.dto.TaskRequest;
import com.taskoro.dto.TaskResponse;
import com.taskoro.entity.Task;
import com.taskoro.repository.TaskRepository;
import com.taskoro.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImplem implements TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;


    public TaskResponse create(TaskRequest task){
       Task task1=modelMapper.map(task, Task.class);
       Task saved=taskRepository.save(task1);
        return modelMapper.map(saved, TaskResponse.class);
    }

    public List<TaskResponse> getAll(){
        return taskRepository.findAll()
                .stream()
                .map(task -> modelMapper.map(task, TaskResponse.class))
                .toList();
    }

    public TaskResponse getById(Long id){
        Task task=taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task Not Found"));
        return modelMapper.map(task, TaskResponse.class);
    }

    public TaskResponse update(Long id, TaskRequest taskRequest){
        Task task=taskRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Task Not Found"));

        modelMapper.map(taskRequest, task);

        Task updated=taskRepository.save(task);
        return modelMapper.map(updated, TaskResponse.class);
    }

    public void delete(Long id){
        Task task=taskRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Task Not Found"));
        taskRepository.deleteById(id);
    }





}
