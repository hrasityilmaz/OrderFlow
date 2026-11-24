package com.orderflow.Identity_Service.dtos.response;

import java.time.Instant;

public record AuthResponse(
    String accessToken,
    String refreshToken,
    String tokenType,
    Instant expiresAt
) {}
