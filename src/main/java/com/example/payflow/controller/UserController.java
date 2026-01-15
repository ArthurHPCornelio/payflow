package com.example.payflow.controller;

import com.example.payflow.dto.UserCreateRequest;
import com.example.payflow.dto.UserResponse;
import com.example.payflow.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(
            @RequestBody @Valid UserCreateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

}
