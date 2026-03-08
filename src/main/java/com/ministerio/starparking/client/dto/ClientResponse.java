package com.ministerio.starparking.client.dto;

import com.ministerio.starparking.common.enums.DocumentType;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class ClientResponse {
    private Long id;
    private String fullName;
    private DocumentType documentType;
    private Long documentNumber;
    private String phoneNumber;
    private String email;
    private String address;
    private Boolean isActive;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
