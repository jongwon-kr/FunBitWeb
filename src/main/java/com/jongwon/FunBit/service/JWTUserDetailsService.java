package com.jongwon.FunBit.service;

import com.jongwon.FunBit.Entity.User;
import com.jongwon.FunBit.dto.JWTUserDetails;
import com.jongwon.FunBit.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JWTUserDetailsService implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(JWTUserDetailsService.class);

    private final UserRepository userRepository;

    @Autowired
    public JWTUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //DB에서 조회
        User userData = userRepository.findByUsername(username);

        if (userData != null) {

            return new JWTUserDetails(userData);
        }
        return null;
    }
}
