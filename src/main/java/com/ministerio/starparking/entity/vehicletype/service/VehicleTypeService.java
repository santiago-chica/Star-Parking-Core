package com.ministerio.starparking.entity.vehicletype.service;

import com.ministerio.starparking.entity.vehicletype.dto.VehicleTypeCreateRequest;
import com.ministerio.starparking.entity.vehicletype.dto.VehicleTypeUpdateRequest;
import com.ministerio.starparking.entity.vehicletype.dto.VehicleTypeResponse;
import com.ministerio.starparking.entity.vehicletype.model.VehicleType;
import com.ministerio.starparking.entity.vehicletype.repository.VehicleTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleTypeService {

    private final VehicleTypeRepository repository;

    public List<VehicleTypeResponse> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public VehicleTypeResponse findById(Long id) {
        return toResponse(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("VehicleType not found: " + id)));
    }

    public VehicleTypeResponse create(VehicleTypeCreateRequest request) {
        VehicleType entity = new VehicleType();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setCostPerMinute(request.getCostPerMinute());
        return toResponse(repository.save(entity));
    }

    public VehicleTypeResponse update(Long id, VehicleTypeUpdateRequest request) {
        VehicleType entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("VehicleType not found: " + id));
        if (request.getName() != null) entity.setName(request.getName());
        if (request.getDescription() != null) entity.setDescription(request.getDescription());
        if (request.getCostPerMinute() != null) entity.setCostPerMinute(request.getCostPerMinute());
        return toResponse(repository.save(entity));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) throw new EntityNotFoundException("VehicleType not found: " + id);
        repository.deleteById(id);
    }

    private VehicleTypeResponse toResponse(VehicleType entity) {
        return VehicleTypeResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .costPerMinute(entity.getCostPerMinute())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
