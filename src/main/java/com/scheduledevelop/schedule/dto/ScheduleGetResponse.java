package com.scheduledevelop.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleGetResponse {

    private final long id;
    private final String name; // 작성자명 -> 유저 고유 식별자로 변경
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public ScheduleGetResponse(long id, String name, String title, String content, LocalDateTime createdAt, LocalDateTime modifiedAt) { // 작성자명 -> 유저 고유 식별자로 변경
        this.id = id;
        this.name = name; // 작성자명 -> 유저 고유 식별자로 변경
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}