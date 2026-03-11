package com.ministerio.starparking.entity.bill.controller;

import com.ministerio.starparking.entity.bill.dto.BillCreateRequest;
import com.ministerio.starparking.entity.bill.dto.BillUpdateRequest;
import com.ministerio.starparking.entity.bill.dto.BillResponse;
import com.ministerio.starparking.entity.bill.service.BillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService service;

    @GetMapping
    public List<BillResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public BillResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BillResponse create(@Valid @RequestBody BillCreateRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public BillResponse update(@PathVariable Long id, @Valid @RequestBody BillUpdateRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
