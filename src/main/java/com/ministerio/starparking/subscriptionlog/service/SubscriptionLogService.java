package com.ministerio.starparking.subscriptionlog.service;

import com.ministerio.starparking.client.model.Client;
import com.ministerio.starparking.client.repository.ClientRepository;
import com.ministerio.starparking.subscription.model.Subscription;
import com.ministerio.starparking.subscription.repository.SubscriptionRepository;
import com.ministerio.starparking.subscriptionlog.dto.SubscriptionLogRequest;
import com.ministerio.starparking.subscriptionlog.dto.SubscriptionLogResponse;
import com.ministerio.starparking.subscriptionlog.model.SubscriptionLog;
import com.ministerio.starparking.subscriptionlog.repository.SubscriptionLogRepository;
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

    public SubscriptionLogResponse create(SubscriptionLogRequest request) {
        SubscriptionLog entity = new SubscriptionLog();
        applyRequest(entity, request);
        return toResponse(repository.save(entity));
    }

    public SubscriptionLogResponse update(Long id, SubscriptionLogRequest request) {
        SubscriptionLog entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SubscriptionLog not found: " + id));
        applyRequest(entity, request);
        return toResponse(repository.save(entity));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) throw new EntityNotFoundException("SubscriptionLog not found: " + id);
        repository.deleteById(id);
    }

    private void applyRequest(SubscriptionLog entity, SubscriptionLogRequest request) {
        Client client = clientRepository.findById(request.getClientId())
                .orElseThrow(() -> new EntityNotFoundException("Client not found: " + request.getClientId()));
        Subscription subscription = subscriptionRepository.findById(request.getSubscriptionId())
                .orElseThrow(() -> new EntityNotFoundException("Subscription not found: " + request.getSubscriptionId()));

        entity.setClient(client);
        entity.setSubscription(subscription);
        entity.setStartsAt(request.getStartsAt());
        entity.setEndsAt(request.getEndsAt());
        entity.setSubscriptionStatus(request.getSubscriptionStatus());
    }

    private SubscriptionLogResponse toResponse(SubscriptionLog entity) {
        return SubscriptionLogResponse.builder()
                .id(entity.getId())
                .clientId(entity.getClient() != null ? entity.getClient().getId() : null)
                .clientName(entity.getClient() != null ? entity.getClient().getFullName() : null)
                .subscriptionId(entity.getSubscription() != null ? entity.getSubscription().getId() : null)
                .subscriptionName(entity.getSubscription() != null ? entity.getSubscription().getName() : null)
                .startsAt(entity.getStartsAt())
                .endsAt(entity.getEndsAt())
                .subscriptionStatus(entity.getSubscriptionStatus())
                .active(entity.isActive())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
