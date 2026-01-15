package com.example.payflow.dto;

import com.example.payflow.domain.Role;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private Role role;
}
