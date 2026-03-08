package com.ministerio.starparking.entity.parkinguse.service;

import com.ministerio.starparking.entity.bill.model.Bill;
import com.ministerio.starparking.entity.bill.repository.BillRepository;
import com.ministerio.starparking.entity.parkingspot.model.ParkingSpot;
import com.ministerio.starparking.entity.parkingspot.repository.ParkingSpotRepository;
import com.ministerio.starparking.entity.parkinguse.dto.ParkingUseRequest;
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
                .orElseThrow(() -> new EntityNotFoundException("ParkingUse not found: " + id)));
    }

    public ParkingUseResponse create(ParkingUseRequest request) {
        ParkingUse entity = new ParkingUse();
        applyRequest(entity, request);
        return toResponse(repository.save(entity));
    }

    public ParkingUseResponse update(Long id, ParkingUseRequest request) {
        ParkingUse entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ParkingUse not found: " + id));
        applyRequest(entity, request);
        return toResponse(repository.save(entity));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) throw new EntityNotFoundException("ParkingUse not found: " + id);
        repository.deleteById(id);
    }

    private void applyRequest(ParkingUse entity, ParkingUseRequest request) {
        Vehicle vehicle = vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found: " + request.getVehicleId()));
        ParkingSpot parkingSpot = parkingSpotRepository.findById(request.getParkingSpotId())
                .orElseThrow(() -> new EntityNotFoundException("ParkingSpot not found: " + request.getParkingSpotId()));

        entity.setVehicle(vehicle);
        entity.setParkingSpot(parkingSpot);
        entity.setEntryTime(request.getEntryTime());
        entity.setExitTime(request.getExitTime());

        if (request.getBillId() != null) {
            Bill bill = billRepository.findById(request.getBillId())
                    .orElseThrow(() -> new EntityNotFoundException("Bill not found: " + request.getBillId()));
            entity.setBill(bill);
        } else {
            entity.setBill(null);
        }
    }

    private ParkingUseResponse toResponse(ParkingUse entity) {
        return ParkingUseResponse.builder()
                .id(entity.getId())
                .vehicleId(entity.getVehicle() != null ? entity.getVehicle().getId() : null)
                .vehiclePlate(entity.getVehicle() != null ? entity.getVehicle().getPlate() : null)
                .parkingSpotId(entity.getParkingSpot() != null ? entity.getParkingSpot().getId() : null)
                .spotIdentifier(entity.getParkingSpot() != null ? entity.getParkingSpot().getSpotIdentifier() : null)
                .entryTime(entity.getEntryTime())
                .exitTime(entity.getExitTime())
                .stayMinutes(entity.getStayMinutes())
                .billId(entity.getBill() != null ? entity.getBill().getId() : null)
                .build();
    }
}
