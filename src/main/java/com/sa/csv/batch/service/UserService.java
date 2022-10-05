package com.sa.csv.batch.service;

import com.sa.csv.batch.models.Response;
import com.sa.csv.batch.models.UserLoginDTO;
import com.sa.csv.batch.models.UserRequestDTO;

public interface UserService {
    Response login(UserLoginDTO userLoginDTO);
    Response save(UserRequestDTO userRequestDTO);

    Response getById(Long id);
}
