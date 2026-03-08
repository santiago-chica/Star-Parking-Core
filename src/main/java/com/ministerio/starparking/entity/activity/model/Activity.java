package com.ministerio.starparking.entity.activity.model;

import com.ministerio.starparking.common.enums.ActionType;
import com.ministerio.starparking.entity.user.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ActionType actionType;

    @Column(length = 128)
    private String detail;

    @Column(length = 45, nullable = false)
    private String ipAddress;

    @CreationTimestamp
    @Column(nullable = false)
    private OffsetDateTime createdAt;

}
