package com.scheduledevelop.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleCreateRequest {

    private String authorName;
    private String title;
    private String content;
}