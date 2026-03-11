package com.ministerio.starparking.entity.client.dto;

import com.ministerio.starparking.common.enums.DocumentType;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ClientCreateRequest {

    @NotBlank(message = "El campo nombre completo no puede estar vacío")
    @Size(max = 64, message = "El campo nombre completo no puede superar los 64 caracteres")
    private String fullName;

    @NotNull(message = "El campo documentType es obligatorio")
    private DocumentType documentType;

    @NotNull(message = "El campo número de documento es obligatorio")
    @Positive(message = "El campo número de documento debe ser un número positivo")
    private Long documentNumber;

    @Size(max = 64, message = "El campo número de teléfono no puede superar los 64 caracteres")
    private String phoneNumber;

    @Email(message = "El formato del correo electrónico no es válido")
    @Size(max = 128, message = "El campo correo electrónico no puede superar los 128 caracteres")
    private String email;

    @Size(max = 128, message = "El campo dirección no puede superar los 128 caracteres")
    private String address;
}
