package com.ministerio.starparking.entity.user.repository;

import com.ministerio.starparking.entity.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
