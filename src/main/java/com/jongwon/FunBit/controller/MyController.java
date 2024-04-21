package com.jongwon.FunBit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyController {

    @GetMapping("/my")
    public String myPage() {
        return "my";
    }

}
