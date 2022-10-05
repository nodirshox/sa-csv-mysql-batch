package com.sa.csv.batch.service;

import com.sa.csv.batch.model.LoginRequest;
import com.sa.csv.batch.model.LoginResponse;
import com.sa.csv.batch.model.RefreshTokenRequest;

public interface UserService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
