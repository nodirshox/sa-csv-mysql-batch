package com.sa.csv.batch.service.impl;

import com.sa.csv.batch.entity.Role;
import com.sa.csv.batch.entity.User;
import com.sa.csv.batch.models.*;
import com.sa.csv.batch.repository.RoleRepository;
import com.sa.csv.batch.repository.UserRepository;
import com.sa.csv.batch.service.JwtService;
import com.sa.csv.batch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private JwtService jwtService;

    @Override
    public Response login(UserLoginDTO userLoginDTO) {
        User user = userRepository.findByUsername(userLoginDTO.getUsername());
        if (user == null)
            return new Response(false, "User not found!", null);
        if (!bCryptPasswordEncoder.matches(userLoginDTO.getPassword(), user.getPassword()))
            return new Response(false, "Bad Credentials!", null);
        UserResponse userResponse = new UserResponse(user.getId(), user.getUsername(), user.getFirstname(), user.getLastname());
        String token = jwtService.generateJwtToken(userResponse);
        return new Response(token, true);
    }

    @Override
    public Response save(UserRequestDTO userRequestDTO) {
        Role role = roleRepository.findByName(userRequestDTO.getRoleName());
        if (role == null)
            return new Response(false, "Role not found!", null);
        if (userRepository.existsByUsername(userRequestDTO.getUsername()))
            return new Response(false, "Username is already taken!", null);
        User user = userRepository.save(new User(userRequestDTO.getUsername(), userRequestDTO.getFirstname(), userRequestDTO.getLastname(), bCryptPasswordEncoder.encode(userRequestDTO.getPassword()),
                Collections.singleton(role)));
        return new Response(true, "User saved successfully!", parseUserToDto(user));
    }

    @Override
    public Response getById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null)
            return new Response(false, "User not found!", null);
        return new Response(parseUserToDto(user), true);
    }


    private UserDTO parseUserToDto(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getFirstname(), user.getLastname());
    }
}
