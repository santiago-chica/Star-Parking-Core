package com.ministerio.starparking.entity.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateRequest {

    @NotBlank
    @Size(max = 64)
    private String fullName;

    @Email
    @Size(max = 128)
    private String email;

    @NotBlank
    @Size(min = 8, max = 128)
    private String password;
}
