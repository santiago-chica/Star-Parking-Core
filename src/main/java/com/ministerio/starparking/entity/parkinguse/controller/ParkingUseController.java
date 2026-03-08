package com.ministerio.starparking.entity.parkinguse.controller;

import com.ministerio.starparking.entity.parkinguse.dto.ParkingUseRequest;
import com.ministerio.starparking.entity.parkinguse.dto.ParkingUseResponse;
import com.ministerio.starparking.entity.parkinguse.service.ParkingUseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parking-uses")
@RequiredArgsConstructor
public class ParkingUseController {

    private final ParkingUseService service;

    @GetMapping
    public List<ParkingUseResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ParkingUseResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingUseResponse create(@Valid @RequestBody ParkingUseRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public ParkingUseResponse update(@PathVariable Long id, @Valid @RequestBody ParkingUseRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
