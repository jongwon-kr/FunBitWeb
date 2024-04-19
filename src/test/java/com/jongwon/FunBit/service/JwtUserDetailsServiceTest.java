package com.jongwon.FunBit.service;


import com.jongwon.FunBit.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

class JwtUserDetailsServiceTest {

    Logger logger = LoggerFactory.getLogger(JwtUserDetailsServiceTest.class);

    private final UserRepository userRepository;

    @Autowired
    public JwtUserDetailsServiceTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}