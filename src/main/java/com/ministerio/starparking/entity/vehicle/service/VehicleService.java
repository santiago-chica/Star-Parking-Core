package com.ministerio.starparking.entity.vehicle.service;

import com.ministerio.starparking.entity.client.model.Client;
import com.ministerio.starparking.entity.client.repository.ClientRepository;
import com.ministerio.starparking.entity.vehicle.dto.VehicleCreateRequest;
import com.ministerio.starparking.entity.vehicle.dto.VehicleUpdateRequest;
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

    public VehicleResponse create(VehicleCreateRequest request) {
        Vehicle entity = new Vehicle();
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
        return toResponse(repository.save(entity));
    }

    public VehicleResponse update(Long id, VehicleUpdateRequest request) {
        Vehicle entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found: " + id));
        if (request.getPlate() != null) entity.setPlate(request.getPlate());
        if (request.getClientId() != null) {
            entity.setClient(clientRepository.findById(request.getClientId())
                    .orElseThrow(() -> new EntityNotFoundException("Client not found: " + request.getClientId())));
        }
        if (request.getVehicleTypeId() != null) {
            entity.setVehicleType(vehicleTypeRepository.findById(request.getVehicleTypeId())
                    .orElseThrow(() -> new EntityNotFoundException("VehicleType not found: " + request.getVehicleTypeId())));
        }
        if (request.getVehicleColorId() != null) {
            entity.setVehicleColor(vehicleColorRepository.findById(request.getVehicleColorId())
                    .orElseThrow(() -> new EntityNotFoundException("VehicleColor not found: " + request.getVehicleColorId())));
        }
        if (request.getModel() != null) entity.setModel(request.getModel());
        if (request.getBrand() != null) entity.setBrand(request.getBrand());
        return toResponse(repository.save(entity));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) throw new EntityNotFoundException("Vehicle not found: " + id);
        repository.deleteById(id);
    }

    private VehicleResponse toResponse(Vehicle entity) {
        VehicleResponse.ClientInfo clientInfo = entity.getClient() != null
                ? VehicleResponse.ClientInfo.builder()
                        .id(entity.getClient().getId())
                        .fullName(entity.getClient().getFullName())
                        .documentNumber(entity.getClient().getDocumentNumber())
                        .build()
                : null;
        VehicleResponse.VehicleTypeInfo typeInfo = entity.getVehicleType() != null
                ? VehicleResponse.VehicleTypeInfo.builder()
                        .id(entity.getVehicleType().getId())
                        .name(entity.getVehicleType().getName())
                        .costPerMinute(entity.getVehicleType().getCostPerMinute())
                        .build()
                : null;
        VehicleResponse.VehicleColorInfo colorInfo = entity.getVehicleColor() != null
                ? VehicleResponse.VehicleColorInfo.builder()
                        .id(entity.getVehicleColor().getId())
                        .colorName(entity.getVehicleColor().getColorName())
                        .hexCode(entity.getVehicleColor().getHexCode())
                        .build()
                : null;
        return VehicleResponse.builder()
                .id(entity.getId())
                .plate(entity.getPlate())
                .client(clientInfo)
                .vehicleType(typeInfo)
                .vehicleColor(colorInfo)
                .model(entity.getModel())
                .brand(entity.getBrand())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
