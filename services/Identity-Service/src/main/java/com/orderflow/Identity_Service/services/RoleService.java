package com.orderflow.Identity_Service.services;

import java.util.UUID;

import com.orderflow.Identity_Service.entities.Role;

public interface RoleService {
    Role createRole(Role role);
    Iterable<Role> getAllRoles();
    Role getRoleById(UUID id);
    void deleteRole(UUID id);
}
