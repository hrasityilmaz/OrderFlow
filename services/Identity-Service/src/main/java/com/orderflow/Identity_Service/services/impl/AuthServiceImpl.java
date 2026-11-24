package com.orderflow.Identity_Service.services.impl;

import org.springframework.stereotype.Service;

import com.orderflow.Identity_Service.dtos.request.LoginRequest;
import com.orderflow.Identity_Service.dtos.request.RegisterRequest;
import com.orderflow.Identity_Service.dtos.request.ResetPasswordRequest;
import com.orderflow.Identity_Service.dtos.response.AuthResponse;
import com.orderflow.Identity_Service.services.AuthService;

@Service
public class AuthServiceImpl implements AuthService {



	@Override
	public AuthResponse register(RegisterRequest request) {
		return null;
	}

	@Override
	public AuthResponse login(LoginRequest request) {
		return null;
	}

	@Override
	public AuthResponse refreshToken(String refreshToken) {
		return null;
	}

	@Override
	public void logout(String refreshToken) {
	}

	@Override
	public void forgotPassword(String email) {
	}

	@Override
	public void resetPassword(ResetPasswordRequest request) {
	}
}
