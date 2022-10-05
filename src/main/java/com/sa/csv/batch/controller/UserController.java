package com.sa.csv.batch.controller;
import com.sa.csv.batch.models.Response;
import com.sa.csv.batch.models.UserLoginDTO;
import com.sa.csv.batch.models.UserRequestDTO;
import com.sa.csv.batch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Response login(@Valid @RequestBody UserLoginDTO userLoginDTO) {
        return userService.login(userLoginDTO);
    }

    @GetMapping("/{id}")
    public Response getOne(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping
    public Response save(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        return userService.save(userRequestDTO);
    }


}
