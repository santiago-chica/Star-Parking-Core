package com.ministerio.starparking.entity.activity.repository;

import com.ministerio.starparking.entity.activity.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
