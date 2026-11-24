package com.orderflow.Identity_Service.dtos.response;

import java.util.UUID;

public record UserResponse(
    UUID id,
    String email,
    String username,
    String firstName,
    String lastName,
    String phoneNumber,
    boolean emailVerified,
    boolean phoneVerified,
    String status
) {}
