package com.ministerio.starparking.entity.activity.service;

import com.ministerio.starparking.entity.activity.dto.ActivityRequest;
import com.ministerio.starparking.entity.activity.dto.ActivityResponse;
import com.ministerio.starparking.entity.activity.model.Activity;
import com.ministerio.starparking.entity.activity.repository.ActivityRepository;
import com.ministerio.starparking.entity.user.model.User;
import com.ministerio.starparking.entity.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository repository;
    private final UserRepository userRepository;

    public List<ActivityResponse> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public ActivityResponse findById(Long id) {
        return toResponse(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activity not found: " + id)));
    }

    public ActivityResponse create(ActivityRequest request) {
        Activity entity = new Activity();
        applyRequest(entity, request);
        return toResponse(repository.save(entity));
    }

    public ActivityResponse update(Long id, ActivityRequest request) {
        Activity entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activity not found: " + id));
        applyRequest(entity, request);
        return toResponse(repository.save(entity));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) throw new EntityNotFoundException("Activity not found: " + id);
        repository.deleteById(id);
    }

    private void applyRequest(Activity entity, ActivityRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + request.getUserId()));
        entity.setUser(user);
        entity.setActionType(request.getActionType());
        entity.setDetail(request.getDetail());
        entity.setIpAddress(request.getIpAddress());
    }

    private ActivityResponse toResponse(Activity entity) {
        return ActivityResponse.builder()
                .id(entity.getId())
                .userId(entity.getUser() != null ? entity.getUser().getId() : null)
                .userFullName(entity.getUser() != null ? entity.getUser().getFullName() : null)
                .actionType(entity.getActionType())
                .detail(entity.getDetail())
                .ipAddress(entity.getIpAddress())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
