package com.scheduledevelop.schedule.entity;

import com.scheduledevelop.user.entity.User;
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
    private String title; // 일정 제목
    private String content; // 일정 내용

    // 연관관계의 주인
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public Schedule(String title, String content, User user) { // 작성자명 -> 유저 고유 식별자로 변경
        this.title = title;
        this.content = content;
        this.user = user;

    }

    public void update(String title, String content) { // 작성자명 -> 유저 고유 식별자로 변경
        this.title = title;
        this.content = content;
    }
}