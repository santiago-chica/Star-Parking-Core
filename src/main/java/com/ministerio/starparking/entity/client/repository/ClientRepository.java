package com.ministerio.starparking.entity.client.repository;

import com.ministerio.starparking.entity.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
