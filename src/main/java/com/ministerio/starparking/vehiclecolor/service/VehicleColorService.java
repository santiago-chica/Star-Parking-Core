package com.ministerio.starparking.vehiclecolor.service;

import com.ministerio.starparking.vehiclecolor.dto.VehicleColorRequest;
import com.ministerio.starparking.vehiclecolor.dto.VehicleColorResponse;
import com.ministerio.starparking.vehiclecolor.model.VehicleColor;
import com.ministerio.starparking.vehiclecolor.repository.VehicleColorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleColorService {

    private final VehicleColorRepository repository;

    public List<VehicleColorResponse> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public VehicleColorResponse findById(Long id) {
        return toResponse(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("VehicleColor not found: " + id)));
    }

    public VehicleColorResponse create(VehicleColorRequest request) {
        VehicleColor entity = new VehicleColor();
        applyRequest(entity, request);
        return toResponse(repository.save(entity));
    }

    public VehicleColorResponse update(Long id, VehicleColorRequest request) {
        VehicleColor entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("VehicleColor not found: " + id));
        applyRequest(entity, request);
        return toResponse(repository.save(entity));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) throw new EntityNotFoundException("VehicleColor not found: " + id);
        repository.deleteById(id);
    }

    private void applyRequest(VehicleColor entity, VehicleColorRequest request) {
        entity.setColorName(request.getColorName());
        entity.setHexCode(request.getHexCode());
    }

    private VehicleColorResponse toResponse(VehicleColor entity) {
        return VehicleColorResponse.builder()
                .id(entity.getId())
                .colorName(entity.getColorName())
                .hexCode(entity.getHexCode())
                .build();
    }
}
