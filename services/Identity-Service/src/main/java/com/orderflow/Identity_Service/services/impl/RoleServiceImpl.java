package com.orderflow.Identity_Service.services.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orderflow.Identity_Service.entities.Role;
import com.orderflow.Identity_Service.repositories.RoleRepository;
import com.orderflow.Identity_Service.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
    }

    @Transactional
	@Override
	public Role createRole(Role role) {
	    return roleRepository.save(role);
	}

	@Transactional ( readOnly = true )
	@Override
	public Iterable<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@Transactional ( readOnly = true )
	@Override
	public Role getRoleById(UUID id) {
		return roleRepository.findById(id)
		    .orElseThrow(() -> new RuntimeException("Role not found: " + id));
	}

	@Transactional
	@Override
	public void deleteRole(UUID id) {
	    roleRepository.deleteById(id);
	}


}
