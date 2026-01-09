package com.scheduledevelop.schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String authorName; // 작성자명
    private String title; // 일정 제목
    private String content; // 일정 내용


    public Schedule(String authorName, String title, String content) {
        this.authorName = authorName;
        this.title = title;
        this.content = content;

    }

    public void update(String authorName, String title, String content) {
        this.authorName = authorName;
        this.title = title;
        this.content = content;
    }
}