package com.ministerio.starparking.subscription.service;

import com.ministerio.starparking.subscription.dto.SubscriptionRequest;
import com.ministerio.starparking.subscription.dto.SubscriptionResponse;
import com.ministerio.starparking.subscription.model.Subscription;
import com.ministerio.starparking.subscription.repository.SubscriptionRepository;
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
                .orElseThrow(() -> new EntityNotFoundException("Subscription not found: " + id)));
    }

    public SubscriptionResponse create(SubscriptionRequest request) {
        Subscription entity = new Subscription();
        applyRequest(entity, request);
        return toResponse(repository.save(entity));
    }

    public SubscriptionResponse update(Long id, SubscriptionRequest request) {
        Subscription entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subscription not found: " + id));
        applyRequest(entity, request);
        return toResponse(repository.save(entity));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) throw new EntityNotFoundException("Subscription not found: " + id);
        repository.deleteById(id);
    }

    private void applyRequest(Subscription entity, SubscriptionRequest request) {
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setPrice(request.getPrice());
        entity.setDayDuration(request.getDayDuration());
        entity.setIsActive(request.getIsActive());
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
