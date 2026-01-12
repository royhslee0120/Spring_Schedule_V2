package com.scheduledevelop.user.controller;

import com.scheduledevelop.user.dto.*;
import com.scheduledevelop.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<SignupUserResponse> signup(
            @Valid @RequestBody SignupUserRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(request));
    }

    @PostMapping("/login")
    public void login(
            @Valid @RequestBody LoginUserRequest request, HttpSession session
    ) {
        LoginUserResponse result = userService.signin(request);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(
            @SessionAttribute(name = "loginUser", required = false) SessionUser sessionUser,
            HttpSession session
    ) {
        if (sessionUser == null) {
            return ResponseEntity.badRequest().build();
        }

        session.invalidate();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserGetResponse>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserGetResponse> getOne(@PathVariable Long userId) { // 오류 코드 수정
        return ResponseEntity.ok(userService.findOne(userId)); // 오류 코드 수정
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<UserUpdateResponse> update(
            @PathVariable Long userId,
            @Valid @RequestBody UserUpdateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(userId, request));
    }

    @DeleteMapping("/users/{userId}")
    public void delete(
            @PathVariable Long userId,
            @RequestParam String password
    ) {
        userService.delete(userId, password);
    }
}
