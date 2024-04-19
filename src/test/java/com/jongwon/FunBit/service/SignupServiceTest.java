package com.jongwon.FunBit.service;


import com.jongwon.FunBit.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class SignupServiceTest {

    private UserRepository userRepository;

    @Autowired
    SignupServiceTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    public void testUser() {

        boolean isExist = userRepository.existsByUsername("growjong");
        if (isExist) {
            return;
        }

        // 사용자 정보 저장(회원가입)
        userRepository.findByUsername("growjong");
    }
}