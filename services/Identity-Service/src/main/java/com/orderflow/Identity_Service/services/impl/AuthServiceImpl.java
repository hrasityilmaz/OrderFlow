package com.orderflow.Identity_Service.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orderflow.Identity_Service.dtos.request.LoginRequest;
import com.orderflow.Identity_Service.dtos.request.RegisterRequest;
import com.orderflow.Identity_Service.dtos.request.ResetPasswordRequest;
import com.orderflow.Identity_Service.dtos.response.AuthResponse;
import com.orderflow.Identity_Service.dtos.response.UserResponse;
import com.orderflow.Identity_Service.entities.Role;
import com.orderflow.Identity_Service.entities.UserEntity;
import com.orderflow.Identity_Service.entities.UserRole;
import com.orderflow.Identity_Service.enums.UserStatus;
import com.orderflow.Identity_Service.repositories.RoleRepository;
import com.orderflow.Identity_Service.repositories.UserRepository;
import com.orderflow.Identity_Service.repositories.UserRoleRepository;
import com.orderflow.Identity_Service.services.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(PasswordEncoder passwordEncoder,
            RoleRepository roleRepository,
            UserRepository userRepository,
            UserRoleRepository userRoleRepository){
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.userRoleRepository = userRoleRepository;
		this.passwordEncoder = passwordEncoder;
    }

    @Transactional
	@Override
	public UserResponse register(RegisterRequest request) {
    	if (userRepository.existsByEmailOrUsername(
                request.email(),
                request.username())) {

            throw new RuntimeException(
                    "Email or username already exists."
            );
        }

        Role customerRole = roleRepository.findByName("CUSTOMER")
                    .orElseThrow(() -> new RuntimeException("CUSTOMER role not found."));

        String passwordHash = passwordEncoder.encode(request.password());
        UserEntity user = new UserEntity(
                    request.email(),
                    request.username(),
                    passwordHash,
                    request.firstName(),
                    request.lastName(),
                    request.phoneNumber()
            );

            user.setStatus(UserStatus.PENDING_VERIFICATION);
            UserEntity savedUser = userRepository.save(user);

            UserRole userRole = new UserRole(
                       savedUser,
                       customerRole,
                       null
               );
            userRoleRepository.save(userRole);



            return new UserResponse(
                       savedUser.getId(),
                       savedUser.getEmail(),
                       savedUser.getUsername(),
                       savedUser.getFirstName(),
                       savedUser.getLastName(),
                       savedUser.getPhoneNumber(),
                       savedUser.isEmailVerified(),
                       savedUser.isPhoneVerified(),
                       savedUser.getStatus().name()
               );


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
