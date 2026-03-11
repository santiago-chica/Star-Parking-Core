package com.ministerio.starparking.entity.subscriptionlog.service;

import com.ministerio.starparking.entity.client.model.Client;
import com.ministerio.starparking.entity.client.repository.ClientRepository;
import com.ministerio.starparking.entity.subscription.model.Subscription;
import com.ministerio.starparking.entity.subscription.repository.SubscriptionRepository;
import com.ministerio.starparking.entity.subscriptionlog.dto.SubscriptionLogCreateRequest;
import com.ministerio.starparking.entity.subscriptionlog.dto.SubscriptionLogUpdateRequest;
import com.ministerio.starparking.entity.subscriptionlog.dto.SubscriptionLogResponse;
import com.ministerio.starparking.entity.subscriptionlog.model.SubscriptionLog;
import com.ministerio.starparking.entity.subscriptionlog.repository.SubscriptionLogRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionLogService {

    private final SubscriptionLogRepository repository;
    private final ClientRepository clientRepository;
    private final SubscriptionRepository subscriptionRepository;

    public List<SubscriptionLogResponse> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public SubscriptionLogResponse findById(Long id) {
        return toResponse(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SubscriptionLog not found: " + id)));
    }

    public SubscriptionLogResponse create(SubscriptionLogCreateRequest request) {
        SubscriptionLog entity = new SubscriptionLog();
        Client client = clientRepository.findById(request.getClientId())
                .orElseThrow(() -> new EntityNotFoundException("Client not found: " + request.getClientId()));
        Subscription subscription = subscriptionRepository.findById(request.getSubscriptionId())
                .orElseThrow(() -> new EntityNotFoundException("Subscription not found: " + request.getSubscriptionId()));
        entity.setClient(client);
        entity.setSubscription(subscription);
        entity.setStartsAt(request.getStartsAt());
        entity.setEndsAt(request.getStartsAt().plusDays(subscription.getDayDuration().longValue()));
        entity.setSubscriptionStatus(request.getSubscriptionStatus());
        return toResponse(repository.save(entity));
    }

    public SubscriptionLogResponse update(Long id, SubscriptionLogUpdateRequest request) {
        SubscriptionLog entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SubscriptionLog not found: " + id));
        entity.setEndsAt(request.getEndsAt());
        entity.setSubscriptionStatus(request.getSubscriptionStatus());
        return toResponse(repository.save(entity));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) throw new EntityNotFoundException("SubscriptionLog not found: " + id);
        repository.deleteById(id);
    }

    private SubscriptionLogResponse toResponse(SubscriptionLog entity) {
        SubscriptionLogResponse.SubscriptionInfo subInfo = entity.getSubscription() != null
                ? SubscriptionLogResponse.SubscriptionInfo.builder()
                        .id(entity.getSubscription().getId())
                        .name(entity.getSubscription().getName())
                        .price(entity.getSubscription().getPrice())
                        .dayDuration(entity.getSubscription().getDayDuration())
                        .build()
                : null;
        return SubscriptionLogResponse.builder()
                .id(entity.getId())
                .clientId(entity.getClient() != null ? entity.getClient().getId() : null)
                .clientName(entity.getClient() != null ? entity.getClient().getFullName() : null)
                .subscription(subInfo)
                .startsAt(entity.getStartsAt())
                .endsAt(entity.getEndsAt())
                .subscriptionStatus(entity.getSubscriptionStatus())
                .active(entity.isActive())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
