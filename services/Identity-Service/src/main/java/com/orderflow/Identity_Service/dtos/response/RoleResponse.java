package com.orderflow.Identity_Service.dtos.response;

import java.util.UUID;

public record RoleResponse(
    UUID id,
    String name,
    String description,
    boolean active,
    boolean systemRole
) {}
