package com.taskoro.service.implem;

import com.taskoro.dto.TaskRequest;
import com.taskoro.dto.TaskResponse;
import com.taskoro.entity.Project;
import com.taskoro.entity.Task;
import com.taskoro.entity.User;
import com.taskoro.repository.ProjectRepository;
import com.taskoro.repository.TaskRepository;
import com.taskoro.repository.UserRepository;
import com.taskoro.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.hibernate.usertype.UserVersionType;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImplem implements TaskService {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public TaskResponse create(TaskRequest taskRequest){

        User user=userRepository.findById(taskRequest.getAssignedUserId())
                .orElseThrow(()-> new RuntimeException("User not Found"));


        Project project=projectRepository.findById(taskRequest.getProjectId())
                .orElseThrow(()-> new RuntimeException("Project not found"));

//      Task task1=modelMapper.map(task, Task.class);

        Task task= new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setStatus(taskRequest.getStatus());
        task.setPriority(taskRequest.getPriority());
        task.setProject(project);
        task.setAssignedUser(user);
        Task saved=taskRepository.save(task);



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

    public TaskResponse update(Long id, TaskRequest request){
//        Task task=taskRepository.findById(id)
//                .orElseThrow(()->new RuntimeException("Task Not Found"));
//
//        modelMapper.map(taskRequest, task);
//
//        Task updated=taskRepository.save(task);
//        return modelMapper.map(updated, TaskResponse.class);

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setPriority(request.getPriority());

        // change project
        if(request.getProjectId() != null){
            Project project = projectRepository.findById(request.getProjectId())
                    .orElseThrow(() -> new RuntimeException("Project not found"));
            task.setProject(project);
        }

        // change assigned user
        if(request.getAssignedUserId() != null){
            User user = userRepository.findById(request.getAssignedUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            task.setAssignedUser(user);
        }

        Task saved = taskRepository.save(task);
        return modelMapper.map(saved, TaskResponse.class);
    }

    public void delete(Long id){
        Task task=taskRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Task Not Found"));
        taskRepository.deleteById(id);
    }





}
