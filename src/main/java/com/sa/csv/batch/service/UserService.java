package com.sa.csv.batch.service;

import com.sa.csv.batch.model.LoginRequest;
import com.sa.csv.batch.model.LoginResponse;

public interface UserService {
    LoginResponse login(LoginRequest loginRequest);
}
