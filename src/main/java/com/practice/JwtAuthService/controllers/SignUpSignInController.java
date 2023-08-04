package com.practice.JwtAuthService.controllers;

import com.practice.JwtAuthService.dtos.SignInRequestDTO;
import com.practice.JwtAuthService.dtos.SignInResponseDTO;
import com.practice.JwtAuthService.dtos.SignUpRequestDTO;
import com.practice.JwtAuthService.dtos.SignUpResponseDTO;
import com.practice.JwtAuthService.services.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class SignUpSignInController {

    @Autowired
    private AuthenticationServiceImpl authenticationService;

    /**
     * signUp method
     * @param signUpRequestDTO
     * @return
     */
    @PostMapping("/signUp")
    public ResponseEntity<SignUpResponseDTO> signUpPerson(@RequestBody SignUpRequestDTO signUpRequestDTO) {
        SignUpResponseDTO signUpResponseDTO = authenticationService.signUp(signUpRequestDTO);
        return new ResponseEntity<>(signUpResponseDTO, HttpStatus.CREATED);
    }

    /**
     * signIn method
     * @param signInRequestDTO
     * @return
     */
    @PostMapping("/signIn")
    public ResponseEntity<SignInResponseDTO> signInPerson(@RequestBody SignInRequestDTO signInRequestDTO) {
        SignInResponseDTO signInResponseDTO = authenticationService.signIn(signInRequestDTO);
        return new ResponseEntity<>(signInResponseDTO, HttpStatus.OK);
    }
}
