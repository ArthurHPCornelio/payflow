package com.example.payflow.mapper;

import com.example.payflow.domain.User;
import com.example.payflow.dto.UserCreateRequest;
import com.example.payflow.dto.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponse toDTO(User user){
        return UserResponse
                .builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    public User toEntity(UserCreateRequest request){
        return User
                .builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }
}
