package com.scheduledevelop.user.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserUpdateRequest {

    private String email;

    @Size(min = 8, message = "비밀번호는 8자리 이상이어야 합니다.")
    private String password;
}
