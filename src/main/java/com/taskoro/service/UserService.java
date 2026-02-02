package com.taskoro.service;

import com.taskoro.dto.UserRequest;
import com.taskoro.dto.UserResponse;
import com.taskoro.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public UserResponse create(UserRequest user);
    public List<UserResponse> getAll();
    public UserResponse getById(Long id);
    public UserResponse update(Long id, UserRequest userRequest);
    public void delete(Long id);

}
