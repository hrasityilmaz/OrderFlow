package com.orderflow.Identity_Service.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ResetPasswordRequest(
    @NotBlank
    String resetToken,
    @NotBlank
    @Size (min = 8, max = 100)
    String newPassword,
    @NotBlank
    String confirmPassword
) {}
