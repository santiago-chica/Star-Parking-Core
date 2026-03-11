package com.ministerio.starparking.entity.vehiclecolor.service;

import com.ministerio.starparking.entity.vehiclecolor.dto.VehicleColorCreateRequest;
import com.ministerio.starparking.entity.vehiclecolor.dto.VehicleColorUpdateRequest;
import com.ministerio.starparking.entity.vehiclecolor.dto.VehicleColorResponse;
import com.ministerio.starparking.entity.vehiclecolor.model.VehicleColor;
import com.ministerio.starparking.entity.vehiclecolor.repository.VehicleColorRepository;
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
                .orElseThrow(() -> new EntityNotFoundException("No se encontró ningún color de vehículo con el ID: " + id)));
    }

    public VehicleColorResponse create(VehicleColorCreateRequest request) {
        VehicleColor entity = new VehicleColor();
        entity.setColorName(request.getColorName());
        entity.setHexCode(request.getHexCode());
        return toResponse(repository.save(entity));
    }

    public VehicleColorResponse update(Long id, VehicleColorUpdateRequest request) {
        VehicleColor entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró ningún color de vehículo con el ID: " + id));
        if (request.getColorName() != null) entity.setColorName(request.getColorName());
        if (request.getHexCode() != null) entity.setHexCode(request.getHexCode());
        return toResponse(repository.save(entity));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) throw new EntityNotFoundException("No se encontró ningún color de vehículo con el ID: " + id);
        repository.deleteById(id);
    }

    private VehicleColorResponse toResponse(VehicleColor entity) {
        return VehicleColorResponse.builder()
                .id(entity.getId())
                .colorName(entity.getColorName())
                .hexCode(entity.getHexCode())
                .build();
    }
}
