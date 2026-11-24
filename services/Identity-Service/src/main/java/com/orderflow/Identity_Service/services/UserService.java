package com.orderflow.Identity_Service.services;

import java.util.UUID;

import com.orderflow.Identity_Service.dtos.request.UpdateUserRequest;
import com.orderflow.Identity_Service.dtos.response.UserResponse;

public interface UserService {
    UserResponse getUserById(UUID id);
    Iterable<UserResponse> getAllUsers();
    UserResponse updateUser(UUID id, UpdateUserRequest request);
    void deleteUser(UUID id);
}
