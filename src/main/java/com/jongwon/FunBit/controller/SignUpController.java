package com.jongwon.FunBit.controller;

import com.jongwon.FunBit.dto.UserDTO;
import com.jongwon.FunBit.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

    private SignupService signupService;

    @Autowired
    public SignUpController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserDTO userDTO) {
        // 사용자 정보를 User 엔티티로 변환
        signupService.signup(userDTO);

        // 회원가입 성공 시 응답
        return ResponseEntity.status(HttpStatus.CREATED).body("User signed up successfully!");
    }
}
