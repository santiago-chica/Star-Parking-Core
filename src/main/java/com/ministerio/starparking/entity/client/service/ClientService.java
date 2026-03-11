package com.ministerio.starparking.entity.client.service;

import com.ministerio.starparking.entity.client.dto.ClientCreateRequest;
import com.ministerio.starparking.entity.client.dto.ClientUpdateRequest;
import com.ministerio.starparking.entity.client.dto.ClientResponse;
import com.ministerio.starparking.entity.client.model.Client;
import com.ministerio.starparking.entity.client.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    public List<ClientResponse> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public ClientResponse findById(Long id) {
        return toResponse(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client not found: " + id)));
    }

    public ClientResponse create(ClientCreateRequest request) {
        Client entity = new Client();
        entity.setFullName(request.getFullName());
        entity.setDocumentType(request.getDocumentType());
        entity.setDocumentNumber(request.getDocumentNumber());
        entity.setPhoneNumber(request.getPhoneNumber());
        entity.setEmail(request.getEmail());
        entity.setAddress(request.getAddress());
        entity.setIsActive(true);
        return toResponse(repository.save(entity));
    }

    public ClientResponse update(Long id, ClientUpdateRequest request) {
        Client entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client not found: " + id));
        entity.setFullName(request.getFullName());
        entity.setDocumentType(request.getDocumentType());
        entity.setDocumentNumber(request.getDocumentNumber());
        entity.setPhoneNumber(request.getPhoneNumber());
        entity.setEmail(request.getEmail());
        entity.setAddress(request.getAddress());
        entity.setIsActive(request.getIsActive());
        return toResponse(repository.save(entity));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) throw new EntityNotFoundException("Client not found: " + id);
        repository.deleteById(id);
    }

    private ClientResponse toResponse(Client entity) {
        return ClientResponse.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .documentType(entity.getDocumentType())
                .documentNumber(entity.getDocumentNumber())
                .phoneNumber(entity.getPhoneNumber())
                .email(entity.getEmail())
                .address(entity.getAddress())
                .isActive(entity.getIsActive())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
