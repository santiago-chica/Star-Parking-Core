package com.ministerio.starparking.payment.service;

import com.ministerio.starparking.payment.dto.PaymentRequest;
import com.ministerio.starparking.payment.dto.PaymentResponse;
import com.ministerio.starparking.payment.model.Payment;
import com.ministerio.starparking.payment.repository.PaymentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;

    public List<PaymentResponse> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public PaymentResponse findById(Long id) {
        return toResponse(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found: " + id)));
    }

    public PaymentResponse create(PaymentRequest request) {
        Payment entity = new Payment();
        applyRequest(entity, request);
        return toResponse(repository.save(entity));
    }

    public PaymentResponse update(Long id, PaymentRequest request) {
        Payment entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found: " + id));
        applyRequest(entity, request);
        return toResponse(repository.save(entity));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) throw new EntityNotFoundException("Payment not found: " + id);
        repository.deleteById(id);
    }

    private void applyRequest(Payment entity, PaymentRequest request) {
        entity.setAmount(request.getAmount());
        entity.setPaymentMethod(request.getPaymentMethod());
        entity.setPaymentReference(request.getPaymentReference());
    }

    private PaymentResponse toResponse(Payment entity) {
        return PaymentResponse.builder()
                .id(entity.getId())
                .amount(entity.getAmount())
                .paymentMethod(entity.getPaymentMethod())
                .paymentReference(entity.getPaymentReference())
                .billId(entity.getBill() != null ? entity.getBill().getId() : null)
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
