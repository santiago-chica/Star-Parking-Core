package com.ministerio.starparking.activity.repository;

import com.ministerio.starparking.activity.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
