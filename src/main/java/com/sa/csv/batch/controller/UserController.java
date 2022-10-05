package com.sa.csv.batch.controller;

import com.sa.csv.batch.model.LoginRequest;
import com.sa.csv.batch.model.LoginResponse;
import com.sa.csv.batch.model.RefreshTokenRequest;
import com.sa.csv.batch.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = userService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return userService.refreshToken(refreshTokenRequest);
    }

}
