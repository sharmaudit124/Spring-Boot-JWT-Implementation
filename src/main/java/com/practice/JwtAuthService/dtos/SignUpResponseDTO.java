package com.practice.JwtAuthService.dtos;

import com.practice.JwtAuthService.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpResponseDTO {
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
}
