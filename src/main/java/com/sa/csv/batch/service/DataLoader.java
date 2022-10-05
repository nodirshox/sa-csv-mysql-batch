package com.sa.csv.batch.service;

import com.sa.csv.batch.entity.Role;
import com.sa.csv.batch.entity.User;
import com.sa.csv.batch.repository.RoleRepository;
import com.sa.csv.batch.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        Role role = new Role("USER");
        if (roleRepository.findAll().size() == 0) roleRepository.save(role);
        if (userRepository.findAll().size() == 0)
            userRepository.save(new User("admin", "John", "Smith", "$2a$10$OHELRGf8YTBwRYYE8F3v8eCL4fwQZJaK9qTg4VmBXmYnxGIy2b4NG", Collections.singleton(role)));
    }
}