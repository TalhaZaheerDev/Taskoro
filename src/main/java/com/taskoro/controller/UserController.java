package com.taskoro.controller;

import com.taskoro.dto.UserRequest;
import com.taskoro.dto.UserResponse;
import com.taskoro.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest userRequest){
        return new ResponseEntity<>(userService.create(userRequest), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getById(id));
    }
    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAll(Pageable pageable){
        return ResponseEntity.ok(userService.getAll(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@Valid @PathVariable Long id, @RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userService.update(id, userRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
