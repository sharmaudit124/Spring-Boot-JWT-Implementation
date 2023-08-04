package com.practice.JwtAuthService.services;

import com.practice.JwtAuthService.dtos.SignInRequestDTO;
import com.practice.JwtAuthService.dtos.SignInResponseDTO;
import com.practice.JwtAuthService.dtos.SignUpRequestDTO;
import com.practice.JwtAuthService.dtos.SignUpResponseDTO;
import com.practice.JwtAuthService.entities.User;
import com.practice.JwtAuthService.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final JwtServiceImpl jwtServiceImpl;
    @Autowired
    private final AuthenticationManager authenticationManager;

    /**
     * sign up service with encrypted password
     * @param signUpRequestDTO
     * @return
     */
    @Override
    public SignUpResponseDTO signUp(SignUpRequestDTO signUpRequestDTO) {
        User user = User.builder()
                .firstName(signUpRequestDTO.getFirstName())
                .lastName(signUpRequestDTO.getLastName())
                .email(signUpRequestDTO.getEmail())
                .password(passwordEncoder.encode(signUpRequestDTO.getPassword()))
                .role(signUpRequestDTO.getRole()).build();
        userRepository.save(user);
        return SignUpResponseDTO.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    /**
     * sign in authentication service method
     * @param signInRequestDTO
     * @return
     */
    @Override
    public SignInResponseDTO signIn(SignInRequestDTO signInRequestDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequestDTO.getEmail(), signInRequestDTO.getPassword()));
        User user = userRepository.findByEmail(signInRequestDTO.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtServiceImpl.generateToken(user);
        return SignInResponseDTO.builder()
                .email(user.getEmail())
                .accessToken(jwt)
                .build();
    }
}
