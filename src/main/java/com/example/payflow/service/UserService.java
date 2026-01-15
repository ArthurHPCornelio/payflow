package com.example.payflow.service;

import com.example.payflow.domain.Role;
import com.example.payflow.domain.User;
import com.example.payflow.dto.UserCreateRequest;
import com.example.payflow.dto.UserResponse;
import com.example.payflow.exception.AlreadyExistsException;
import com.example.payflow.exception.NotFoundException;
import com.example.payflow.mapper.UserMapper;
import com.example.payflow.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        this.validateUserDoesNotExist(userDTO);
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
        User user = repository.findById(id).orElseThrow(() -> new NotFoundException("User with id: " + id + " not found.", "USER_NOT_FOUND"));
        return mapper.toDTO(user);
    }

    private void validateUserDoesNotExist(UserCreateRequest userDTO){
        Optional<User> existingUser = repository.findByEmail(userDTO.getEmail());
        if (existingUser.isPresent()) throw new AlreadyExistsException("Email already registered", "EMAIL_ALREADY_REGISTERED");
    }
}
