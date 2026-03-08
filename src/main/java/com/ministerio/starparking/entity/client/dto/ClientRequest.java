package com.ministerio.starparking.entity.client.dto;

import com.ministerio.starparking.common.enums.DocumentType;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ClientRequest {

    @NotBlank
    @Size(max = 64)
    private String fullName;

    @NotNull
    private DocumentType documentType;

    @NotNull
    @Positive
    private Long documentNumber;

    @Size(max = 64)
    private String phoneNumber;

    @Email
    @Size(max = 128)
    private String email;

    @Size(max = 128)
    private String address;

    @NotNull
    private Boolean isActive;
}
