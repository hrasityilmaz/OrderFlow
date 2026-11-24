package com.orderflow.Identity_Service.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.orderflow.Identity_Service.entities.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {

}
