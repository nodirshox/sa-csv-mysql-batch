package com.sa.csv.batch.controller;

import com.sa.csv.batch.model.LoginRequest;
import com.sa.csv.batch.model.Response;
import com.sa.csv.batch.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Response response = new Response(userService.login(loginRequest), true);
        return ResponseEntity.ok().body(response);
    }
}
