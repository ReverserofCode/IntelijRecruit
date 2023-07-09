package com.recruit.kr.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
public class SecurityController {
    @GetMapping("/login")
    public void getLoginPage(){
        log.info("call by Login page");
    }
}

