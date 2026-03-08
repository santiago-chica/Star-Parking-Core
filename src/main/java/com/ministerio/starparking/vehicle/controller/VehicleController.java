package com.ministerio.starparking.vehicle.controller;

import com.ministerio.starparking.vehicle.dto.VehicleRequest;
import com.ministerio.starparking.vehicle.dto.VehicleResponse;
import com.ministerio.starparking.vehicle.service.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService service;

    @GetMapping
    public List<VehicleResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public VehicleResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VehicleResponse create(@Valid @RequestBody VehicleRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public VehicleResponse update(@PathVariable Long id, @Valid @RequestBody VehicleRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
