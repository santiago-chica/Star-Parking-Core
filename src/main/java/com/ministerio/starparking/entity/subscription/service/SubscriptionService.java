package com.ministerio.starparking.entity.subscription.service;

import com.ministerio.starparking.entity.subscription.dto.SubscriptionCreateRequest;
import com.ministerio.starparking.entity.subscription.dto.SubscriptionUpdateRequest;
import com.ministerio.starparking.entity.subscription.dto.SubscriptionResponse;
import com.ministerio.starparking.entity.subscription.model.Subscription;
import com.ministerio.starparking.entity.subscription.repository.SubscriptionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository repository;

    public List<SubscriptionResponse> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public SubscriptionResponse findById(Long id) {
        return toResponse(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró ninguna suscripción con el ID: " + id)));
    }

    public SubscriptionResponse create(SubscriptionCreateRequest request) {
        Subscription entity = new Subscription();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setPrice(request.getPrice());
        entity.setDayDuration(request.getDayDuration());
        entity.setIsActive(request.getIsActive() != null ? request.getIsActive() : true);
        return toResponse(repository.save(entity));
    }

    public SubscriptionResponse update(Long id, SubscriptionUpdateRequest request) {
        Subscription entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró ninguna suscripción con el ID: " + id));
        if (request.getName() != null) entity.setName(request.getName());
        if (request.getDescription() != null) entity.setDescription(request.getDescription());
        if (request.getPrice() != null) entity.setPrice(request.getPrice());
        if (request.getDayDuration() != null) entity.setDayDuration(request.getDayDuration());
        if (request.getIsActive() != null) entity.setIsActive(request.getIsActive());
        return toResponse(repository.save(entity));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) throw new EntityNotFoundException("No se encontró ninguna suscripción con el ID: " + id);
        repository.deleteById(id);
    }

    private SubscriptionResponse toResponse(Subscription entity) {
        return SubscriptionResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .dayDuration(entity.getDayDuration())
                .isActive(entity.getIsActive())
                .build();
    }
}
