package com.ministerio.starparking.entity.activity.controller;

import com.ministerio.starparking.entity.activity.dto.ActivityRequest;
import com.ministerio.starparking.entity.activity.dto.ActivityResponse;
import com.ministerio.starparking.entity.activity.service.ActivityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService service;

    @GetMapping
    public List<ActivityResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ActivityResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ActivityResponse create(@Valid @RequestBody ActivityRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public ActivityResponse update(@PathVariable Long id, @Valid @RequestBody ActivityRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
