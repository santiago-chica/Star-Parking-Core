package com.ministerio.starparking.entity.payment.controller;

import com.ministerio.starparking.entity.payment.dto.PaymentCreateRequest;
import com.ministerio.starparking.entity.payment.dto.PaymentUpdateRequest;
import com.ministerio.starparking.entity.payment.dto.PaymentResponse;
import com.ministerio.starparking.entity.payment.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @GetMapping
    public List<PaymentResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PaymentResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponse create(@Valid @RequestBody PaymentCreateRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public PaymentResponse update(@PathVariable Long id, @Valid @RequestBody PaymentUpdateRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
