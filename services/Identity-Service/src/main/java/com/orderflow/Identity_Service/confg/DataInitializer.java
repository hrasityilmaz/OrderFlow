package com.orderflow.Identity_Service.confg;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.orderflow.Identity_Service.entities.Role;
import com.orderflow.Identity_Service.repositories.RoleRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {

        createRoleIfNotExists(
                "ADMIN",
                "System administrator",
                true
        );

        createRoleIfNotExists(
                "CUSTOMER",
                "Standard customer",
                true
        );

        createRoleIfNotExists(
                "SELLER",
                "Product seller",
                true
        );
    }

    @Transactional
    private void createRoleIfNotExists(
            String name,
            String description,
            boolean systemRole) {

        if (!roleRepository.existsByName(name)) {
            Role role = new Role(name, description, systemRole);
            roleRepository.save(role);
        }
    }
}
