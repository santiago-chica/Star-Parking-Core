package com.ministerio.starparking.client.repository;

import com.ministerio.starparking.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
