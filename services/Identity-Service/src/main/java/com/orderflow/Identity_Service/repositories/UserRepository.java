package com.orderflow.Identity_Service.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderflow.Identity_Service.entities.UserEntity;
import com.orderflow.Identity_Service.enums.UserStatus;

public interface UserRepository extends JpaRepository<UserEntity, UUID>  {
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmailOrUsername(String email, String username);
    Optional<UserEntity> findByIdAndStatusNot(UUID id, UserStatus status);
    List<UserEntity> findByStatusNot(UserStatus status);
}
