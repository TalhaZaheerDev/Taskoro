package com.taskoro.service.implem;

import com.taskoro.dto.UserRequest;
import com.taskoro.dto.UserResponse;
import com.taskoro.entity.User;
import com.taskoro.exception.ResourceNotFoundException;
import com.taskoro.repository.UserRepository;
import com.taskoro.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImplem implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserResponse create(UserRequest user){
        User user1=modelMapper.map(user, User.class);
        User saved=userRepository.save(user1);
        return modelMapper.map(saved, UserResponse.class);
    }

    public Page<UserResponse> getAll(Pageable pageable){
        Page<User> page=userRepository.findAll(pageable);
        return page.map(user -> modelMapper.map(user, UserResponse.class));
    }

    public UserResponse getById(Long id){
        User user=userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("user Not Found"));
        return modelMapper.map(user, UserResponse.class);
    }

    public UserResponse update(Long id, UserRequest userRequest){
        User user=userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("user Not Found"));

        user.setName(userRequest.getName());

//        modelMapper.map(userRequest, user);

        User updated=userRepository.save(user);
        return modelMapper.map(updated, UserResponse.class);
    }

    public void delete(Long id){
        User user=userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("user Not Found"));
        userRepository.deleteById(id);
    }

}
