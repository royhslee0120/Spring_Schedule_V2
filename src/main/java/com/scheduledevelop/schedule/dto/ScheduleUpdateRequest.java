package com.scheduledevelop.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleUpdateRequest {

    private String authorName;
    private String title;
    private String content;

}
