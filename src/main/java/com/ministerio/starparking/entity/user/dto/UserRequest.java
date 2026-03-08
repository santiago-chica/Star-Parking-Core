package com.ministerio.starparking.entity.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class UserRequest {

    @NotBlank
    @Size(max = 64)
    private String fullName;

    @Email
    @Size(max = 128)
    private String email;

    @NotBlank
    private String passwordHash;

    @NotNull
    private Boolean isActive;

    @NotNull
    private OffsetDateTime lastSeen;
}
