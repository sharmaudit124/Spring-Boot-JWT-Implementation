package com.practice.JwtAuthService.dtos;

import com.practice.JwtAuthService.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
