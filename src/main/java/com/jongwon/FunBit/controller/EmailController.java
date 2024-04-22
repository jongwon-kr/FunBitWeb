package com.jongwon.FunBit.controller;

import com.jongwon.FunBit.Entity.EmailUser;
import com.jongwon.FunBit.repository.EmailUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private final EmailUserRepository emailUserRepository;

    @Autowired
    public EmailController(EmailUserRepository emailUserRepository) {
        this.emailUserRepository = emailUserRepository;
    }
}
