package com.ministerio.starparking.entity.subscriptionlog.controller;

import com.ministerio.starparking.entity.subscriptionlog.dto.SubscriptionLogCreateRequest;
import com.ministerio.starparking.entity.subscriptionlog.dto.SubscriptionLogUpdateRequest;
import com.ministerio.starparking.entity.subscriptionlog.dto.SubscriptionLogResponse;
import com.ministerio.starparking.entity.subscriptionlog.service.SubscriptionLogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscription-logs")
@RequiredArgsConstructor
public class SubscriptionLogController {

    private final SubscriptionLogService service;

    @GetMapping
    public List<SubscriptionLogResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public SubscriptionLogResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SubscriptionLogResponse create(@Valid @RequestBody SubscriptionLogCreateRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public SubscriptionLogResponse update(@PathVariable Long id, @Valid @RequestBody SubscriptionLogUpdateRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
