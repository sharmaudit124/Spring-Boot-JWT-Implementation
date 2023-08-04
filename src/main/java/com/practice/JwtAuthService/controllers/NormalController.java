package com.practice.JwtAuthService.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NormalController {
    /**
     * get mapping for normal user
     * can have access even without token
     * @return
     */
    @GetMapping("/auth/normal")
    public ResponseEntity<String> sayNoAuth() {
        return new ResponseEntity<>("No Auth", HttpStatus.OK);
    }

}
