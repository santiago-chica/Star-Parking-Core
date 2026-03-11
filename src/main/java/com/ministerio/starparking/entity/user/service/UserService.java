package com.ministerio.starparking.entity.user.service;

import com.ministerio.starparking.entity.user.dto.UserCreateRequest;
import com.ministerio.starparking.entity.user.dto.UserUpdateRequest;
import com.ministerio.starparking.entity.user.dto.UserResponse;
import com.ministerio.starparking.entity.user.model.User;
import com.ministerio.starparking.entity.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<UserResponse> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public UserResponse findById(Long id) {
        return toResponse(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + id)));
    }

    public UserResponse create(UserCreateRequest request) {
        User entity = new User();
        entity.setFullName(request.getFullName());
        entity.setEmail(request.getEmail());
        entity.setPasswordHash(request.getPassword());
        entity.setIsActive(true);
        return toResponse(repository.save(entity));
    }

    public UserResponse update(Long id, UserUpdateRequest request) {
        User entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + id));
        entity.setFullName(request.getFullName());
        entity.setEmail(request.getEmail());
        entity.setIsActive(request.getIsActive());
        return toResponse(repository.save(entity));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) throw new EntityNotFoundException("User not found: " + id);
        repository.deleteById(id);
    }

    private UserResponse toResponse(User entity) {
        return UserResponse.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .email(entity.getEmail())
                .passwordHash(entity.getPasswordHash())
                .isActive(entity.getIsActive())
                .lastSeen(entity.getLastSeen())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
