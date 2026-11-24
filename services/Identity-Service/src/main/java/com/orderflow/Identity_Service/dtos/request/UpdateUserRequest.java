package com.orderflow.Identity_Service.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateUserRequest(
    @NotBlank
    @Size (max = 100)
    String firstName,

    @NotBlank
    @Size(max = 100)
    String lastName,

    @Size(max = 20)
    String phoneNumber
) {}
