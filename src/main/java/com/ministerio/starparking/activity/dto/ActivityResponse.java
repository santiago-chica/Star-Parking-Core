package com.ministerio.starparking.activity.dto;

import com.ministerio.starparking.common.enums.ActionType;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class ActivityResponse {
    private Long id;
    private Long userId;
    private String userFullName;
    private ActionType actionType;
    private String detail;
    private String ipAddress;
    private OffsetDateTime createdAt;
}
