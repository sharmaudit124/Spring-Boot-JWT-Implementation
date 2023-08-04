package com.practice.JwtAuthService.services;

import com.practice.JwtAuthService.dtos.SignInRequestDTO;
import com.practice.JwtAuthService.dtos.SignInResponseDTO;
import com.practice.JwtAuthService.dtos.SignUpRequestDTO;
import com.practice.JwtAuthService.dtos.SignUpResponseDTO;

public interface AuthenticationService {
    /**
     * to sign up the user
     * @param signUpRequestDTO
     * @return
     */
    SignUpResponseDTO signUp(SignUpRequestDTO signUpRequestDTO);

    /**
     * to signIn user
     * @param signInRequestDTO
     * @return
     */
    SignInResponseDTO signIn(SignInRequestDTO signInRequestDTO);
}
