package com.ministerio.starparking.entity.vehicle.service;

import com.ministerio.starparking.entity.client.model.Client;
import com.ministerio.starparking.entity.client.repository.ClientRepository;
import com.ministerio.starparking.entity.vehicle.dto.VehicleRequest;
import com.ministerio.starparking.entity.vehicle.dto.VehicleResponse;
import com.ministerio.starparking.entity.vehicle.model.Vehicle;
import com.ministerio.starparking.entity.vehicle.repository.VehicleRepository;
import com.ministerio.starparking.entity.vehiclecolor.model.VehicleColor;
import com.ministerio.starparking.entity.vehiclecolor.repository.VehicleColorRepository;
import com.ministerio.starparking.entity.vehicletype.model.VehicleType;
import com.ministerio.starparking.entity.vehicletype.repository.VehicleTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository repository;
    private final ClientRepository clientRepository;
    private final VehicleTypeRepository vehicleTypeRepository;
    private final VehicleColorRepository vehicleColorRepository;

    public List<VehicleResponse> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public VehicleResponse findById(Long id) {
        return toResponse(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found: " + id)));
    }

    public VehicleResponse create(VehicleRequest request) {
        Vehicle entity = new Vehicle();
        applyRequest(entity, request);
        return toResponse(repository.save(entity));
    }

    public VehicleResponse update(Long id, VehicleRequest request) {
        Vehicle entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found: " + id));
        applyRequest(entity, request);
        return toResponse(repository.save(entity));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) throw new EntityNotFoundException("Vehicle not found: " + id);
        repository.deleteById(id);
    }

    private void applyRequest(Vehicle entity, VehicleRequest request) {
        Client client = clientRepository.findById(request.getClientId())
                .orElseThrow(() -> new EntityNotFoundException("Client not found: " + request.getClientId()));
        VehicleType vehicleType = vehicleTypeRepository.findById(request.getVehicleTypeId())
                .orElseThrow(() -> new EntityNotFoundException("VehicleType not found: " + request.getVehicleTypeId()));
        VehicleColor vehicleColor = vehicleColorRepository.findById(request.getVehicleColorId())
                .orElseThrow(() -> new EntityNotFoundException("VehicleColor not found: " + request.getVehicleColorId()));

        entity.setPlate(request.getPlate());
        entity.setClient(client);
        entity.setVehicleType(vehicleType);
        entity.setVehicleColor(vehicleColor);
        entity.setModel(request.getModel());
        entity.setBrand(request.getBrand());
    }

    private VehicleResponse toResponse(Vehicle entity) {
        return VehicleResponse.builder()
                .id(entity.getId())
                .plate(entity.getPlate())
                .clientId(entity.getClient() != null ? entity.getClient().getId() : null)
                .clientName(entity.getClient() != null ? entity.getClient().getFullName() : null)
                .vehicleTypeId(entity.getVehicleType() != null ? entity.getVehicleType().getId() : null)
                .vehicleTypeName(entity.getVehicleType() != null ? entity.getVehicleType().getName() : null)
                .vehicleColorId(entity.getVehicleColor() != null ? entity.getVehicleColor().getId() : null)
                .vehicleColorName(entity.getVehicleColor() != null ? entity.getVehicleColor().getColorName() : null)
                .model(entity.getModel())
                .brand(entity.getBrand())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
