package com.ministerio.starparking.user.repository;

import com.ministerio.starparking.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
