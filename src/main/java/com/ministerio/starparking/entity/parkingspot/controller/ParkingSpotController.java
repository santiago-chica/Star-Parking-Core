package com.ministerio.starparking.entity.parkingspot.controller;

import com.ministerio.starparking.entity.parkingspot.dto.ParkingSpotRequest;
import com.ministerio.starparking.entity.parkingspot.dto.ParkingSpotResponse;
import com.ministerio.starparking.entity.parkingspot.service.ParkingSpotService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parking-spots")
@RequiredArgsConstructor
public class ParkingSpotController {

    private final ParkingSpotService service;

    @GetMapping
    public List<ParkingSpotResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ParkingSpotResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingSpotResponse create(@Valid @RequestBody ParkingSpotRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public ParkingSpotResponse update(@PathVariable Long id, @Valid @RequestBody ParkingSpotRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
