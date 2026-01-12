package com.scheduledevelop.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleUpdateResponse {

    private final long id;
    private final String userName; // 작성자명 -> 유저 고유 식별자로 변경
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public ScheduleUpdateResponse(long id, String userName, String title, String content, LocalDateTime createdAt, LocalDateTime modifiedAt) { // 작성자명 -> 유저 고유 식별자로 변경
        this.id = id;
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
