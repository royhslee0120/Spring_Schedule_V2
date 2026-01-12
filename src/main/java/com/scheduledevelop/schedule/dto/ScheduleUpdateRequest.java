package com.scheduledevelop.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleUpdateRequest {

    private String userId; // 작성자명 -> 유저 고유 식별자로 변경
    private String title;
    private String content;

}
