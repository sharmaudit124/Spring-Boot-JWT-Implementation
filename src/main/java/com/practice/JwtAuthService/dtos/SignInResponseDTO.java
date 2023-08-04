package com.practice.JwtAuthService.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInResponseDTO {
    private String email;
    private String accessToken;

    @Builder.Default
    private LocalDateTime localDateTime = LocalDateTime.now();
}
