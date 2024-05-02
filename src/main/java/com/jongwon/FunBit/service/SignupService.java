package com.jongwon.FunBit.service;

import com.jongwon.FunBit.Entity.User;
import com.jongwon.FunBit.dto.UserDTO;
import com.jongwon.FunBit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignupService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public SignupService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void signup(UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();

        boolean isExist = userRepository.existsByUsername(username);
        if (isExist) {
            return;
        }
        System.out.println("??");
        User user = new User();
        user.setUsername(username);
        // 비밀번호 암호화
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setRole("ROLE_ADMIN");

        // 사용자 정보 저장(회원가입)
        userRepository.save(user);
    }
}
