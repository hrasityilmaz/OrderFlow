package com.orderflow.Identity_Service.services.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orderflow.Identity_Service.dtos.request.UpdateUserRequest;
import com.orderflow.Identity_Service.dtos.response.UserResponse;
import com.orderflow.Identity_Service.entities.UserEntity;
import com.orderflow.Identity_Service.enums.UserStatus;
import com.orderflow.Identity_Service.repositories.UserRepository;
import com.orderflow.Identity_Service.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public  UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
    }

    @Transactional (readOnly = true)
	@Override
	public UserResponse getUserById(UUID id) {
        UserEntity user = getActiveUser(id);
        return toUserResponse(user);
	}

	@Transactional (readOnly = true)
	@Override
	public Iterable<UserResponse> getAllUsers() {
		return userRepository.findByStatusNot(UserStatus.DELETED)
		    .stream()
			.map(this::toUserResponse)
			.toList();
	}

	@Transactional
	@Override
	public UserResponse updateUser(UUID id, UpdateUserRequest request) {

		UserEntity user = getActiveUser(id);
		user.setFirstName(request.firstName());
		user.setLastName(request.lastName());
		user.setPhoneNumber(request.phoneNumber());

		return toUserResponse(userRepository.save(user));
	}

	@Transactional
	@Override
	public void deleteUser(UUID id) {
        UserEntity user = getActiveUser(id);
        user.setStatus(UserStatus.DELETED);
	}

	@Transactional (readOnly = true)
	private UserEntity getActiveUser(UUID id) {
        return userRepository.findByIdAndStatusNot(id, UserStatus.DELETED)
                .orElseThrow(() ->
                        new RuntimeException("User not found: " + id));
    }

	private UserResponse toUserResponse(UserEntity user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.isEmailVerified(),
                user.isPhoneVerified(),
                user.getStatus().name(),
                user.getCreatedAt()
        );
    }
}
