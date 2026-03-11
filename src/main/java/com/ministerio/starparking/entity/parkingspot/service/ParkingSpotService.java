package com.ministerio.starparking.entity.parkingspot.service;

import com.ministerio.starparking.entity.parkingspot.dto.ParkingSpotCreateRequest;
import com.ministerio.starparking.entity.parkingspot.dto.ParkingSpotUpdateRequest;
import com.ministerio.starparking.entity.parkingspot.dto.ParkingSpotResponse;
import com.ministerio.starparking.entity.parkingspot.model.ParkingSpot;
import com.ministerio.starparking.entity.parkingspot.repository.ParkingSpotRepository;
import com.ministerio.starparking.entity.vehicle.model.Vehicle;
import com.ministerio.starparking.entity.vehicle.repository.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingSpotService {

    private final ParkingSpotRepository repository;
    private final VehicleRepository vehicleRepository;

    public List<ParkingSpotResponse> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public ParkingSpotResponse findById(Long id) {
        return toResponse(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ParkingSpot not found: " + id)));
    }

    public ParkingSpotResponse create(ParkingSpotCreateRequest request) {
        ParkingSpot entity = new ParkingSpot();
        entity.setSpotIdentifier(request.getSpotIdentifier());
        if (request.getVehicleId() != null) {
            Vehicle vehicle = vehicleRepository.findById(request.getVehicleId())
                    .orElseThrow(() -> new EntityNotFoundException("Vehicle not found: " + request.getVehicleId()));
            entity.setVehicle(vehicle);
        } else {
            entity.setVehicle(null);
        }
        return toResponse(repository.save(entity));
    }

    public ParkingSpotResponse update(Long id, ParkingSpotUpdateRequest request) {
        ParkingSpot entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ParkingSpot not found: " + id));
        entity.setSpotIdentifier(request.getSpotIdentifier());
        if (request.getVehicleId() != null) {
            Vehicle vehicle = vehicleRepository.findById(request.getVehicleId())
                    .orElseThrow(() -> new EntityNotFoundException("Vehicle not found: " + request.getVehicleId()));
            entity.setVehicle(vehicle);
        } else {
            entity.setVehicle(null);
        }
        return toResponse(repository.save(entity));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) throw new EntityNotFoundException("ParkingSpot not found: " + id);
        repository.deleteById(id);
    }

    private ParkingSpotResponse toResponse(ParkingSpot entity) {
        return ParkingSpotResponse.builder()
                .id(entity.getId())
                .spotIdentifier(entity.getSpotIdentifier())
                .vehicleId(entity.getVehicle() != null ? entity.getVehicle().getId() : null)
                .vehiclePlate(entity.getVehicle() != null ? entity.getVehicle().getPlate() : null)
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
