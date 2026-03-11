package com.ministerio.starparking.entity.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateRequest {

    @NotBlank(message = "El campo nombre completo no puede estar vacío")
    @Size(max = 64, message = "El campo nombre completo no puede superar los 64 caracteres")
    private String fullName;

    @Email(message = "El formato del correo electrónico no es válido")
    @Size(max = 128, message = "El campo correo electrónico no puede superar los 128 caracteres")
    private String email;

    @NotBlank(message = "El campo contraseña no puede estar vacío")
    @Size(min = 8, max = 128, message = "El campo contraseña debe tener entre 8 y 128 caracteres")
    private String password;
}
