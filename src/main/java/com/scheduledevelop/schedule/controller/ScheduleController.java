package com.scheduledevelop.schedule.controller;

import com.scheduledevelop.schedule.dto.*;
import com.scheduledevelop.schedule.service.ScheduleService;
import com.scheduledevelop.user.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleCreateResponse> create(
            @SessionAttribute(name = "loginUser", required = false) SessionUser sessionUser,
            @RequestBody ScheduleCreateRequest request
    ) {
        if (sessionUser == null) {
            throw new IllegalStateException("로그인이 필요합니다.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.save(request));
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleGetResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findAll());
    }

    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleGetResponse> getOne(
            @PathVariable Long scheduleId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findOne(scheduleId));
    }

    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleUpdateResponse> update(
            @PathVariable Long scheduleId,
            @RequestBody ScheduleUpdateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.update(scheduleId, request));
    }

    @DeleteMapping("/schedules/{scheduleId}")
    public void delete(
            @PathVariable Long scheduleId
    ) {
        scheduleService.delete(scheduleId);
    }

}