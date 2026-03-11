package com.ministerio.starparking.entity.vehiclecolor.controller;

import com.ministerio.starparking.entity.vehiclecolor.dto.VehicleColorCreateRequest;
import com.ministerio.starparking.entity.vehiclecolor.dto.VehicleColorUpdateRequest;
import com.ministerio.starparking.entity.vehiclecolor.dto.VehicleColorResponse;
import com.ministerio.starparking.entity.vehiclecolor.service.VehicleColorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle-colors")
@RequiredArgsConstructor
public class VehicleColorController {

    private final VehicleColorService service;

    @GetMapping
    public List<VehicleColorResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public VehicleColorResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VehicleColorResponse create(@Valid @RequestBody VehicleColorCreateRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public VehicleColorResponse update(@PathVariable Long id, @Valid @RequestBody VehicleColorUpdateRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
