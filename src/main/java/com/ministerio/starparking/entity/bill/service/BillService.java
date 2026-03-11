package com.ministerio.starparking.entity.bill.service;

import com.ministerio.starparking.common.enums.BillStatus;
import com.ministerio.starparking.entity.bill.dto.BillCreateRequest;
import com.ministerio.starparking.entity.bill.dto.BillUpdateRequest;
import com.ministerio.starparking.entity.bill.dto.BillResponse;
import com.ministerio.starparking.entity.bill.model.Bill;
import com.ministerio.starparking.entity.bill.repository.BillRepository;
import com.ministerio.starparking.entity.client.model.Client;
import com.ministerio.starparking.entity.client.repository.ClientRepository;
import com.ministerio.starparking.entity.payment.model.Payment;
import com.ministerio.starparking.entity.payment.repository.PaymentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository repository;
    private final ClientRepository clientRepository;
    private final PaymentRepository paymentRepository;

    public List<BillResponse> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public BillResponse findById(Long id) {
        return toResponse(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bill not found: " + id)));
    }

    public BillResponse create(BillCreateRequest request) {
        Bill entity = new Bill();
        Client client = clientRepository.findById(request.getClientId())
                .orElseThrow(() -> new EntityNotFoundException("Client not found: " + request.getClientId()));
        entity.setClient(client);
        if (request.getPaymentId() != null) {
            entity.setPayment(paymentRepository.findById(request.getPaymentId())
                    .orElseThrow(() -> new EntityNotFoundException("Payment not found: " + request.getPaymentId())));
        }
        entity.setSubtotal(request.getSubtotal());
        entity.setDiscount(request.getDiscount());
        entity.setTax(request.getTax());
        entity.setBillStatus(request.getBillStatus() != null ? request.getBillStatus() : BillStatus.PENDING);
        entity.setNotes(request.getNotes());
        return toResponse(repository.save(entity));
    }

    public BillResponse update(Long id, BillUpdateRequest request) {
        Bill entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bill not found: " + id));
        if (request.getPaymentId() != null) {
            entity.setPayment(paymentRepository.findById(request.getPaymentId())
                    .orElseThrow(() -> new EntityNotFoundException("Payment not found: " + request.getPaymentId())));
        } else {
            entity.setPayment(null);
        }
        entity.setBillStatus(request.getBillStatus());
        entity.setNotes(request.getNotes());
        return toResponse(repository.save(entity));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) throw new EntityNotFoundException("Bill not found: " + id);
        repository.deleteById(id);
    }

    private BillResponse toResponse(Bill entity) {
        return BillResponse.builder()
                .id(entity.getId())
                .clientId(entity.getClient() != null ? entity.getClient().getId() : null)
                .clientName(entity.getClient() != null ? entity.getClient().getFullName() : null)
                .paymentId(entity.getPayment() != null ? entity.getPayment().getId() : null)
                .subtotal(entity.getSubtotal())
                .discount(entity.getDiscount())
                .tax(entity.getTax())
                .total(entity.getTotal())
                .billStatus(entity.getBillStatus())
                .notes(entity.getNotes())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
