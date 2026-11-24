package com.orderflow.Identity_Service.services;

import com.orderflow.Identity_Service.dtos.request.LoginRequest;
import com.orderflow.Identity_Service.dtos.request.RegisterRequest;
import com.orderflow.Identity_Service.dtos.request.ResetPasswordRequest;
import com.orderflow.Identity_Service.dtos.response.AuthResponse;
import com.orderflow.Identity_Service.dtos.response.UserResponse;

public interface AuthService {
    UserResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
    AuthResponse refreshToken(String refreshToken);
    void logout(String refreshToken);
    void forgotPassword(String email);
    void resetPassword(ResetPasswordRequest request);
}
