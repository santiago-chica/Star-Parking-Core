package com.ministerio.starparking.entity.parkinguse.service;

import com.ministerio.starparking.entity.bill.model.Bill;
import com.ministerio.starparking.entity.bill.repository.BillRepository;
import com.ministerio.starparking.entity.parkingspot.model.ParkingSpot;
import com.ministerio.starparking.entity.parkingspot.repository.ParkingSpotRepository;
import com.ministerio.starparking.entity.parkinguse.dto.ParkingUseCreateRequest;
import com.ministerio.starparking.entity.parkinguse.dto.ParkingUseUpdateRequest;
import com.ministerio.starparking.entity.parkinguse.dto.ParkingUseResponse;
import com.ministerio.starparking.entity.parkinguse.model.ParkingUse;
import com.ministerio.starparking.entity.parkinguse.repository.ParkingUseRepository;
import com.ministerio.starparking.entity.vehicle.model.Vehicle;
import com.ministerio.starparking.entity.vehicle.repository.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingUseService {

    private final ParkingUseRepository repository;
    private final VehicleRepository vehicleRepository;
    private final ParkingSpotRepository parkingSpotRepository;
    private final BillRepository billRepository;

    public List<ParkingUseResponse> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public ParkingUseResponse findById(Long id) {
        return toResponse(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró ningún uso de parqueo con el ID: " + id)));
    }

    public ParkingUseResponse create(ParkingUseCreateRequest request) {
        ParkingUse entity = new ParkingUse();
        Vehicle vehicle = vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() -> new EntityNotFoundException("No se encontró ningún vehículo con el ID: " + request.getVehicleId()));
        ParkingSpot parkingSpot = parkingSpotRepository.findById(request.getParkingSpotId())
                .orElseThrow(() -> new EntityNotFoundException("No se encontró ningún espacio de parqueo con el ID: " + request.getParkingSpotId()));
        entity.setVehicle(vehicle);
        entity.setParkingSpot(parkingSpot);
        entity.setEntryTime(request.getEntryTime());
        entity.setExitTime(request.getExitTime());
        if (request.getBillId() != null) {
            entity.setBill(billRepository.findById(request.getBillId())
                    .orElseThrow(() -> new EntityNotFoundException("No se encontró ninguna factura con el ID: " + request.getBillId())));
        }
        return toResponse(repository.save(entity));
    }

    public ParkingUseResponse update(Long id, ParkingUseUpdateRequest request) {
        ParkingUse entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró ningún uso de parqueo con el ID: " + id));
        if (request.getVehicleId() != null) {
            entity.setVehicle(vehicleRepository.findById(request.getVehicleId())
                    .orElseThrow(() -> new EntityNotFoundException("No se encontró ningún vehículo con el ID: " + request.getVehicleId())));
        }
        if (request.getParkingSpotId() != null) {
            entity.setParkingSpot(parkingSpotRepository.findById(request.getParkingSpotId())
                    .orElseThrow(() -> new EntityNotFoundException("No se encontró ningún espacio de parqueo con el ID: " + request.getParkingSpotId())));
        }
        if (request.getEntryTime() != null) entity.setEntryTime(request.getEntryTime());
        if (request.getExitTime() != null) entity.setExitTime(request.getExitTime());
        if (request.getBillId() != null) {
            entity.setBill(billRepository.findById(request.getBillId())
                    .orElseThrow(() -> new EntityNotFoundException("No se encontró ninguna factura con el ID: " + request.getBillId())));
        } else {
            entity.setBill(null);
        }
        return toResponse(repository.save(entity));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) throw new EntityNotFoundException("No se encontró ningún uso de parqueo con el ID: " + id);
        repository.deleteById(id);
    }

    private ParkingUseResponse toResponse(ParkingUse entity) {
        ParkingUseResponse.VehicleInfo vehicleInfo = entity.getVehicle() != null
                ? ParkingUseResponse.VehicleInfo.builder()
                        .id(entity.getVehicle().getId())
                        .plate(entity.getVehicle().getPlate())
                        .model(entity.getVehicle().getModel())
                        .brand(entity.getVehicle().getBrand())
                        .build()
                : null;
        ParkingUseResponse.ParkingSpotInfo spotInfo = entity.getParkingSpot() != null
                ? ParkingUseResponse.ParkingSpotInfo.builder()
                        .id(entity.getParkingSpot().getId())
                        .spotIdentifier(entity.getParkingSpot().getSpotIdentifier())
                        .build()
                : null;
        ParkingUseResponse.BillInfo billInfo = entity.getBill() != null
                ? ParkingUseResponse.BillInfo.builder()
                        .id(entity.getBill().getId())
                        .billStatus(entity.getBill().getBillStatus())
                        .total(entity.getBill().getTotal())
                        .build()
                : null;
        return ParkingUseResponse.builder()
                .id(entity.getId())
                .vehicle(vehicleInfo)
                .parkingSpot(spotInfo)
                .entryTime(entity.getEntryTime())
                .exitTime(entity.getExitTime())
                .stayMinutes(entity.getStayMinutes())
                .bill(billInfo)
                .build();
    }
}
