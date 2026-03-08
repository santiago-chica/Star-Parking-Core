package com.ministerio.starparking.entity.vehicletype.controller;

import com.ministerio.starparking.entity.vehicletype.dto.VehicleTypeRequest;
import com.ministerio.starparking.entity.vehicletype.dto.VehicleTypeResponse;
import com.ministerio.starparking.entity.vehicletype.service.VehicleTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle-types")
@RequiredArgsConstructor
public class VehicleTypeController {

    private final VehicleTypeService service;

    @GetMapping
    public List<VehicleTypeResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public VehicleTypeResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VehicleTypeResponse create(@Valid @RequestBody VehicleTypeRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public VehicleTypeResponse update(@PathVariable Long id, @Valid @RequestBody VehicleTypeRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
