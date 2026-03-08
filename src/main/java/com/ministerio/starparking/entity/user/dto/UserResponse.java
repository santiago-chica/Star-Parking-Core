package com.ministerio.starparking.entity.user.dto;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class UserResponse {
    private Long id;
    private String fullName;
    private String email;
    private Boolean isActive;
    private OffsetDateTime lastSeen;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
