package com.example.payflow.service;

import com.example.payflow.domain.Role;
import com.example.payflow.domain.User;
import com.example.payflow.dto.UserCreateRequest;
import com.example.payflow.dto.UserResponse;
import com.example.payflow.mapper.UserMapper;
import com.example.payflow.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository,
                       UserMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public UserResponse create(UserCreateRequest userDTO){
        User user = mapper.toEntity(userDTO);
        user.setRole(Role.USER);
        User userSaved = repository.save(user);

        return mapper.toDTO(userSaved);
    }

    @Transactional
    public List<UserResponse> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Transactional
    public UserResponse findById(Long id){
        User user = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return mapper.toDTO(user);
    }

}
